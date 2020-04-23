package offer;

public class Solution39 {
    public static void main(String[] args){

    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return balanced(root).isB;
    }
    public Re balanced(TreeNode root) {
        if (root == null)
            return new Re(true,0);
        Re l = balanced(root.left);
        Re r = balanced(root.right);
        return new Re(l.isB && r.isB && Math.abs(l.h-r.h)<=1,Math.max(l.h,r.h)+1);
    }
    class Re{
        public Re(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
        boolean isB;
        int h;
    }
}
