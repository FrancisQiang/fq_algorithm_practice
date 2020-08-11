package com.fq.lc.math;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * @author muXue
 * @date 2020/8/11 14:29
 */
public class 构建乘机数组 {

    public int[] constructArr(int[] a) {
        int[] result = new int[a.length];

        for (int i = 0, product = 1; i < result.length;  product *= a[i], i++) {
            result[i] = product;
        }

        for (int i = result.length - 1, product = 1; i >= 0 ; product *= a[i], i--) {
            result[i] *= product;
        }
        return result;
    }

}
