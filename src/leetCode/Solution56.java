package leetCode;

/**
 *
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。



 示例 1：

 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：

 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

import java.util.*;

public class Solution56 {
    public static void main(String[] args){
        new Solution56().merge2(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<Integer> re = new ArrayList<>();
        re.add(intervals[0][0]);
        re.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= re.get(re.size() - 1)){
                int temp = re.get(re.size() - 1);
                re.remove(re.size() - 1);
                re.add(Math.max(intervals[i][1], temp));
            }else {
                re.add( intervals[i][0]);
                re.add( intervals[i][1]);
            }
        }
        int[][] r = new int[re.size()/2][2];
        for (int i = 0, j = 0 ;i < r.length; i++){
            r[i][0] = re.get(j++);
            r[i][1] = re.get(j++);
        }
        return r;
    }







    public int[][] merge(int[][] intervals) {
        int r = intervals.length;
        List<Interval>  il = new ArrayList<>();
        LinkedList<Interval> result = new LinkedList<>();
        for (int i = 0;i < r; i++){
            il.add(new Interval(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(il);
        for (Interval i : il){
            if(result.isEmpty() || result.getLast().right < i.left){
                result.addLast(i);
            }else {
                Interval ir = result.getLast();
                ir.right = ir.right>i.right?ir.right:i.right;
            }
        }
        int[][] resuleArr = new int[result.size()][2];
        int i = 0;
        for (Interval re : result){
            resuleArr[i][0] = re.left;
            resuleArr[i++][1] = re.right;
            System.out.println(re.left+" "+re.right);
        }
        return resuleArr;
    }
}
class Interval implements Comparable<Interval>{
    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }
    int left;
    int right;
    @Override
    public int compareTo(Interval o) {
        return this.left - o.left;
    }
}
