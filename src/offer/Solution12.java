package offer;

public class Solution12 {
    public static void main(String[] args){

        new Solution12().Power(2,7);
    }
    public double Power(double base, int exponent) {
        if (base == 0)
          return 0;
        double num = Power2(base,Math.abs(exponent));

        System.out.println(num);
        if (exponent < 0)
            num = 1/num;
        System.out.println(num);
        return num;
    }

    public double Power2(double base, int exponent) {

        if (exponent == 0)
            return 1;
        if (exponent == 1 )
            return base;
        double num = Power2(base,exponent>>1);
        num*=num;
        if ((exponent & 0x1) == 1)
            num = num*base;
        return num;
    }
}
