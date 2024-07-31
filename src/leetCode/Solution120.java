package leetCode;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */
public class Solution120 {
    public static void main(String[] args){

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> last = null;
        for (List<Integer> list : triangle){
            if (last != null){
                for (int i = 1; i < list.size() - 1; i++){
                    list.set(i,list.get(i) + Math.min(last.get(i-1), last.get(i)));
                }
                list.set(0,list.get(0) + last.get(0));
                list.set(list.size() - 1,list.get(list.size() - 1) + last.get(last.size() - 1));
            }
            last = list;
        }
        int min = Integer.MAX_VALUE;
        for (Integer num : last){
            min = Math.min(min, num);
        }
        return min;
    }
}
