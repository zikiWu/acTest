package leetCode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * 进阶：你能尝试使用一趟扫描实现吗
 */

 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution19 {


    public static ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (n > 0){
            l1 = l1.next;
            n --;
        }
        ListNode pre = null;
        while (l1 != null){
            l1 = l1.next;
            pre = l2;
            l2 = l2.next;
        }
        if(pre == null){
            return head.next;
        }else {
            pre.next = l2.next;
        }
        return head;
    }




    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode first = head;
        ListNode head2 = head;
        ListNode pre = null;
        for (int i = 0;i < n ;i ++){
            head2 = head2.next;
        }
        while (head2 != null){
            head2 = head2.next;
            pre = head;
            head = head.next;
        }
        if (pre == null){
            return first.next;
        }else {
            pre.next = head.next;
        }
        return first;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h1 = head;
        ListNode h2 = head;
        int i = 1;
        int j = 1;
        while (h2.next!=null&&h2.next.next!=null){
            h1 = h1.next;
            i++;
            j+=2;
            h2 = h2.next.next;
        }
        if(h2.next!=null){
            j++;
        }
        System.out.println(j+" i："+i);
        if (n == j){
            head = head.next;
            return head;
        }
        if(j-n>i){
            for (;i<j-n;i++){
                h1 = h1.next;
            }
        }else {
            h1 = head;
            i = 1;
            for (;i<j-n;i++){
                h1 = h1.next;
            }
        }
        System.out.println(h1.val);
        h1.next = h1.next.next!=null?h1.next.next:null;

        return head;
    }
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode h1 = d;
        ListNode h2 = d;
        for (int i = 1;i<=n+1;i++){
            h1 = h1.next;
        }
        while (h1 !=null){
            h1 = h1.next;
            h2 = h2.next;
        }
        h2.next = h2.next.next==null?h2.next = h2.next.next:null;
        return d.next;
    }
    public static void main(String[] args){
        ListNode l1  = new ListNode(1);
        ListNode l2  = new ListNode(2);
        ListNode l3  = new ListNode(3);
        ListNode l4  = new ListNode(4);
        ListNode l5  = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        removeNthFromEnd3(l1,5);
    }
}