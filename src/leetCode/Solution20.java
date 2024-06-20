package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 */
public class Solution20 {
    public static void main(String[] args){
        System.out.println(new Solution20().isValid3(""));
        System.out.println(new Solution20().isValid3("()[]{}"));
        System.out.println(new Solution20().isValid3("(]"));
        System.out.println(new Solution20().isValid3("([)]"));
        System.out.println(new Solution20().isValid3("{[]}"));
        System.out.println(new Solution20().isValid3("{}}"));

    }

    public boolean isValid3(String s) {
        LinkedList<Character> l = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                l.addLast(c);
            }else {
                if (l.isEmpty()){
                    return false;
                }
                if ((l.getLast() == '(' && c  == ')') ||
                        (l.getLast() == '[' && c  == ']')||
                        (l.getLast() == '{' && c  == '}')) {
                    l.removeLast();
                }else {
                    return false;
                }
            }
        }
        return l.isEmpty();
    }







    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> m = new HashMap<>();
        m.put('{','}');
        m.put('(',')');
        m.put('[',']');
        for (int i = 0;i < s.length(); i++){
            char c = s.charAt(i);
            if (m.containsKey(c)){
                stack.push(c);
            }else if (!stack.empty() && m.get(stack.peek()) == c){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
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
