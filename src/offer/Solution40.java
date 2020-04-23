package offer;

import java.util.ArrayList;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class Solution40 {
    public static void main(String[] args){
        new Solution40().FindNumsAppearOnce(new int[]{0,0,0,0,1,1,2,3,4,4,5,5},null,null);
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }
        int n = 0;
        while ((temp & 1) != 1){
            temp = temp>>1;
            n++;
        }
        int check = 1<<n;
        int a1 = 0;
        int a2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & check)==0){
                a1^=array[i];
            }else {
                a2^=array[i];
            }
        }
        num1[0] = a1;
        num2[0] = a2;
    }
}
