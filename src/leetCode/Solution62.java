package leetCode;

public class Solution62 {
    public static void main(String[] args){

        System.out.println(uniquePaths(7,3));
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
