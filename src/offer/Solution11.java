package offer;

public class Solution11 {
    public static void main(String[] args){

    }
    public int NumberOf1(int n) {

        int num = 0;
        while (n!=0){
            n = n&n-1;
            num++;
        }
        return num;
    }
}
