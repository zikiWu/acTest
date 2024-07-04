package leetCode;

/**
 * 222. 完全二叉树的节点个数
 * 简单
 * 相关标签
 * 相关企业
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 *
 * 输入：root = []
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 *
 *
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 */
public class Solution222 {
    public static void main(String[] args){

    }
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int lh = countLevel(root.left);
        int rh = countLevel(root.right);
        if (lh == rh){
            return (int) (Math.pow(2,lh) + countNodes2(root.right));
        }else {
            return (int) (Math.pow(2,rh) + countNodes2(root.left));
        }
    }

    public int countLevel(TreeNode root) {
        int level = 0;
        while (root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
