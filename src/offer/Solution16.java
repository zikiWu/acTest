package offer;

public class Solution16 {
    public static void main(String[] args){

    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode listNode = null;
        if (list1.val<list2.val){
            listNode = list1;
            listNode.next = Merge(list1.next,list2);
        }else {
            listNode = list2;
            listNode.next = Merge(list1,list2.next);
        }
        return listNode;
    }
}
