package leetCode;

public class Solution9 {
    public static void main(String[] args){

        System.out.println(new Solution9().isPalindrome(121));

        System.out.println(new Solution9().isPalindrome(-121));

        System.out.println(new Solution9().isPalindrome(100));
        System.out.println(new Solution9().isPalindrome(12344321));
    }
    public boolean isPalindrome(int x) {
        if (x < 0 || (x!=0 && x %10 == 0)){
            return false;
        }
        int rev = 0;
        while (rev<x){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return rev == x || rev/10 == x;
    }
}
