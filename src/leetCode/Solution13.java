package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    public static void main(String[] args){
        new Solution13().romanToInt("MCMXCIV");
        new Solution13().romanToInt("LVIII");
        new Solution13().romanToInt("IX");
        new Solution13().romanToInt("I");
    }
    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int num = 0;
        for (int i = 0;i < c.length; i++){
            if (i+1<c.length && getV(c[i]) < getV(c[i+1])){
                num+= getV(c[i+1]) - getV(c[i]);
                i++;
                continue;
            }
            num+= getV(c[i]);
        }
        System.out.println(num);
        return num;
    }
    public int getV(char c){
        if (c == 'I'){
            return 1;
        }
        if (c == 'V'){
            return 5;
        }
        if (c == 'X'){
            return 10;
        }
        if (c == 'L'){
            return 50;
        }
        if (c == 'C'){
            return 100;
        }
        if (c == 'D'){
            return 500;
        }
        if (c == 'M'){
            return 1000;
        }
        return 0;
    }
}
