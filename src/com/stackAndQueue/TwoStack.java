package com.stackAndQueue;

/**
 * Created by major on 16/9/29.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 *
 */

public class TwoStack {

    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();

    public int[] twoStack(int[] ope, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<ope.length;i++) {
            if(ope[i] == 0) {
                if(stackOut.empty()) {
                    while(!stackIn.empty()) {
                        stackOut.push(stackIn.pop());
                    }
                    list.add(stackOut.pop());
                } else {
                    list.add(stackOut.pop());
                }
            } else {
                stackIn.push(ope[i]);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
