package offer;

public class Solution43 {
//    汇编语言中有一种移位指令叫做循环左移（ROL），
//    现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
//    对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
//    例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
//    即“XYZdefabc”。是不是很简单？OK，搞定它！
    public static void main(String[] args){
        new Solution43().LeftRotateString("abcXYZdef",3);
    }
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len < 2)
            return str;
        n = n % len;
        String s1 = str.substring(0,n);
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            sb.deleteCharAt(0);
            sb.append(s1.charAt(i));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
