package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 *
 *
 * 提示:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 */
public class Solution106 {
    public static void main(String[] args){

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(postorder, map, 0, postorder.length - 1, 0);
    }
    public TreeNode build(int[] postorder, Map<Integer, Integer> map, int postL, int postR, int inL){
        if (postL > postR){
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[postR]);
        int index = map.get(postorder[postR]);
        int leftNum = index - inL;
        treeNode.right = build(postorder, map, postL + leftNum, postR - 1, index + 1);
        treeNode.left = build(postorder, map, postL, postL + leftNum - 1, inL);
        return treeNode;
    }


}
