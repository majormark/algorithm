package com.stackAndQueue;

/**
 * Created by major on 16/9/27.
 */

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * 要求每个操作的复杂度都为O(1)
 */

public class StackWithMin {
    private Stack<Integer> stack = null;
    private Stack<Integer> minStack = null;

    public StackWithMin() {
        stack = new Stack();
        minStack = new Stack();
    }
    public void push(int node) {
        stack.push(node);
        if(minStack.size() == 0) {
            minStack.push(node);
        } else {
            if(node < minStack.peek()) {
                minStack.push(node);
            }
        }
    }

    public void pop() {
        if(stack.empty())
            throw new RuntimeException("stack is empty.");

        int num = stack.pop();
        if(num == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if(minStack.empty()) {
            throw new RuntimeException("stack is empty.");
        }
        return minStack.peek();
    }
}
