package offer;

import java.util.ArrayList;
import java.util.Stack;

public class Solution24 {
    public static void main(String[] args){

    }
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        path(lists,root,target);
        return lists;
    }
    public void path(ArrayList<ArrayList<Integer>> lists,
                     TreeNode root, int target) {
        if (root == null)
            return;
        target = target - root.val;
        list.add(root.val);
        if (root.left == null && root.right ==null && target == 0){
            lists.add(new ArrayList<>(list));
        }
        path(lists,root.left,target);
        path(lists,root.right,target);
        list.remove(list.size()-1);
    }
}
