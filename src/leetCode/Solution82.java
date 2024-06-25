package leetCode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Solution82 {
    public static void main(String[] args){
        ListNode l1  = new ListNode(1);
        ListNode l2  = new ListNode(2);
        ListNode l3  = new ListNode(3);
        ListNode l4  = new ListNode(3);
        ListNode l5  = new ListNode(4);
        ListNode l6  = new ListNode(4);
        ListNode l7  = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        new Solution82().deleteDuplicates(l1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode r = head;
        ListNode pre = null;
        while (r != null){
            if (r.next != null && r.val == r.next.val){
                while (r.next != null && r.val == r.next.val){
                    r = r.next;
                }
                r = r.next;
                if (pre != null){
                    pre.next = r;
                }else {
                    head = r;
                }
            }else {
                pre = r;
                r = r.next;
            }
        }
        return head;
    }

}
