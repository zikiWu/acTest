package leetCode;


import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *  
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 */
public class Solution15 {
    public static void main(String[] args) {
        List<List<Integer>> l = new Solution15().threeSum(new int[]{-2,0,1,1,2});
        System.out.println(l);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l  = new ArrayList<>();
        Set<String> ss = new HashSet<>();
        for (int n = 0; n < nums.length - 2;n++){
            int i = n + 1;
            int j = nums.length - 1;
            while (i < j){
                if (nums[n] + nums[i] + nums[j] > 0){
                    j--;
                }else if (nums[n] + nums[i] + nums[j] < 0){
                    i++;
                }else {
                    if (ss.contains(nums[n]+"_"+nums[i]+"_"+nums[j])){
                        i++;
                        j--;
                        continue;
                    }
                    List<Integer> ll = new ArrayList<>();
                    ll.add(nums[n]);
                    ll.add(nums[i]);
                    ll.add(nums[j]);
                    l.add(ll);
                    ss.add(nums[n]+"_"+nums[i]+"_"+nums[j]);
                    i++;
                    j--;
                }
            }
        }
        return l;
    }

    // 去重写法
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int indexR = nums.length-1;
        List<List<Integer>> resultListA = new ArrayList<List<Integer>>();

        for(int i = 0;i<nums.length-2;i++) {
            int l = i+1;
            int r = nums.length-1;
            if (i == 0 || i > 0 && nums[i] != nums[i-1]){//nums[i] != nums[i-1] 去重
                while(l<r ) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0) {
                        List<Integer> rb = new ArrayList<Integer>();
                        rb.add(nums[l]);
                        rb.add(nums[i]);
                        rb.add(nums[r]);
                        resultListA.add(rb);
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;//去重
                        l++;
                        r--;
                    }else if(sum >0 ){
                        while (nums[r] == nums[--r] && l < r) {}//去重
                    }else if(sum <0) {
                        while (nums[l] == nums[++l] && l < r) {}//去重
                    }
                }
            }
        }
        return resultListA;
    }
}
