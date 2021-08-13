package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 */
public class Solution62 {
    public static void main(String[] args){

    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (k <= 0){
            return null;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        searchNode(pRoot, nodeList);
        if (k > nodeList.size()){
            return null;
        }
        return nodeList.get(k - 1);
    }
    void searchNode(TreeNode pRoot, List<TreeNode> nodeList)
    {
        if (pRoot == null){
            return ;
        }
        searchNode(pRoot.left, nodeList);
        nodeList.add(pRoot);
        searchNode(pRoot.right, nodeList);
    }
}
