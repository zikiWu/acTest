package offer;

public class Solution_对称的二叉树 {
    public static void main(String[] args){

    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        return symmetrical(pRoot,pRoot);
    }
    boolean symmetrical(TreeNode pRoot1,TreeNode pRoot2)
    {
        if (pRoot1 == null && pRoot1 == null)
            return true;
        if ((pRoot1 == null && pRoot2 != null)||(pRoot2 == null && pRoot1 != null))
            return false;
        return pRoot1.val == pRoot2.val && symmetrical(pRoot1.left,pRoot2.right)&&
                symmetrical(pRoot1.right,pRoot2.left);

    }
}
