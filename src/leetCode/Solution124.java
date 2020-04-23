package leetCode;

public class Solution124 {
    public static void main(String[] args){

    }
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        int max = Math.max(Math.max(left+root.val,right+root.val),left+right+root.val);
        return max;
    }
}
