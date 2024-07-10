package leetCode;

import java.util.*;

/**
 * 207. 课程表
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
public class Solution207 {
    public static void main(String[] args){
        new Solution207().canFinish(2, new int[][]{{0,1}});
    }

    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建立入度数组和邻边表
        int[] inNum = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
            inNum[prerequisites[i][0]] ++;
            List<Integer> inList = map.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>());
            inList.add(prerequisites[i][0]);
        }
        LinkedList<Integer> zeroInList = new LinkedList();
        for (int i = 0; i < numCourses; i++){
            if (inNum[i] == 0){
                zeroInList.addLast(i);
            }
        }
        while (!zeroInList.isEmpty()){
            Integer cur = zeroInList.removeFirst();
            numCourses --;
            List<Integer> inList = map.get(cur);
            if (inList != null){
                for (Integer in : inList){
                    inNum[in] --;
                    if (inNum[in] == 0){
                        zeroInList.addLast(in);
                    }
                }
            }
        }
        return numCourses == 0 || prerequisites.length == 0;
    }
}
