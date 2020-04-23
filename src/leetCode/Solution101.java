package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        if (lroot == null || rroot == null || lroot.val != rroot.val ){
            return false;
        }
        return symmetric(lroot.left,rroot.right) && symmetric(lroot.right,rroot.left);
    }
}
