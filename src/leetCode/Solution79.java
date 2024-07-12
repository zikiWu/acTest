package leetCode;

/**
 * 79. 单词搜索
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class Solution79 {
    public static void main(String[] args){

        long value = 0b1101010101010101010101010101010101010101010101010101010101010101L; // 示例值
        System.out.println(value);
        int n = 5; // 我们想要取出第5位
        long mask = 1L << n; // 创建掩码      0000001  << 5  = 0100000  =>0000100 & 0100000 = 0000000() =》 0000000 >> 5 = 0000000 得出第5位是0
        System.out.println(mask);
        long bit = (value & mask) >> n; // 取出第5位并右移到最低位

        System.out.println("The bit at position " + n + " is: " + bit);


    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (exist(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int i, int j, int index, String word) {
        if (index < word.length() && (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' ||  board[i][j] != word.charAt(index))){
            return false;
        }
        if (index >= word.length()){
            return true;
        }
        System.out.println(i + " " + j);
        char temp = board[i][j];
        board[i][j] = '#';
        boolean result = exist(board, i + 1, j, index + 1, word) || exist(board, i - 1, j, index + 1, word)
                        ||exist(board, i, j + 1, index + 1, word) || exist(board, i, j - 1, index + 1, word);
        board[i][j] = temp;
        return result;
    }
}
