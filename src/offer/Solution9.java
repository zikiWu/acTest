package offer;

public class Solution9 {
    public static void main(String[] args){

    }
//    public int JumpFloorII(int target) {
//        if (target == 0)
//            return 1;
//        if (target < 0)
//            return 0;
//        int num = 0;
//        for (int i = 1; i <= target; i++) {
//            num+=JumpFloorII(target-i);
//        }
//        return num;
//    }

    public static int jumpFloor(int target) {
        if (target <= 0) return 0;
        return (int) Math.pow(2, target - 1);
    }
}
