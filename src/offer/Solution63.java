package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */

public class Solution63 {
    int count = 0;
    PriorityQueue<Integer> smallPriorityQueue = new PriorityQueue<>();
    PriorityQueue<Integer> bigPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public static void main(String[] args){

    }
//个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
    //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中

    public void Insert(Integer num) {
        if (count % 2 == 0){
            bigPriorityQueue.offer(num);
            smallPriorityQueue.offer(bigPriorityQueue.poll());
        }else {
            smallPriorityQueue.offer(num);
            bigPriorityQueue.offer(smallPriorityQueue.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 1){
            return new Double(smallPriorityQueue.peek());
        }else {
            return (new Double(smallPriorityQueue.peek())+new Double(bigPriorityQueue.peek()))/2;
        }
    }
}
