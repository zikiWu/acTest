package leetCode;

import java.util.PriorityQueue;

public class Solution215 {
    public static void main(String[] args){
//        System.out.println(new Solution215().findKthLargest2(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new Solution215().findKthLargest2(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(new Solution215().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++){
            if (queue.size() == k && queue.peek() < nums[i]){
                queue.poll();
            }
            if (queue.size() < k){
                queue.add(nums[i]);
            }
            System.out.println(queue);
        }
        return queue.remove();
    }

    public int findKthLargest2(int[] nums, int k) {
        int[] sortNum = new int[k + 1];
        int num = 0;
        for (int i = 0; i < nums.length; i++){
            if (num == k && sortNum[1] < nums[i]){
                // 出堆
                swap(sortNum, 1, num);
                sortNum[num] = 0;
                num --;
                int outNum = 1;
                // down
                while (outNum * 2 <= num){
                    int nextNum = outNum * 2;
                    if (outNum * 2 + 1 <= num && sortNum[outNum * 2 + 1] < sortNum[nextNum]){
                        nextNum = outNum * 2 + 1;
                    }
                    if (sortNum[nextNum] < sortNum[outNum]){
                        swap(sortNum, nextNum, outNum);
                        outNum = nextNum;
                    }else {
                        break;
                    }
                }
            }
            if (num < k){
                // 入堆
                sortNum[++num] = nums[i];
                int inNum = num;
                // up
                while (inNum != 1 && sortNum[inNum] <= sortNum[inNum / 2]){
                    swap(sortNum, inNum, inNum / 2);
                    inNum = inNum / 2;
                }
            }
        }
        return sortNum[1];
    }

    public static void swap(int[] nums,int j,int i) {
        if (i == j)
            return;
        int tamp = nums[i];
        nums[i] = nums[j];
        nums[j] = tamp;
    }

}
