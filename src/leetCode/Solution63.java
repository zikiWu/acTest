package leetCode;

/**
 * 63. 不同路径 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 *
 *
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 *
 * 提示：
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */
public class Solution63 {
    public static void main(String[] args){

        int arr[][] = new int[2][1];
        arr[0][0] = 1;
        arr[1][0] = 0;
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1;i<m;i++){
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1?0:obstacleGrid[0][i-1];
        }
        for (int i = 1;i<n;i++){
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1?0:obstacleGrid[i-1][0];
        }
        for (int i = 1;i<n;i++){
            for (int j = 1;j<m;j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }
    //动态规划
    public static int uniquePaths(int m, int n) {
        int arr[][] = new int[n][m];
        for (int i = 0;i<m;i++){
            arr[0][i] = 1;
        }
        for (int i = 0;i<n;i++){
            arr[i][0] = 1;
        }
        for (int i = 1;i<n;i++){
            for (int j = 1;j<m;j++){
                arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[n-1][m-1];
    }
    //暴力解决
    public static int uniquePaths2(int m, int n) {
        //边界值
        if (m == 1&&n == 1){
            return 1;
        }
        if (m <1 || n <1){
            return 0;
        }
        //转换方程
        return uniquePaths2(m-1,n)+uniquePaths2(m,n-1);
    }

}
