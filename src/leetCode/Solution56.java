package leetCode;

import java.util.*;

public class Solution56 {
    public static void main(String[] args){
        new Solution56().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
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
