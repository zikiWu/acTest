package leetCode;

/**
 * 236. 二叉树的最近公共祖先
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class Solution236 {
    public static void main(String[] args){

    }

    /**
     * 树的最近公共祖先（Lowest Common Ancestor, LCA）问题有多种解法，每种方法都有其适用场景和优缺点。以下是一些常见的解法：
     *
     * 递归解法：
     * 这种方法适用于处理少量查询的情况。对于两个节点，从根节点开始递归遍历树，如果当前节点等于两个节点之一，则返回当前节点；如果递归到某个节点的左右子树分别找到了两个节点，则当前节点即为最近公共祖先。
     * 时间复杂度：O(n)，其中n是树中节点的数量。
     * 存储父节点解法：
     * 这种方法首先遍历树，存储每个节点的父节点，然后通过存储的信息找到两个节点的所有祖先，最后找到它们的最近公共祖先。
     * 时间复杂度：O(n)（预处理）+ O(h)（每次查询），其中h是树的高度。
     * Tarjan算法：
     * Tarjan算法是一种离线算法，可以处理多个查询。它使用深度优先搜索（DFS）遍历树，并使用并查集来找到最近公共祖先。
     * 时间复杂度：O(n + q)，其中q是查询的数量。
     * 基于RMQ（Range Minimum Query）的解法：
     * 这种方法首先将树转换为序列（例如，通过深度优先遍历），然后使用线段树或树状数组来处理RMQ问题，从而找到最近公共祖先。
     * 时间复杂度：O(n)（预处理）+ O(log n)（每次查询）。
     * BST（二叉搜索树）解法：
     * 如果树是二叉搜索树，那么最近公共祖先可以通过比较节点值和两个节点的值来确定。
     * 时间复杂度：O(h)，其中h是树的高度。
     * 利用树的直径解法：
     * 对于某些特定类型的树，例如树状数组，可以通过树的直径来找到最近公共祖先。
     * 时间复杂度取决于树的结构和性质。
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }else {
            return left != null ? left : right;
        }

    }
}
