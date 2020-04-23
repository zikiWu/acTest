package leetCode;

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
