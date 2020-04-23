package leetCode;

public class Solution138 {
    public static void main(String[] args){

    }
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            Node newNode = new Node();
            newNode.val = ptr.val;
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
    public Node copyRandomList2(Node pHead) {
        if (pHead == null)
            return pHead;
        Node cur = pHead;
        while (cur!=null){
            Node copyNode = new Node();
            copyNode.val = cur.val;
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = copyNode.next;
        }
        cur = pHead;
        Node copyCur  = null;
        while (cur!=null){
            copyCur = cur.next;
            if (cur.random !=null)
                copyCur.random = cur.random.next;
            cur = copyCur.next;
        }
        cur = pHead;
        Node copyHead  = pHead.next;
        copyCur  = pHead.next;
        Node nextCur  = copyCur.next;
        while (nextCur!=null){
            copyCur.next =nextCur.next;
            cur.next = nextCur;
            cur = nextCur;
            copyCur = cur.next;
            nextCur = copyCur.next;
        }
        return copyHead;
    }
}
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
