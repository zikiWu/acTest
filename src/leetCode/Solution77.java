package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 77. 组合
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Solution77 {
    public static void main(String[] args){
        new Solution77().combine(4,2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
//        combineSub(n,k,0, 1, result,"");
        combineSub2(n,k,0, 1, result,new LinkedList<>());
        return result;
    }

    public void combineSub(int n, int k, int curI, int startI, List<List<Integer>> result, String s) {
        if (curI == k){
            System.out.println(s);
            result.add(Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            return;
        }
        for (int i = startI; i <= n; i++){
            combineSub(n, k, curI+1, i + 1 ,result, s+i+",");
        }
    }


    public void combineSub2(int n, int k, int curI, int startI, List<List<Integer>> result, LinkedList<Integer> list) {
        if (curI == k){
            result.add(new ArrayList<>(list));
            return;
        }
        //  从n -》  i <= n - (k - curI) + 1    剪枝
        for (int i = startI; i <= n - (k - curI) + 1; i++){
            list.addLast(i);
            combineSub2(n, k, curI+1, i + 1 ,result, list);
            list.removeLast();
        }
    }
}
