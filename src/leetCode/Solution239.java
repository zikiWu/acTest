package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        LinkedList<Integer> q = new LinkedList();
        if (nums.length<1){
            return new int[]{};
        }
        q.addLast(nums[0]);
        int num = 0;
        for (int i = 1;i<k;i++){
            //队尾的数必须必加入的数大
            while (!q.isEmpty() && q.getLast()<nums[i]){
//                System.out.println(q.getLast());
                q.removeLast();
                num++;
            }
            q.addLast(nums[i]);
        }
        List<Integer> l = new ArrayList<>();
        for (int i = k;i<nums.length;i++){
            if(num == 0){
                l.add(q.removeFirst());
            }else {
                num--;
                l.add(q.peekFirst());
            }
            while (!q.isEmpty() && q.getLast()<nums[i]){
//                System.out.println(q.getLast());
                q.removeLast();
                num++;
            }
            q.addLast(nums[i]);
        }
        l.add(q.removeFirst());
        int[] result = new int[l.size()];
        for (int i =0;i<l.size();i++){
            result[i] = l.get(i);
        }
        return result;
    }
    public static void main(String[] args){

        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

}
