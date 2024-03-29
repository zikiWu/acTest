package offer;

import java.util.HashMap;
import java.util.Map;

public class Solution50 {
    public static void main(String[] args){

    }
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            map.put(numbers[i],i);
        }
        return false;
    }

    public int duplicate(int[] numbers) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])){
                return numbers[i];
            }
            map.put(numbers[i],i);
        }
        return -1;
    }
}
