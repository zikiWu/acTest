package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    Map<Integer,Integer> map = new HashMap<>();
    int index;
    int[] preorder;
    int[] inorder;
    public static void main(String[] args){

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i],i);
        }
        index = 0;
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0,preorder.length);
    }
    public TreeNode build(int left, int right) {
        if (left>=right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        int mid = map.get(preorder[index]);
        node.left = build(left,mid);
        node.right = build(mid+1,right);
        return node;
    }
}
