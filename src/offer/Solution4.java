package offer;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    Map<Integer,Integer> map = new HashMap<>();
    int index = 0;
    public static void main(String[] args){

    }

    public TreeNode binaryTree(int [] pre, int [] in,int f,int l) {
        if (f == l){
            return null;
        }
        TreeNode node = new TreeNode(pre[index]);
        int mid = map.get(pre[index]);

        index++;
        node.left = binaryTree(pre,in,f,mid-1);
        node.right = binaryTree(pre,in,mid+1,l);
        return node;
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return binaryTree(pre,in,0,in.length-1);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}