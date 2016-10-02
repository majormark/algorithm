package com.stackAndQueue;

/**
 * Created by major on 16/10/1.
 */

import java.util.Stack;

/**
 *实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 *
 */

public class StackReverse {
    Stack<Integer> stack = new Stack<>();

    public int[] reverseStack(int[] A, int n) {
        for(int i=A.length-1;i>=0;i--) {
            stack.push(A[i]);
        }
        reverse(stack);
        int[] result = new int[n];
        for (int i=0;i<n;i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public void reverse(Stack<Integer> stack) {
        if(stack.empty())
            return ;
        int result = get(stack);
        reverse(stack);
        stack.push(result);
    }

    public int get(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.empty())
            return result;
        int last = get(stack);
        stack.push(result);
        return last;
    }
}
