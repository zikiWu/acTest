package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution99 {
    public static void main(String[] args){

    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        recover(root,nodes);
        nodes.forEach(o->System.out.println(o.val));
        TreeNode c1 = null;
        TreeNode c2 = nodes.get(0);
        for (int i = nodes.size()-1; i >=1 ; i--) {
            if (c1 ==null && nodes.get(i).val<nodes.get(i-1).val){
                c1 = nodes.get(i);
                continue;
            }
            if (c1!=null && c1.val>nodes.get(i).val){
                c2 = nodes.get(i+1);
                break;
            }
        }
        int temp = c1.val;
        c1.val = c2.val;
        c2.val = temp;
    }
    public void recover(TreeNode root, List<TreeNode> list) {
        if (root == null){
            return;
        }
        recover(root.left,list);
        list.add(root);
        recover(root.right,list);
    }
}
