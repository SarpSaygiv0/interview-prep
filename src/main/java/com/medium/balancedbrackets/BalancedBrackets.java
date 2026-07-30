package com.medium.balancedbrackets;

import java.util.ArrayDeque;

public class BalancedBrackets {


    public boolean balancedBrackets(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || stack.pop() != c)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
