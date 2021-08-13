package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 *
 */

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


    public  ArrayList<Integer>  maxInWindows2(int [] num, int size)
    {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        if(size<1||num.length==0)return resultList;
        for (int i = 0; i < num.length ; i++){
            while (linkedList.size() != 0 && num[linkedList.peekLast()] < num[i]){
                linkedList.removeLast();
            }
            linkedList.addLast(i);
            if (i - linkedList.peekFirst() >= size){
                linkedList.removeFirst();
            }
            if (i >= size -1){
                resultList.add(num[linkedList.peekFirst()]);
            }
        }
        return resultList;
    }
}
