package leetCode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 */
public class Solution5 {
    public static void main(String[] args){
        new Solution5().longestPalindrome("aacabdkacaa");
        new Solution5().longestPalindrome("aa");
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] a = new int[len+1][len+1];
        String s2 = "";
        for (int i = s.length() -1 ; i >= 0; i--){
            s2 += s.charAt(i);
        }

        int max = 0;
        int maxi = 0;
        int maxj = 0;
        for (int i = 0 ; i < len;i++){
            for (int j = 0 ; j < len;j++){
                if (s.charAt(i) == s2.charAt(j)){
                    if (i == 0 || j == 0){
                        a[i][j] = 1;
                    }else {
                        a[i][j] = a[i-1][j-1] + 1;
                    }
                }
                if (a[i][j] > max){
                    if ((len - 1 - j) + a[i][j] - 1 == i){
                        max = a[i][j];
                        maxi = i;
                    }
                }
            }
        }
        for (int i = 0 ; i < len;i++){
            for (int j = 0 ; j < len;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        return s.substring(maxi - max + 1, maxi + 1);
    }

}

 class Solution122 {
    public String longestPalindrome(String str) {
        if(str.length()<1){
            return "";
        }
        if(str.length()<2){
            return str;
        }
        char[] arr = manacherString(str);
        int R = -1; //记录当前最长的字串位置的下一个点的位置
        int c = -1; //记录当前最长的字串的中点
        int[] len = new int[arr.length];
        int max = 0;
        int maxI = 0;
        for (int i = 0;i<arr.length;i++){
            len[i] = R>i?Math.min(len[2*c-i],R-i):1;
            while (i+len[i]<arr.length && i-len[i]>-1){
                if(arr[i+len[i]] == arr[i-len[i]]){
                    len[i]++;
                }else {
                    break;
                }
            }
            if(i+len[i]>R){
                R = i+len[i];
                c = i;
                if(len[i]>max){
                    max = len[i];
                    maxI = i;
                }
            }
        }
        System.out.println(max-1);
        String result = "";
        for (int j = maxI -max+1;j<maxI+max;j++){
            result+=arr[j];
        }
        return result.replace("#","");
    }
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
}
