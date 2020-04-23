package offer;

import java.util.*;

public class Solution32 {
    public static void main(String[] args){
        new Solution32().PrintMinNumber(new int[]{1,2,11,33});
    }
    public String PrintMinNumber(int [] numbers) {
        Arrays.sort(numbers);
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new com());
        for (int i = 0; i < numbers.length; i++) {
            priorityQueue.add(numbers[i]+"");
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            sb.append(priorityQueue.poll());
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    class com implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }
}
