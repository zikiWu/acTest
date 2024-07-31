package leetCode;

public class Solution190 {
    public static void main(String[] args){
        new Solution190().reverseBits(6);
    }

    public int reverseBits(int n) {
        int rev = 0;
        for (int i =0; i < 32; i ++){
            rev |= (n & 1) << (31 - i);
            n = n >>> 1;
        }
        return rev;
    }


}
