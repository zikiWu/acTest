package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Solution2 {
    public static void main(String[] args){

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int isAdd = 0;
        ListNode node = new ListNode(0);
        ListNode node2 = node;
        while (l1 != null || l2 != null){
            if (l1 == null){
                l1= new ListNode(0);
            }
            if (l2 == null){
                l2 = new ListNode(0);
            }
            int temSum = l1.val + l2.val + isAdd;

            if (temSum == 10){
                node.next = new ListNode(0);
                isAdd  = 1;
            }else if (temSum > 10){
                node.next = new ListNode(temSum%10);
                isAdd = 1;
            }else {
                node.next = new ListNode(temSum);
                isAdd = 0;
            }
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (isAdd == 1){
            node.next = new ListNode(1);
        }
        return node2.next;
    }
}
