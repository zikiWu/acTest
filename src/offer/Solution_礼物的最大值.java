package offer;

public class Solution_礼物的最大值 {
    public static void main(String[] args){

    }
    private static int sum(int[][] a,int row,int col) {
        if (row == a.length && col == a[0].length){
            return a[row][col];
        }
        if (row == a.length)
            return a[row][col] + sum(a,row,col+1);
        if (col == a.length)
            return a[row][col] + sum(a,row+1,col);
        return a[row][col]+Math.max(sum(a,row+1,col),sum(a,row,col+1));
    }
    public static int getMaxValue(int[][] a) {
        if(a==null||a.length==0||a[0].length==0)
            return 0;
        int row = a.length;
        int col = a[0].length;
        //定义二维数组来保存中间结果
        int[][] maxValues = new int[row][col];
        for(int i = 0;i < row;i++)
            for(int j =0;j < col;j++)
            {
                //原点
                if(i==0 && j==0)
                {
                    maxValues[i][j] = a[i][j];
                }
                //上边界
                else if(i==0 && j!=0)
                {
                    maxValues[i][j] = a[i][j] + maxValues[i][j-1];
                }
                //左边界
                else if(i!=0&&j==0)
                {
                    maxValues[i][j] = a[i][j] + maxValues[i-1][j];
                }
                else {
                    maxValues[i][j] = a[i][j] + Math.max(maxValues[i][j-1], maxValues[i-1][j]);
                }

            }
        return maxValues[row-1][col-1];
    }
}
