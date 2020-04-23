package offer;

public class Solution10 {
    public static void main(String[] args){

    }
    public int RectCover(int target) {
        if (target == 0)
            return 0;
        if (target < 2)
            return 1;
        int i1 = 1;
        int i2 = 1;
        int num = 1;
        for (int i = 2; i <= target; i++) {
            num = i1+i2;
            i1 = i2;
            i2 = num;
        }
        return num;
    }
}
