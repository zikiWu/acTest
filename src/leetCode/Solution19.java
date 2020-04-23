package leetCode;


 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution19 {
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
        removeNthFromEnd2(l1,2);
    }
}