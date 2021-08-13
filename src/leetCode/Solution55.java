package leetCode;

public class Solution55 {
    public static void main(String[] args){

        new Solution55().canJump(new int[]{2,3,1,1,4});
        new Solution55().canJump(new int[]{3,2,1,0,4});
        new Solution55().canJump(new int[]{1,2,0,3});
        new Solution55().canJump(new int[]{0,2});
        new Solution55().canJump(new int[]{2,0});
        new Solution55().canJump4(new int[]{2,3,1,1,4});
        new Solution55().canJump4(new int[]{3,2,1,0,4});
        new Solution55().canJump4(new int[]{1,2,0,3});
        new Solution55().canJump4(new int[]{0,2});
        new Solution55().canJump4(new int[]{2,0});

        new Solution55().canJump5(new int[]{2,3,1,1,4});
        new Solution55().canJump5(new int[]{3,2,1,0,4});
        new Solution55().canJump5(new int[]{1,2,0,3});
        new Solution55().canJump5(new int[]{0,2});
        new Solution55().canJump5(new int[]{2,0});
    }


    public boolean canJump5(int[] nums) {
        int len = nums.length;
        boolean[] b = new boolean[len];
        b[len - 1] = true;
        for (int i = len - 2; i >=0; i--){
            boolean r = false;
            for (int j = 1; j <=nums[i] && i+j < len ; j++){
                r = r || b[i+j];
            }
            b[i] = r;
        }
        System.out.println(b[0]);
        return b[0];
    }

    // 暴力递归
    public boolean canJump4(int[] nums) {
        System.out.println(jump2(nums, 0));
       return jump2(nums, 0);
    }

    public boolean jump2(int[] nums, int i) {
        if (nums.length - 1 == i){
            return true;
        }else if (nums[i] == 0 || i > nums.length - 1){
            return false;
        }
        boolean re = false;
        for (int j = 1; j<=nums[i]; j++){
            re = re || jump2(nums,i+j);
        }
        return re;
    }




    //动态规划
    public boolean canJump(int[] nums) {
        boolean[] a = new boolean[nums.length];
        int len = nums.length;
        a[len-1] = true;
        for (int i = len-2;i>=0;i--){
            boolean re = false;
            for (int j = 1;j<=nums[i];j++){
                if (i+j<len)
                    re = re ||  a[i+j];
            }
            a[i] = re;
        }
        System.out.println(a[0]);
        return a[0];
    }
    //贪心算法
    public boolean canJump3(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
    public boolean canJump2(int[] nums) {
        System.out.println(jump(nums,0));
        return jump(nums,0);
    }
    //回溯
    public boolean jump(int[] nums,int i) {
        if (i == nums.length-1)
            return true;
        if (i >= nums.length || nums[i] == 0){
            return false;
        }
        boolean result = false;
        for (int j = 1;j<=nums[i];j++){
            result = result || jump(nums,i+j);
        }
        return result;
    }
}
