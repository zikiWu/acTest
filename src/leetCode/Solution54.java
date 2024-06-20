package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Solution54 {
    public static void main(String[] args){
        new Solution54().spiralOrder2(new int[][]{
                {1,21,3,4},{5,6,7,8},{9,1,8,0}
        });
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int r = matrix.length;
        int l = matrix[0].length;
        int[][] b = new int[r][l];
        int num = r * l;
        int index = 0;
        int i = 0;
        int j = 0;
        int[] ii = new int[]{0,1,0,-1};
        int[] jj = new int[]{1,0,-1,0};
        int key = 0;
        while (index < num){
            System.out.println(i + " " + j + " " + matrix[i][j]);
            result.add(matrix[i][j]);
            if (i + ii[key] >= r || i + ii[key] < 0 || j + jj[key] >= l || j + jj[key] < 0 || b[i + ii[key]][j + jj[key]] == -1){
                key = (key + 1) % 4;
            }
            b[i][j] = -1;
            i = i + ii[key];
            j = j + jj[key];
            index++;
        }
        return result;
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
