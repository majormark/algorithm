package com.stackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by major on 16/10/3.
 */

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 *
 */

public class TwoStacksSort {
    Stack<Integer> stack = new Stack();
    Stack<Integer> help = new Stack();

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        for(int i=numbers.length-1;i>=0;i--) {
            stack.push(numbers[i]);
        }
        help.push(stack.pop());
        while(!stack.empty()) {
            int stackTemp = stack.pop();

            if(stackTemp > help.peek()) {
                int count = 0;
                while(!help.empty()) {
                    if(help.peek() < stackTemp) {
                        stack.push(help.pop());
                        count++;
                    } else {
                        break;
                    }
                }

                help.push(stackTemp);
                while(count > 0) {
                    help.push(stack.pop());
                    count--;
                }
            } else {
                help.push(stackTemp);
            }
        }

        while(!help.empty()) {
            stack.push(help.pop());
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
