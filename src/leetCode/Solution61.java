package leetCode;

/**
 * 61. 旋转链表
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 *
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class Solution61 {
    public static void main(String[] args){

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        while (k > 0){
            l1 = l1.next;
            if (l1 == null){
                l1 = head;
            }
            k--;
        }
        if (l1 == l2){
            return l1;
        }
        ListNode l1Pre = null;
        ListNode l2Pre = null;
        while (l1 != null){
            l1Pre = l1;
            l1 = l1.next;
            l2Pre = l2;
            l2 = l2.next;
        }
        l2Pre.next = null;
        l1Pre.next = head;
        return l2;
    }

}
