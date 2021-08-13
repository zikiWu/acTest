package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class Solution23 {
    public static void main(String[] args){
        ListNode[] lists = new ListNode[2];
        ListNode n1 = new ListNode(-2);
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (ListNode n : lists) {
            if (n != null)
                priorityQueue.add(n);
        }
        ListNode first = new ListNode(0);
        ListNode node = first;
        while (!priorityQueue.isEmpty()){
            ListNode curNode = priorityQueue.remove();
            node.next = curNode;
            node = node.next;
            if (curNode.next != null)
              priorityQueue.offer(curNode.next);

        }
        return first.next;
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
