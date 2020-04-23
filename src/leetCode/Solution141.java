package leetCode;

public class Solution141 {
    public static void main(String[] args){

    }
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode head2 = head;
        while (head.next!=null && head2.next!=null && head2.next.next!=null){
            head = head.next;
            head2 = head2.next.next;
            if (head == head2){
                return true;
            }
        }
        return false;
    }
}
