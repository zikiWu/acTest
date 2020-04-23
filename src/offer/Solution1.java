package offer;

public class Solution1 {
    public static void main(String[] args){
        int x = 11 & 9;
        int y = x^3;
        System.out.println(y|12);
    }
    public boolean Find(int target, int [][] array) {

        if (array.length == 0)
            return false;
        int row = array.length;
        int col = array[0].length;
        int i = 0;
        int j = col-1;
        //右上角
        while (i < row && j >= 0){
            if (array[i][j] == target){
                return true;
            }
            if (array[i][j] > target){
                j--;
            }else {
                i++;
            }
        }
        return false;

    }
}
