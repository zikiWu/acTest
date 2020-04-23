package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution95 {
    public static void main(String[] args){

    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();
        return trees(1,n);
    }
    public List<TreeNode> trees(int l,int r) {
        List<TreeNode> all = new LinkedList<>();
        if (l > r) {
            all.add(null);
            return all;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = trees(l, i - 1);
            List<TreeNode> right = trees(i + 1, r);
            if (left != null && right != null) {
                for (TreeNode lt: left) {
                    for (TreeNode rt: right) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = lt;
                        treeNode.right = rt;
                        all.add(treeNode);
                    }
                }
            }
        }
        return all;
    }
}
