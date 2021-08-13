package offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */

public class Solution65 {
    public static void main(String[] args){
        System.out.println(new Solution65().hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        char[][] matrixx = new char[rows][cols];
        int num = 0;
        for (int i = 0 ;i < rows; i++){
            for (int j = 0 ;j < rows; j++){
                matrixx[i][j] = matrix[num++];
            }
        }
        boolean b = false;
        boolean[][] m  = new boolean[rows][cols];
        for (int i = 0 ;i < rows; i++){
            for (int j = 0 ;j < rows; j++){
                b = b || path(matrixx, i, j, str, 0, m);
            }
        }
        return b;
    }
    public boolean path(char[][] matrixx, int row, int col, char[] str, int num, boolean[][] isrun)
    {
        if (row < 0 || row >= matrixx.length || col < 0 || col >= matrixx[0].length || isrun[row][col] || matrixx[row][col] != str[num]){
            return false;
        }
        isrun[row][col] = true;
        if (num == str.length - 1){
            return true;
        }
        if (path(matrixx, row, col+1, str, num+1, isrun)||
                path(matrixx, row+1, col, str, num+1, isrun)||
                path(matrixx, row-1, col, str, num+1, isrun)||
                path(matrixx, row, col-1, str, num+1, isrun)){
            return true;
        };
        isrun[row][col] = false;
        return false;
    }
}
