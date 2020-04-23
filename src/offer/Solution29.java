package offer;

import java.util.ArrayList;
import java.util.Collections;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class Solution29 {
    public static void main(String[] args){
       new Solution29().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || input.length < k || k == 0)
            return list;
        int i = 0;
        int j = input.length-1;
        int mid = k-1;
        int mmd = pation(input,i,j);
        while (mmd!=mid){
            if (mmd>mid){
                j = mmd-1;
            }else if(mmd<mid){
                i = mmd+1;
            }
            mmd = pation(input,i,j);
        }
        for (int l = 0; l < k; l++) {
            list.add(input[l]);
        }
        Collections.sort(list);
        return list;
    }
    public int pation(int [] array,int i,int j) {
        int len = j;
        int mid = array[j];
        while (i<j){
            while (i<j && array[i]<=mid){
                i++;
            }
            while (i<j && array[--j]>mid);
            if (i<j)
                swap(array,i,j);
        }
        swap(array,i,len);
        return i;
    }
    public static void swap(int[] nums,int j,int i) {
        if (i == j)
            return;
        int tamp = nums[i];
        nums[i] = nums[j];
        nums[j] = tamp;
    }
}
