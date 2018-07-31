package com.steve.forkJoin;

import java.util.concurrent.*;

public class ForkJoinTest extends RecursiveTask<Integer> {

    private Integer start;
    private Integer end;

    public ForkJoinTest(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        if(end -start<=2){
            for(int i=start;i<=end;i++){
                sum +=i;
            }
        }else {
            ForkJoinTest fj1=new ForkJoinTest(start,(end+start)/2);
            ForkJoinTest fj2=new ForkJoinTest((end+start)/2+1,end);
            fj1.fork();
            fj2.fork();
           Integer a= fj1.join();
           Integer b=fj2.join();
           sum=a+b;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        ForkJoinTest test=new ForkJoinTest(1,100);
        ForkJoinPool pool=new ForkJoinPool( );

        Future<Integer> sum=  pool.submit(test);
        System.out.println("总结："+  sum.get());
    }
}
