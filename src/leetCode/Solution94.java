package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    public static void main(String[] args){

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        traversal(root, l);
        return l;
    }
    public void traversal(TreeNode root, List<Integer> l) {
        if (root == null)
            return;
        traversal(root.left, l);
        l.add(root.val);
        traversal(root.right, l);
    }
}
