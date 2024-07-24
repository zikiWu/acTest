package leetCode;

/**
 * 64. 最小路径和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
public class Solution64 {
    public static void main(String[] args){
        int[][] arr = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new Solution64().minPathSum(arr));
    }

    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][] arr = new int[n][m];
        arr[0][0] = grid[0][0];
        for (int i = 1;i < m; i++){
            arr[0][i] = arr[0][i-1]+grid[0][i];
        }
        for (int i = 1;i < n; i++){
            arr[i][0] = arr[i-1][0]+grid[i][0];
        }
        for (int i = 1;i<n;i++){
            for (int j = 1;j<m;j++){
                arr[i][j] = Math.min(arr[i][j-1],arr[i-1][j])+grid[i][j];
            }
        }
        return arr[n-1][m-1];
    }

    public int minPathSum2(int[][] grid) {
        return find(grid,grid[0].length-1,grid.length-1,0);
    }
    public int find(int[][] grid,int m,int n,int v) {
        if(n<0 || m<0){
            return -1;
        }
        if(n==0&&m==0){
            return v+grid[m][n];
        }
        int downF = find(grid,m,n-1,v+grid[m][n]);
        int rightF = find(grid,m-1,n,v+grid[m][n]);
        if(downF == -1){
            return rightF;
        }
        if(rightF == -1){
            return downF;
        }
        if(rightF == -1 && downF == -1){
            return -1;
        }
        return Math.min(downF,rightF);
    }
}
