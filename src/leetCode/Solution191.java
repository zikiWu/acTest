package leetCode;

public class Solution191 {
    public static void main(String[] args){
        System.out.println(new Solution191().hammingWeight(128));

    }

    public int hammingWeight(int n) {
        int num = 0;
        while (n > 0){
            num += n & 1;
            n = n >> 1;
        }
        return num;
    }

}
