package leetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution23 {
    public static void main(String[] args){
        ListNode[] lists = new ListNode[2];
        ListNode n1 = new ListNode(-2);
    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> p = new PriorityQueue<>((o1,o2)->o1.val - o2.val);
        for (ListNode listNode : lists){
            if (listNode != null)
                p.add(listNode);
        }
        ListNode n = new ListNode(0);
        ListNode head = n;
        while (!p.isEmpty()){
            n.next = p.poll();
            n = n.next;
            if(n.next != null)
                p.add(n.next);
        }
        return head.next;
    }
}
