package leetCode;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 */
public class Solution130 {
    public static void main(String[] args){
        new Solution130().solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
    public void solve(char[][] board) {
        for (int i = 0;i < board[0].length;i++){
            if (board[0][i] == 'O'){
                dfs(board,0,i);
            }
            if (board[board.length - 1][i] == 'O'){
                dfs(board,board.length - 1,i);
            }
        }
        for (int i = 0;i < board.length;i++){
            if (board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if (board[i][board[0].length - 1] == 'O'){
                dfs(board,i,board[0].length - 1);
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

            }
        }
        System.out.println(board);
    }
    public void dfs(char[][] board, int i, int j){
        if (i < 0 || i >= board.length || j <0 || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'A';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}
