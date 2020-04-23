package offer;

public class Solution18 {
    public static void main(String[] args){

    }
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;
        Mirror(root.left);
        Mirror(root.right);
    }


}
