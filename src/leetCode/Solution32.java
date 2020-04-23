package leetCode;

public class Solution32 {
    public static void main(String[] args){


        System.out.println(new Solution32().longestValidParentheses(")()())"));

        System.out.println(new Solution32().longestValidParentheses(")())()())"));
        System.out.println(new Solution32().longestValidParentheses("())"));
        System.out.println(new Solution32().longestValidParentheses("()"));

        System.out.println(new Solution32().longestValidParentheses("(()())"));
    }
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] a = new int[s.length()];
        char[] c = s.toCharArray();
        a[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++){
            if (c[i] == ')' && c[i-1] == '('){
                a[i] = i-2>0?a[i-2]+2:2;
            }else if (c[i] == ')' && i-a[i-1]-1 >=0 && c[i-a[i-1]-1] == '(' ){
                int last =  i-a[i-1]-2<0?0:a[i-a[i-1]-2];
                a[i] = a[i-1] + 2 + last;
            }else {
                a[i] = 0;
            }
            max = Math.max(max,a[i]);
        }
        return max;
    }
}
