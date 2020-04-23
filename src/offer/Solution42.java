package offer;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution42 {
//    输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
//    如果有多对数字的和等于S，输出两个数的乘积最小的。

    public static void main(String[] args){
        new Solution42().FindNumbersWithSum(new int[]{1,2,3,4,5,6,7,8},6);
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0;
        int j = array.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        while (i<j){
            if (array[i]+array[j] == sum){
                list.add(0,array[i]);
                list.add(1,array[j]);
                System.out.println(array[i]+" "+array[j]);
                break;
            }else if (array[i]+array[j] < sum){
                System.out.println(i);
                i++;
            }else if (array[i]+array[j] > sum){

                System.out.println(i);
                j--;
            }
        }
        return list;
    }
}
