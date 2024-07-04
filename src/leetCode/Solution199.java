package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 *
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 *
 * 输入: []
 * 输出: []
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class Solution199 {
    public static void main(String[] args){

    }
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        list.addLast(root);
        while (!list.isEmpty()){
            LinkedList<TreeNode> curList = new LinkedList<>();
            TreeNode treeNode = null;
            while (!list.isEmpty()){
                treeNode = list.removeFirst();
                if (treeNode != null){
                    if (treeNode.left != null){
                        curList.addLast(treeNode.left);
                    }
                    if (treeNode.right != null){
                        curList.addLast(treeNode.right);
                    }
                }
            }
            if(treeNode != null){
                result.add(treeNode.val);
            }
            if (!curList.isEmpty()){
                list.addAll(curList);
            }
        }
        return result;
    }

}
