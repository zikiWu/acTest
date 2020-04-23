package leetCode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Solution16 {
    public static void main(String[] args){

        new Solution16().threeSumClosest(new int[]{-3,-2,-5,3,-4},-1);
        HashMap h = new HashMap();
        ConcurrentHashMap C = new ConcurrentHashMap();
    }
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream( nums ).boxed().collect(Collectors.toList());
        list.stream().forEach(System.out::println);
        int n = Integer.MAX_VALUE-1;

        for (int k = 1;k<nums.length-1;k++){
            int i = 0;
            int j = nums.length - 1;
            while (i<j){
                if (i == k){
                    i++;
                    continue;
                }else if(j ==k){
                    j--;
                    continue;
                }
                int sum = nums[k]+nums[i]+nums[j];
                int c = sum - target;
                n = Math.abs(c)<Math.abs(n-target)?sum:n;

                System.out.println(i+" "+j+" k:"+ k+" sum:"+sum+" n:"+n);
                if (c == 0) return sum;
                if (c > 0){
                    j--;
                }else {
                    i++;
                }
            }
        }
        return n;
    }
}
