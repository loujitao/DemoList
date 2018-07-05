package com.steve;

import java.util.Arrays;

/**
 * @Author Loujitao  
 * @Date 2018/5/21
 * @Time  14:09  
 * @Description:快速排序
 * 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 *  递归  的将p左边和右边的数都按照第一步进行，直到不能递归。
 */  
public class QuickSort {

    public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        quickSort(a,a.length/2,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[]a,int start,int end){
                    if(start<end){
                           int baseNum=a[start];//选基准值
                            int midNum;//记录中间值
                            int i=start;
                            int j=end;
                            do{
                                    while((a[i]<baseNum)&&i<end){
                                            i++;
                                        }
                                    while((a[j]>baseNum)&&j>start){
                                            j--;
                                        }
                                    if(i<=j){
                                            midNum=a[i];
                                            a[i]=a[j];
                                            a[j]=midNum;
                                            i++;
                                            j--;
                                        System.out.println(Arrays.toString(a));
                                        }
                                }while(i<=j);
                             if(start<j){
                                     quickSort(a,start,j);
                                 }
                             if(end>i){
                                     quickSort(a,i,end);
                                 }
                        }
                }
}
