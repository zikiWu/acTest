package leetCode;

public class Solution10 {
    public static void main(String[] args){

        System.out.println(new Solution10().isMatch("ab",".*"));
        System.out.println(new Solution10().isMatch("aab","c*a*b"));
        System.out.println(new Solution10().isMatch("mississippi","mis*is*p*."));
    }

    public boolean isMatch3(String s, String p) {



        return true;
    }




    //动态规划
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for(int i = 2; i <= n; i++){
            f[0][i] = f[0][i - 2] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 2] ||
                            f[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                }
            }
        }

        return f[m][n];
    }
    public boolean isMatch2(String s, String p) {

        if ( p.isEmpty()){
            return s.isEmpty();
        }
        boolean is = !s.isEmpty()&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length()>1 && p.charAt(1) == '*' ){
            return ( is&& isMatch2(s.substring(1),p)  )
                    || isMatch2(s,p.substring(2)) ;
        }else {
            return is && isMatch2(s.substring(1),p.substring(1));
        }
    }
}
