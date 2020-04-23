package offer;

import java.util.ArrayList;

public class Solution19 {
    public static void main(String[] args){
        new Solution19().printMatrix(new int[][]{{1,2,3,4},{5,6,7,8}});
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int[] a1 = new int[]{0,1,0,-1};
        int[] a2 = new int[]{1,0,-1,0};
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] b = new boolean[row][col];
        int i = 0;
        int j = 0;
        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = 0; k < row*col; k++) {
//            System.out.println(matrix[i][j]);
            b[i][j] = true;
            list.add(matrix[i][j]);
            int ii = i + a1[num];
            int jj = j + a2[num];
            if (ii>=row || jj>=col || ii<0 || jj<0 || b[ii][jj] ){
                num = (num+1)%4;
            }
            i += a1[num];
            j += a2[num];
        }
        return list;
    }
}
