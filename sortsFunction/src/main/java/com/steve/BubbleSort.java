package com.steve;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @Author Loujitao
 * @Date 2018/5/18
 * @Time  11:14
 * @Description:冒泡排序法
 * 将序列中所有元素两两比较，将最大的放在最后面。
 * 将剩余序列中所有元素两两比较，将最大的放在最后面。
 * 重复第二步，直到只剩下一个数。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        bubbleSort(a,a.length+1);
        System.out.println(Arrays.toString(a));
    }

    public static int[] bubbleSort(int[] A, int n) {
        for (int i=0;i<A.length;i++){
            for (int j=i+1;j<A.length;j++){
                if (A[i] > A[j]){
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                    System.out.println("交换一次！");
                }
                System.out.println(Arrays.toString(A));
            }
        }

        return A;
    }

}
