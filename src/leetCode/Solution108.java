package leetCode;

public class Solution108 {
    public static void main(String[] args){

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums, 0, nums.length - 1);
    }

    public TreeNode BST(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = BST(nums, left, mid - 1);
        node.right = BST(nums, mid + 1, right);
        return node;
    }


}
