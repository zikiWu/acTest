package leetCode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 */
public class Solution71 {
    public static void main(String[] args){
        new Solution71().setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        new Solution71().setZeroes2(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int l = matrix[0].length;
        HashSet<Integer> rs = new HashSet<>();
        HashSet<Integer> ls = new HashSet<>();

        for (int i = 0; i < r; i++){
            for (int j = 0; j < l; j++){
                if (matrix[i][j] == 0){
                    rs.add(i);
                    ls.add(j);
                }
            }
        }
        for (Integer i: rs) {
            for (int j = 0; j < l; j++)
                matrix[i][j] = 0;
        }

        for (Integer i: ls) {
            for (int j = 0; j < r; j++)
                matrix[j][i] = 0;
        }
    }

    // 利用头行头列做额外空间
    public void setZeroes2(int[][] matrix) {
        int r = matrix.length;
        int l = matrix[0].length;
        boolean ii = false,jj = false;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < l; j++){
                if (matrix[i][j] == 0){
                    if (i == 0)
                        ii = true;
                    if (j == 0)
                        jj = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < r; i++){
            for (int j = 1; j < l; j++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (ii){
            for (int i = 0 ; i < l ; i++){
                matrix[0][i] = 0;
            }
        }
        if (jj){
            for (int i = 0 ; i < r ; i++){
                matrix[i][0] = 0;
            }
        }
        System.out.println(Arrays.asList(matrix));
    }
}
