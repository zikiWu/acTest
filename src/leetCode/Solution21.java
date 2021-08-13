package leetCode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 */
public class Solution21 {
    public static void main(String[] args){

        ReentrantLock reentrantLock = new ReentrantLock();
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode  node;
        if (l1.val < l2.val){
             node = new ListNode(l1.val);
            node.next = mergeTwoLists(l1.next, l2);
        }else {
             node = new ListNode(l2.val);
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }


    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            else if (l2 == null) {
                return l1;
            }
            else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }

        }
    }
}
