package leetCode;

public class Solution74 {
    public static void main(String[] args) {
        searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20},{23,30,34,60}}, 3);
        searchMatrix(new int[][]{{1}}, 1);
    }

    public static   boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int l = matrix[0].length;
        int minR = 0;
        int maxR = r - 1;
        if (target > matrix[r - 1][l  - 1] || target < matrix[0][0]){
            return false;
        }
        while (minR < maxR){
            int mid = (minR + maxR) / 2;
            if (matrix[mid][l - 1] == target){
                return true;
            }else if (matrix[mid][l - 1] < target){
                minR = mid + 1;
            }else {
                maxR = mid;
            }
        }
        int curR = minR;
        if (matrix[minR][l-1] < target){
            curR ++;
        }
        int minL = 0;
        int maxL = l - 1;
        while (minL < maxL){
            System.out.println(minL + " " + maxL);
            int mid = (minL + maxL) / 2;
            if (matrix[curR][mid] == target){
                return true;
            }else if (matrix[curR][mid] < target){
                minL = mid + 1;
            }else {
                maxL = mid;
            }
        }
        return matrix[curR][maxL] == target;
    }

}
