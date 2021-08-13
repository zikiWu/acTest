package offer;


/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下
 * 四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，
 * 机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子?
 */

public class Solution66 {

    public static void main(String[] args){
        System.out.println(numSum(152));
        numSum(10);

        System.out.println(new Solution66().movingCount(5,10,10));
    }

    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] isrun = new boolean[rows][cols];
        return moving(threshold, rows, cols, 0, 0, isrun);
    }

    public int moving(int threshold, int rows, int cols, int i ,int j, boolean[][] isrun)
    {
        if (i >= rows || j >= cols || i < 0 || j < 0 || isrun[i][j] || numSum(i) + numSum(j) > threshold){
            return 0;
        }

        isrun[i][j] = true;
        int sum = moving(threshold, rows, cols , i + 1, j, isrun) +
                moving(threshold, rows, cols , i - 1, j, isrun) +
                moving(threshold, rows, cols , i, j + 1, isrun) +
                moving(threshold, rows, cols , i, j - 1, isrun) + 1;
        return sum;
    }


    public static int numSum(int num){
        int sum = 0;
        while (num / 10 != 0){
            sum += num %10;
            num = num / 10;
        }
        sum += num %10;
        return sum;
    }
}
