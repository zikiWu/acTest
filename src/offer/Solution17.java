package offer;

public class Solution17 {
    public static void main(String[] args){

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return subtree(root1,root2) || HasSubtree(root1.left,root2) ||
                HasSubtree(root1.right,root2);
    }

    public boolean subtree(TreeNode root1,TreeNode root2) {
        if (root2 == null)
            return true;
        if ((root1 == null && root2 != null) || root1.val != root2.val)
            return false;
        return subtree(root1.left,root2.left)
                && subtree(root1.right,root2.right);
    }
}
