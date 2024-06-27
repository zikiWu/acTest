package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 101. 对称二叉树
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Solution101 {
    public static void main(String[] args){

    }
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addLast(root);
        List<TreeNode> nodesArray = new ArrayList<>();

        while (true){
            if (treeNodes.isEmpty()){
                break;
            }
            nodesArray.clear();
            while (!treeNodes.isEmpty()){
                nodesArray.add(treeNodes.removeFirst());
            }
            System.out.println();
            nodesArray.stream().forEach(o-> System.out.print(o.val));
            for (int i = 0,j = nodesArray.size()-1;i<nodesArray.size()/2;i++,j--){


                if (nodesArray.get(i).val != nodesArray.get(j).val){
                    return false;
                }
            }
            for (int i = 0;i<nodesArray.size();i++){
                TreeNode node = nodesArray.get(i);
                if (node.val != Integer.MIN_VALUE){
                    treeNodes.addLast(node.left==null?new TreeNode(Integer.MIN_VALUE):node.left);
                    treeNodes.addLast(node.right==null?new TreeNode(Integer.MIN_VALUE):node.right);
                }
            }
        }
        return true;
    }
    public boolean isSymmetric2(TreeNode root) {
        return symmetric(root,root);
    }
    public boolean symmetric(TreeNode lroot,TreeNode rroot) {
        if (lroot == null && rroot == null){
            return true;
        }
        if (lroot == null || rroot == null){
            return false;
        }
        return (lroot.val == rroot.val) && symmetric(lroot.left,rroot.right) && symmetric(lroot.right,rroot.left);
    }
}
