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


    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, preorder.length -1, 0);
    }
    public TreeNode build(int[] preorder, Map<Integer, Integer> map, int left , int right, int inStart) {
        if (left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        int rootIdx = map.get(preorder[left]);
        int leftNum = rootIdx - inStart;
        root.left = build(preorder, map, left ,  left + leftNum, inStart);
        root.right = build(preorder, map, left + leftNum + 1 ,right, rootIdx+1);
        return root;
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
        int mid = map.get(preorder[index++]);
        node.left = build(left,mid);
        node.right = build(mid+1,right);
        return node;
    }


    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
