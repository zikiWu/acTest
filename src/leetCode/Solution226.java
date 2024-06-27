package leetCode;

/**
 *
 代码
 测试用例
 测试结果
 测试结果
 226. 翻转二叉树
 简单
 相关标签
 相关企业
 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。



 示例 1：



 输入：root = [4,2,7,1,3,6,9]
 输出：[4,7,2,9,6,3,1]
 示例 2：



 输入：root = [2,1,3]
 输出：[2,3,1]
 示例 3：

 输入：root = []
 输出：[]


 提示：

 树中节点数目范围在 [0, 100] 内
 -100 <= Node.val <= 100
 */
public class Solution226 {
    public static void main(String[] args){

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }
        TreeNode tem= root.left;
        root.left = root.right;
        root.right = tem;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
