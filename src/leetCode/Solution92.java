package leetCode;




import java.util.ArrayList;
import java.util.List;

public class Solution92 {

    public static void main(String[] args){

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