package leetCode;

import java.util.Stack;

public class Solution20 {
    public static void main(String[] args){
        System.out.println(new Solution20().isValid("()[]{}"));
        System.out.println(new Solution20().isValid("(]"));
        System.out.println(new Solution20().isValid("([)]"));
        System.out.println(new Solution20().isValid("{[]}"));
        System.out.println(new Solution20().isValid("{}}"));

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0 ;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '{'||c == '['||c == '('){
                stack.push(c);
            }else if(stack.isEmpty() || getR(stack.pop())!=s.charAt(i)){
                return false;
            }
        }
        return stack.isEmpty();
    }
    public char getR(char s) {
        if (s == '{'){
            return '}';
        }
        if (s == '['){
            return ']';
        }
        if (s == '('){
            return ')';
        }
        return '0';
    }
}
