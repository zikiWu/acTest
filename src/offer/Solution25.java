package offer;


public class Solution25 {
    public static void main(String[] args){
        RandomListNode h =  new RandomListNode(1);
        RandomListNode h2 =  new RandomListNode(2);
        RandomListNode h3 =  new RandomListNode(3);
        h.next = h2;
        h.random = h3;
        h2.next = h3;
        h2.random = h;
        h3.random = h;
        new Solution25().Clone(h);
    }
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return pHead;
        RandomListNode cur = pHead;
        while (cur!=null){
            RandomListNode copyNode = new RandomListNode(cur.label);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = copyNode.next;
        }
        cur = pHead;
        RandomListNode copyCur  = null;
        while (cur!=null){
            copyCur = cur.next;
            if (cur.random !=null)
                copyCur.random = cur.random.next;
            cur = copyCur.next;
        }
        RandomListNode ptr_old_list = pHead; // A->B->C
        RandomListNode ptr_new_list = pHead.next; // A'->B'->C'
        RandomListNode head_old = pHead.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }

}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
