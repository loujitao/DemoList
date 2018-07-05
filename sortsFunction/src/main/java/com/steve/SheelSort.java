package com.steve;

import java.util.Arrays;

/**
 * @Author Loujitao
 * @Date 2018/5/21
 * @Time  13:46
 * @Description:希尔排序，也称递减增量排序算法，
 * 是插入排序的一种更高效的改进版本。希尔排序是非稳定排序算法。
 */
public class SheelSort {
    public static void main(String[] args) {

        int[] a = {1,100,234,44,3,2,4,5};
        sheelSort( a);
        System.out.println(Arrays.toString(a));
    }

    public static void sheelSort(int [] a){
                int len=a.length;//单独把数组长度拿出来，提高效率
                 while(len!=0){
                     len=len/2;
                        for(int i=0;i<len;i++){//分组
                                 for(int j=i+len;j<a.length;j+=len){//元素从第二个开始
                                       int k=j-len;//k为有序序列最后一位的位数
                                        int temp=a[j];//要插入的元素
                                      /*for(;k>=0&&temp<a[k];k-=len){
10                         a[k+len]=a[k];
11                     }*/
                                         while(k>=0&&temp<a[k]){//从后往前遍历
                                               a[k+len]=a[k];
                                                k-=len;//向后移动len位
                                            }
                                         a[k+len]=temp;
                                     System.out.println(Arrays.toString(a));
                                    }
                            }
                    }
              }
}
