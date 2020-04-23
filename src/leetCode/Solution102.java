package leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution102 {
    public static void main(String[] args){

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        levelOrder(root,0,lists);
        return lists;
    }
    public void levelOrder(TreeNode root,int n,List<List<Integer>> lists) {
        if (root == null){
            return;
        }
        if (n>=lists.size())
            lists.add(new LinkedList<>());
        lists.get(n).add(root.val);
        levelOrder(root.left,n+1,lists);
        levelOrder(root.right,n+1,lists);
    }
    //107
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        levelOrder(root,0,lists);
        Collections.reverse(lists);
        return lists;
    }
}
