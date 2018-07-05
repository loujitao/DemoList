package com.steve.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/**
 * @Author Loujitao
 * @Date 2018/7/3
 * @Time  14:54
 * @Description: 同步锁类得实现lock接口，实现对应的方法
 */
public class MyLock implements Lock{
    //这个是内部类的非公有同步器，辅助锁方法的实现
    private MyAQS myAQS=new MyAQS();

    //如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。
    @Override
    public void lock() {
        //调用的是AQS的方法
        myAQS.acquire(1);
    }
    //  如果当前线程未被中断，则获取锁。
    @Override
    public void lockInterruptibly() throws InterruptedException {
            myAQS.acquireInterruptibly(1);
    }
    //如果锁是自由的并且被当前线程获取，或者当前线程已经保持该锁，则返回 true；否则返回 false
    @Override
    public boolean tryLock() {
        return myAQS.tryAcquire(1);
    }
    //如果锁在给定等待时间内没有被另一个线程保持，且当前线程未被 中断，则获取该锁。
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return myAQS.tryAcquireNanos(1,unit.toNanos(time));
    }
    //如果当前线程是此锁所有者，则将保持计数减 1。如果保持计数现在为 0，则释放该锁
    @Override
    public void unlock() {
            myAQS.release(1);
    }
    @Override
    public Condition newCondition() {
        return newCondition();
    }
        /**
         * @Author Loujitao
         * @Date 2018/7/3
         * @Time  14:25
         * @Description: 同步器实现方式非公平的方式
         *为实现依赖于先进先出 (FIFO) 等待队列的阻塞锁和相关同步器（信号量、事件，等等）提供一个框架。
         * ReentrantLock的内部实现了两套AQS，公平的、非公平。当然你还可以自己在加几套，自己发挥
         */
    private class MyAQS extends AbstractQueuedSynchronizer{
        //试图在独占模式下获取对象状态。如果成功，则返回 true。
        @Override
        protected boolean tryAcquire(int arg) {
            //同步计数器 此类的设计目标是成为依靠单个原子int值来表示状态的大多数同步器的一个有用基础。
            int state=getState();
            Thread t=Thread.currentThread();
            //当前获取锁的对象为0时
            if(state==0){
                //使用CAS操作设置state的值，不能直接setState()
                if(compareAndSetState(0,arg)){
                    //这里讲t设置进去，是为了解重入锁的时候做判定依据
                    setExclusiveOwnerThread(t);
                    return true;
                };
                //这里是做重入锁的判定
            }else if(getExclusiveOwnerThread()==t){
                if(state<-1) throw new RuntimeException("state超出最小值0");
                //这里没做CAS操作，而是用的普通的set
                setState(state+1);
                return true;
            }
            return false;
        }
        //试图设置状态来反映独占模式下的一个释放。此方法总是由正在执行释放的线程调用。
        @Override
        protected boolean tryRelease(int arg) {
            //如果不是锁持线程来调用，需跑出异常
            if(Thread.currentThread()!=getExclusiveOwnerThread()){
                throw new  RuntimeException();
            }
            //因为只有锁持线程能进来，所以下面的设置不需要CAS，普通的set即可
            int state=getState()-arg;
            boolean flag=false;
            //当锁层次减为0时，说明对象释放了。讲状态清空
            if(getState()==0){
                setState(0);
                setExclusiveOwnerThread(null);
                flag=true;
            }
            setState(state);
            return flag;
        }
//        这两个是共享模式下的实现方法
//        @Override
//        protected int tryAcquireShared(int arg) {
//            return super.tryAcquireShared(arg);
//        }
//        @Override
//        protected boolean tryReleaseShared(int arg) {
//            return super.tryReleaseShared(arg);
//        }
        //因为实现lock接口，需要重写newCondition（），所以才写的，其实没用到
        Condition newCodition(){
            return new ConditionObject();
        }
    }


}
