package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树后序遍历
 */
public class Solution145 {
    public static void main(String[] args){

    }
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> l = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList<>();
        LinkedList<TreeNode> ll2 = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !ll.isEmpty()){
            while (cur != null){
                ll.addLast(cur);
                ll2.addLast(cur);
                cur = cur.right;
            }
            if (!ll.isEmpty()){
                cur = ll.removeLast().left;
            }
        }
        while (!ll2.isEmpty()){
            l.add(ll2.removeLast().val);
        }
        return l;
    }
}
