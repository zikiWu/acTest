package offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

public class Solution58 {
    public static void main(String[] args){

    }

    boolean isSymmetrical(TreeNode pRoot) {
        return symmetrical(pRoot, pRoot);
    }

    boolean symmetrical(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return symmetrical(node1.left, node2.right) &&  symmetrical(node1.right, node2.left);
    }
}
