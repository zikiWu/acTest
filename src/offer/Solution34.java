package offer;

public class Solution34 {
    public static void main(String[] args){
        System.out.println(new Solution34().FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
    public int FirstNotRepeatingChar(String str) {
        int[] c = new int[256];
        char[] s = str.toCharArray();
        for (int j = 0; j < s.length; j++) {
            //大A
            c[s[j]-'A']++;
        }
        for (int j = 0; j < s.length; j++) {
            if (c[s[j]-'A'] == 1)
                return j;
        }
        return -1;
    }
}
