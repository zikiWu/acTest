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
}
