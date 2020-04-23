package offer;

public class Solution33 {
    public static void main(String[] args){
        System.out.println(
                new Solution33().GetUglyNumber_Solution(4));
    }
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int[] arr = new int[index];
        arr[0] = 1;
        int min = 0;
        for (int i = 1; i < index; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j]*2>arr[i-1]){
                    min = arr[j]*2;
                    break;
                }
            }
            for (int j = 0; j < i; j++) {
                if (arr[j]*3>arr[i-1]){
                    min = Math.min(arr[j]*3,min);
                    break;
                }
            }
            for (int j = 0; j < i; j++) {
                if (arr[j]*5>arr[i-1]){
                    min = Math.min(arr[j]*5,min);
                    break;
                }
            }
            arr[i] = min;
        }
        return arr[index-1];
    }
}
