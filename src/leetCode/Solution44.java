package leetCode;

public class Solution44 {
    public static void main(String[] args){

        System.out.println(new Solution44().isMatch2("aa","a"));
        System.out.println(new Solution44().isMatch2("a","*"));
        System.out.println(new Solution44().isMatch2("cb","?a"));
        System.out.println(new Solution44().isMatch2("adceb","*a*b"));
        System.out.println(new Solution44().isMatch2("acdcb","a*c?b"));
        System.out.println(new Solution44().isMatch2("ab","?*"));
        System.out.println("++++++++++++++++++++");
        System.out.println(new Solution44().isMatch("aa","a"));
        System.out.println(new Solution44().isMatch("a","*"));
        System.out.println(new Solution44().isMatch("cb","?a"));

        System.out.println(new Solution44().isMatch("adceb","*a*b"));
        System.out.println(new Solution44().isMatch("acdcb","a*c?b"));
        System.out.println(new Solution44().isMatch("ab","?*"));

    }
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        boolean[][] arr = new boolean[m+1][n+1];
        arr[0][0] = true;
        for (int i = 1;i<=n;i++){
            arr[0][i] = arr[0][i-1]&&p.charAt(i-1)=='*';
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if (p.charAt(j-1)=='*'){
                    arr[i][j] = arr[i-1][j]||arr[i][j-1];
                }else {
                    arr[i][j] =  arr[i-1][j-1] && (p.charAt(j-1) == s.charAt(i-1)||p.charAt(j-1) == '?');
                }
            }
        }
        return arr[m][n];
    }
    public boolean isMatch2(String s, String p) {
        if ( p.isEmpty()){
            return s.isEmpty();
        }
        boolean is = !s.isEmpty()&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?');
        if (p.charAt(0)=='*'){
            return s.isEmpty()?isMatch(s,p.substring(1)):(isMatch(s.substring(1),p) || isMatch(s,p.substring(1)));
        }else {
            return is && isMatch(s.substring(1),p.substring(1)) ;
        }
    }
}
