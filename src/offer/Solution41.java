package offer;

import java.util.ArrayList;

public class Solution41 {
    public static void main(String[] args){
        new Solution41().FindContinuousSequence(100);
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists =  new ArrayList<ArrayList<Integer>>();
        int i = 1;
        int j = 2;
        int sumq = i+j;
        ArrayList<Integer> list ;
        while (i<j){
            if(sumq == sum){
                list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(k);
                }
                lists.add(list);
                System.out.println(i+" "+j);
            }
            if (sum > sumq){
                j++;
                sumq+=j;
            }else {
                sumq-=i;
                i++;
            }
        }
        return lists;
    }
}
