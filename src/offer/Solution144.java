package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class Solution144 {
    public static void main(String[] args){

    }
    // 非递归

    /**
     * 　　a. 遇到一个节点，访问它，然后把它压栈，并去遍历它的左子树；
     *
     * 　　b. 当左子树遍历结束后，从栈顶弹出该节点并将其指向右儿子，继续a步骤；
     *
     * 　　c. 当所有节点访问完即最后访问的树节点为空且栈空时，停止。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !ll.isEmpty()){
            while (cur != null){
                System.out.println(cur.val);
                l.add(cur.val);
                ll.addLast(cur);
                cur = cur.left;
            }
            if (!ll.isEmpty()){
                cur = ll.removeLast().right;
            }
        }
        return l;
    }

}
