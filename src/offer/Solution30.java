package offer;

public class Solution30 {
    public static void main(String[] args){
        new Solution30().FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2});
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp += array[i];
            max = Math.max(temp,max);
            if (temp<=0)
                temp = 0;
        }
        System.out.println(max);
        return max;
    }
}
