package leetCode;

import java.util.*;

public class Solution103 {
    public static void main(String[] args){

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        zigzagLevelOrder(root,0,lists);
        for (int i = 1; i < lists.size(); i+=2) {
            Collections.reverse(lists.get(i));
        }
        return lists;
    }
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        int num = 0;
        while (!list.isEmpty()){
            LinkedList<TreeNode> curList = new LinkedList<>();
            TreeNode treeNode = null;
            LinkedList<Integer> rrList = new LinkedList<>();
            while (!list.isEmpty()){
                treeNode = list.removeFirst();
                if (treeNode != null){
                    if (num % 2 == 0){
                        rrList.addLast(treeNode.val);
                    }else {
                        rrList.addFirst(treeNode.val);
                    }
                    if (treeNode.left != null){
                        curList.addLast(treeNode.left);
                    }
                    if (treeNode.right != null){
                        curList.addLast(treeNode.right);
                    }
                }
            }
            if (!rrList.isEmpty()){
                lists.add(rrList);
            }
            if (!curList.isEmpty()){
                list.addAll(curList);
            }
            num ++;
        }
        return lists;
    }

    public void zigzagLevelOrder(TreeNode root,int n,List<List<Integer>> lists ) {
        if (root == null){
            return;
        }
        if (n>=lists.size())
            lists.add(new LinkedList<>());
        lists.get(n).add(root.val);
        zigzagLevelOrder(root.left,n+1,lists);
        zigzagLevelOrder(root.right,n+1,lists);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root, long min, long max) {
        if (root == null){
            return true;
        }
        if (root.val < min || root.val > max){
            return false;
        }
        return isValidBST2(root.left, min, root.val) && isValidBST2(root.right, root.val, max);
    }

}
