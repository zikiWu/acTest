package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * 示例 2:
 *
 *
 *
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 *
 *
 * 提示：
 *
 * 树中节点数量在 [1, 104] 范围内
 * -231 <= Node.val <= 231 - 1
 */
public class Solution637 {
    public static void main(String[] args){

    }
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        list.addLast(root);
        while (!list.isEmpty()){
            LinkedList<TreeNode> curList = new LinkedList<>();
            TreeNode treeNode = null;
            double sum = 0;
            int num = 0;
            while (!list.isEmpty()){
                treeNode = list.removeFirst();
                if (treeNode != null){
                    sum += treeNode.val;
                    num ++;
                    if (treeNode.left != null){
                        curList.addLast(treeNode.left);
                    }
                    if (treeNode.right != null){
                        curList.addLast(treeNode.right);
                    }
                }
            }
            result.add(sum / num);
            if (!curList.isEmpty()){
                list.addAll(curList);
            }
        }
        return result;
    }
}
