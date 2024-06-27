package leetCode;

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 *
 * 输入：root = [1,null,2]
 * 输出：2
 *
 *
 * 提示：
 *
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */
public class Solution104 {
    public static void main(String[] args){

    }

    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }else if (root.left == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }




    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int max = Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        return max;
    }
}
