package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static void main(String[] args){
        new Solution54().spiralOrder(new int[][]{
                {1,21,3,4},{5,6,7,8},{9,1,8,0}
        });
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        int n = matrix.length;
        if(n == 0)
            return l;
        int m = matrix[0].length;
        boolean[][] seen = new boolean[n][m];
        int r = 0;
        int c = 0;
        //旋转矩阵，到旋转点，k+1，即得到不同的方向
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        int rr = 0;
        int cc = 0;
        int k = 0;
        for (int i = 0;i<n*m;i++){
            seen[r][c] = true;
            l.add(matrix[r][c]);
            rr = r + dr[k];
            cc = c + dc[k];
            if (rr >= n || cc >= m || rr <0 || cc <0 || seen[rr][cc]){
                k = (k+1)%4;
                r = r + dr[k];
                c = c + dc[k];
            }else {
                r = rr;
                c = cc;
            }
        }
        l.stream().forEach(System.out::print);
        return l;
    }
}
