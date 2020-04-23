package leetCode;

public class Solution110 {
    boolean res = true;

    public static void main(String[] args){

    }
    public boolean isBalanced(TreeNode root) {
        return balanced(root).isB;
    }
    public Re balanced(TreeNode root) {
        if (root == null)
            return new Re(true,0);
        Re l = balanced(root.left);
        Re r = balanced(root.right);
        return new Re(l.isB && r.isB && Math.abs(l.h-r.h)<=1,Math.max(l.h,r.h)+1);
    }


    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(right - left) > 1) res = false;
        return Math.max(left, right);
    }

}
class Re{
    public Re(boolean isB, int h) {
        this.isB = isB;
        this.h = h;
    }

    boolean isB;
    int h;
}