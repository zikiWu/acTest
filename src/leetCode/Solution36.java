package leetCode;

import com.sun.applet2.AppletParameters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 */
public class Solution36 {
    public static void main(String[] args){
//        new Solution36().isValidSudoku()
    }
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,Integer> rMap = new HashMap<>();
        HashMap<Character,Integer> lMap = new HashMap<>();
        HashMap<Character,Integer>[] iMap = new HashMap[9];
        for (int n = 0; n < 9; n++){
            iMap[n] = new HashMap<>();
        }


        for (int i = 0;i < 9; i++){
            for (int j = 0;j < 9; j++){
                int index = (i/3)*3 + j/3;
                HashMap<Character,Integer> curMap = iMap[index];
                if ((board[i][j] != '.' && rMap.containsKey(board[i][j])) ||
                        (board[j][i] != '.' && lMap.containsKey(board[j][i])) ||
                        board[i][j] != '.' && curMap.containsKey(board[i][j]))
                    return false;
                rMap.put(board[i][j],null);
                lMap.put(board[j][i],null);
                curMap.put(board[i][j],null);
            }
            rMap.clear();
            lMap.clear();
        }

        return true;
    }
}
