package leetCode;


/**
 * 92. 反转链表 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class Solution92 {

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;


        new Solution92().reverseBetween2(head, 2,4);
    }



    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode r = head;
        ListNode l1 = null;
        int index = 1;

        while (r != null){
            if (index == left){
                break;
            }
            index ++;
            l1 = r;
            r = r.next;
        }
        ListNode reverseLast = r;
        ListNode pre = null;
        while (r != null && index <= right){
            ListNode next = r.next;
            r.next = pre;
            pre = r;
            r = next;
            index ++;
        }
        if (l1 != null){
            l1.next = pre;
        }else {
            head = pre;
        }
        reverseLast.next = r;
        return head;
    }









    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        head1.next = head;
        head2.next = head;
       for (int i1 = 0;i1<m-n;i1++){
           head1 = head1.next;
       }
       for (int i = 0; i<m-1;i++){
           head2 = head2.next;
       }

       head2.next = head1.next;
        return head;
    }

}