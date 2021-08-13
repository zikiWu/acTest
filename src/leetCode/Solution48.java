package leetCode;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Solution48 {
    public static void main(String[] args){
        new Solution48().rotate2(new int[][]{
                {1,2},{3,4}
        });

    }



    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++){
                swap(matrix,i,j,i,n-1-j);
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n-i; j++){
                swap(matrix,i,j,n- 1- j,n-1-i);
            }
        }
        System.out.println();
    }












    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0 ;i<r; i++){
            for (int j = 0 ;j<i; j++){
                swap(matrix,i,j,j,i);
            }
        }
        for (int i = 0 ;i<r; i++){
            for (int j = 0 ;j<r/2; j++){
                swap(matrix,i,j,i,r-j-1);
            }
        }
    }
    public  void swap(int[][] nums,int i,int j,int n ,int m) {
        int tamp = nums[i][j];
        nums[i][j] = nums[n][m];
        nums[n][m] = tamp;
    }
}
