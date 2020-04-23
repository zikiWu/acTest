package offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution22 {
    public static void main(String[] args){
      new Solution22().PrintFromTopToBottom(null);
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList();
        if (root!=null)
            linkedList.addLast(root);
        while (!linkedList.isEmpty()){
            TreeNode node =  linkedList.removeFirst();
            list.add(node.val);
            if (node.left != null)
                linkedList.addLast(node.left);
            if (node.right != null)
                linkedList.addLast(node.right);
        }

        return list;
    }
}
