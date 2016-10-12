package com.stackAndQueue;

import java.util.Stack;

/**
 * Created by major on 16/10/8.
 *
 * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，其中的节点与数组元素一一对应，
 * 同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。现有一建树方法，对于数组中的每个元素，
 * 其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。若两边都不存在比它大的数，那么它就是树根。
 * 请设计O(n)的算法实现这个方法。
 * 给定一个无重复元素的数组A和它的大小n，请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
 * 测试样例：
 * [3,1,4,2],4
 * 返回：[2,0,-1,2]

 */
public class MaxTree {

    public int[] buildMaxTree(int[] A, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[n];
        for(int i=0;i<n;i++) {
            temp[i] = -1;
        }
        for(int i=0;i<n;i++) {
            while (!stack.empty() && A[stack.peek()] < A[i]) {//这时出现了A[i]是一个比A[stack.peek()]大的值,说明它可能成为父节点,所以有下面的比较
                if(temp[stack.peek()] == -1 || A[temp[stack.peek()]] > A[i]) {
                    temp[stack.peek()] = i;
                }
                stack.pop();
            }
            if(!stack.empty()) {
                temp[i] = stack.peek();
            }
            stack.push(i);
        }
        return temp;
    }

}