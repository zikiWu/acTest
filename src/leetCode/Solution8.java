package leetCode;

public class Solution8 {
    public static void main(String[] args) {

        System.out.println("0123456789".charAt(0));
        new Solution8().myAtoi("0193 with words");
        new Solution8().myAtoi("+9193 with words");
        new Solution8().myAtoi("    -4193 with words");
        new Solution8().myAtoi("with words");
    }

    public int myAtoi(String str) {
        if (str.length() == 0){
            return 0;
        }
        while (str.startsWith(" ")) {
            str = str.substring(1);
        }
        StringBuilder s = new StringBuilder();
        char first = str.charAt(0);
        boolean ifCon = first>=48 && first <= 58;
        int i = ifCon ? 0 : 1;
        if (first == '+' || first == '-' || ifCon) {
            for (; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c>=48 && c <= 58) {
                    s.append(c);
                } else {
                    break;
                }
            }
        } else {
            return 0;
        }
        char[] cdhr =  s.toString().toCharArray();
        int ans = 0;
        int bol = first == '+'||ifCon?1:-1;
        for (int j = 0; j < s.length(); j++) {
            if(ans*bol > Integer.MAX_VALUE/10||ans*bol == Integer.MAX_VALUE / 10 && (cdhr[j] - 48) > 7 ){
                return Integer.MAX_VALUE;
            }
            if(ans*bol < Integer.MIN_VALUE/10||ans*bol == Integer.MIN_VALUE / 10 && (cdhr[j] - 48) > 8 ){
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + (cdhr[j] - 48);
        }
        ans=ans*bol;

        System.out.println(ans);
        return ans;
    }
}
