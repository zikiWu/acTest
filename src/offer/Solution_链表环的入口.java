package offer;

public class Solution_链表环的入口 {
    public static void main(String[] args){

    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        //是否有环
        ListNode n1 = pHead;
        ListNode n2 = pHead;
        if (n2 == null || n2.next ==null)
            return null;
        n1 = n1.next;
        n2 = n2.next.next;
        while (n1!=n2){
            n1 = n1.next;
            if (n2 == null || n2.next ==null)
                return null;
            n2 = n2.next.next;
        }
        n1 = pHead;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
