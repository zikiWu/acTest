package leetCode;

import java.util.*;

/**
 * 210. 课程表 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 *
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 *
 */
public class Solution210 {
    public static void main(String[] args){

    }

    // 拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 建立入度数组和邻边表
        int[] studySort = new int[numCourses];
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
        int index = 0;
        while (!zeroInList.isEmpty()){
            Integer cur = zeroInList.removeFirst();
            studySort[index++] = cur;
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
        return numCourses == 0 ? studySort : new int[]{};
    }
}
