package offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_滑动窗口的最大值 {
    public static void main(String[] args){

    }

    public  ArrayList<Integer>  maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(size<1||num.length==0)return arrayList;
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0;i < num.length; i++){
            while (!link.isEmpty() && num[link.peekLast()]<num[i]){
                link.pollLast();
            }
            link.add(i);
            if (link.peekFirst() <= i - size){
                link.pollFirst();
            }
            if(i>=size-1)
            arrayList.add(num[link.peekFirst()]);
        }
        return arrayList;
    }
}
