package leetCode;

public class Solution98 {


    private static TreeNode pre;

    public static void main(String[] args){

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(30);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(45);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node5;
        System.out.println(isValidBST(node1));
    }

    public static boolean isValidBST(TreeNode root) {

      return   isValidBST3(root,null,null);

    }
    public static boolean isValidBST3(TreeNode root, Integer litter, Integer supper) {
        if (root == null){
            return true;
        }
        if (litter !=null && litter >=root.val) return false;
        if (supper !=null && supper <=root.val) return false;
        return isValidBST3(root.left,litter,root.val) && isValidBST3(root.right,root.val,supper);
    }
    public static result isValidBST2(TreeNode root) {

        if (root == null){
            return new result(true,null,null);
        }
        result ls = isValidBST2(root.left);
        result rs = isValidBST2(root.right);
        boolean isS = ls.isS&&rs.isS && (ls.max == null || root.val >ls.max) && (rs.min == null || root.val <rs.min);
        int max = max(rs.max, max(ls.max,root.val));
        int min = min(rs.min, min(ls.min,root.val));
        System.out.println(isS+" "+max+" "+min);
        return new result(isS,min,max);
    }


    public static Integer max(Integer i,Integer j) {
        if (i == null&&j==null){
            return null;
        }
        if (i == null){
            return j;
        }
        if (j == null){
            return i;
        }
        return Math.max(i,j);    }
    public static Integer min(Integer i,Integer j) {
        if (i == null&&j==null){
            return null;
        }
        if (i == null){
            return j;
        }
        if (j == null){
            return i;
        }
        return Math.min(i,j);    }
}

class result {
    public result(boolean isS, Integer min, Integer max) {
        this.isS = isS;
        this.min = min;
        this.max = max;
    }

    boolean isS;
    Integer min;
    Integer max;
}

class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
}
