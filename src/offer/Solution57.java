package offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution57 {

    public static void main(String[] args){

    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        TreeLinkNode parent = pNode.next;

        TreeLinkNode right =  pNode.right;
        if (right != null){
            while (right.left != null){
                right = right.left;
            }
            return right;
        }
        if (pNode.next != null && parent.left == pNode){
            return parent;
        }
        // 3.
        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;

        /**
         *  有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
         *
         * 无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点，例如 H，下一结点是 E
         *
         * 无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树，如果存在这样的结点，那么这个结点的父结点就是我们要找的下一结点。例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以 G 没有下一结点
         */
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
