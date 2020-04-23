package offer;

public class Solution2 {
    public static void main(String[] args){

    }
    public String replaceSpace(StringBuffer str) {
        char[] strarr = str.toString().toCharArray();
        StringBuffer result = new StringBuffer();
        int num = 0;
        for (int i = 0; i < strarr.length; i++) {

            if (strarr[i] == ' '){
                result.append("%20");
            }else {
                result.append(strarr[i]);
            }
        }
        return result.toString();
    }
}
