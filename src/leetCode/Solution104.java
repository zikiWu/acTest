package leetCode;

public class Solution104 {
    public static void main(String[] args){

    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int max = Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        return max;
    }
}
