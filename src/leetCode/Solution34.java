package leetCode;

public class Solution34 {
    public static void main(String[] args){
        new Solution34().searchRange(new int[]{5,7,7,8,8,10}, 8);
        new Solution34().searchRange(new int[]{1}, 1);
    }

    public int[] searchRange(int[] nums, int target) {
        int r = 0, l = nums.length - 1;
        int index = -1;
        while (r <= l){
            int mid = (r + l) /2;
            if (nums[mid] == target){
                index = mid;
                break;
            }
            if (target <= nums[mid]){
                l = mid - 1;
            }else {
                r = mid + 1;
            }
        }
        if (index == -1){
            return new int[]{-1, -1};
        }
        int rr = index,ll = index;
        while (rr - 1 >= 0 && nums[rr] == nums[rr-1])
            rr--;
        while (ll + 1 < nums.length && nums[ll] == nums[ll+1])
            ll++;
        return new int[]{rr , ll};
    }
}
