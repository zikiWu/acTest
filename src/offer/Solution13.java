package offer;

public class Solution13 {
    public static void main(String[] args){

    }
    public void reOrderArray(int [] array) {
        int i = 0;
        int j = array.length-1;
        while (i<j){
            while (i<j && (array[i] & 0x1) == 1)
                i++;
            while (i<j && (array[i] & 0x1) == 0)
                j++;

        }
    }
}
