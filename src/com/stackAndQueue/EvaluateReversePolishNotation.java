package com.stackAndQueue;

import java.util.Stack;

//150. Evaluate Reverse Polish Notation
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if (stack.size() < 2) {
                    return 0;
                }
                int right = stack.pop();
                int left = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        left = left + right;
                        break;
                    case "-":
                        left = left - right;
                        break;
                    case "*":
                        left = left * right;
                        break;
                    case "/":
                        left = left / right;
                }
                stack.push(left);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
