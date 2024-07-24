package leetCode;

import java.util.*;

public class Solution373 {
    public static void main(String[] args){
        new Solution373().kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3);
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < Math.min(nums1.length, k); i ++){
            priorityQueue.add(new int[]{nums1[i] + nums2[0], i , 0});
        }
        for (int i = 0; i < k; i++){
            List<Integer> list = new ArrayList<>();
            int[] poll = priorityQueue.poll();
            int n1 = poll[1];
            int n2 = poll[2];
            list.add(nums1[n1]);
            list.add(nums2[n2]);
            result.add(list);
            if (n2 + 1 < nums2.length){
                priorityQueue.add(new int[]{nums1[n1] + nums2[n2 + 1], n1 , n2 + 1});
            }
        }
        return result;
    }

}
