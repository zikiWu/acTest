package offer;

public class Solution6 {
    public static void main(String[] args){

    }
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int i = array.length-1;
        while (i>0 && array[i] > array[i-1]){
            i--;

        }
        return array[i];
    }
}
