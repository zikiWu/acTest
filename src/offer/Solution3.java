package offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    public static void main(String[] args){

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> arrayLink = new LinkedList<>();
        while (listNode != null){
            arrayLink.addFirst(listNode.val);
            listNode =listNode.next;
        }
        arrayList.addAll(arrayLink);
        return arrayList;
    }
}
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int x) { val = x; }
}