package offer;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import java.util.*;

public class Solution60 {
    public static void main(String[] args){

    }


    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> wList = new ArrayList<>();
        if (pRoot == null) return wList;
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> lList = new ArrayList<>();
            for (int i = 0 ; i < size; i++){
                TreeNode node = queue.poll();
                lList.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            wList.add(lList);
        }
        return wList;
    }


}
