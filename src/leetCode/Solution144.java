package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历
 */
public class Solution144 {
    public static void main(String[] args){

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        list.addLast(root);
        while (!list.isEmpty()){
            TreeNode treeNode = list.removeLast();
            if (treeNode != null){
                r.add(treeNode.val);
                if (treeNode.right != null){
                    list.addLast(treeNode.right);
                }
                if (treeNode.left != null){
                    list.addLast(treeNode.left);
                }
            }
        }
        return r;
    }
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        if (root == null){
            return r;
        }
        list.addLast(root);
        TreeNode curNode = root.left;
        while (true){
            while (curNode != null){
                list.addLast(curNode);
                curNode = curNode.left;
            }
            TreeNode treeNode = list.removeLast();
            if (treeNode != null){
                r.add(treeNode.val);
                curNode = treeNode.right;
            }
            if (curNode == null && list.isEmpty()){
                return r;
            }
        }
    }
}
