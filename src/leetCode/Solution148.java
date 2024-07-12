package leetCode;

/**
 * 148. 排序链表
 * 中等
 * 相关标签
 * 相关企业
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class Solution148 {
    public static void main(String[] args){
        ListNode head = new ListNode(4);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(1);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        System.out.println(new Solution148().sortList(head).val);
    }

    public ListNode sortList(ListNode head) {
        if (head == null){
            return null;
        }
        return sort(head);
    }

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode left = sort(head);
        ListNode right =  sort(next);
        return merge(left, right);
    }

    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head;
        ListNode next2 = head.next.next;
        while (next2 != null){
            next = next.next;
            next2 = next2.next;
            if (next2 != null){
                next2 = next2.next;
            }
        }
        return next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        if (head1.val < head2.val){
            head1.next = merge(head1.next, head2);
            return head1;
        }else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }


}
