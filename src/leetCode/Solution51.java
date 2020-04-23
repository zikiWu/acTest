package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    public static void main(String[] args){
        List<List<String>> result = new ArrayList<>();
        a(0,4,result,new int[4]);
    }
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        a(0,4,result,new int[4]);
        return result;
    }

    public static void a(int i,int n,List<List<String>> result,int[] visit) {
        if (i == n){
            String[][]arr = new String[n][n];
            for (int k =0;k<n;k++){
                for (int q =0;q<n;q++){
                    arr[k][q] = ".";
                }
            }
            for (int k =0;k<visit.length;k++){
                arr[k][visit[k]] = "Q";
            }
            List<String> ls = new ArrayList<>();
            for (int k =0;k<n;k++){
                StringBuilder sb = new StringBuilder();
                for (int q =0;q<n;q++){
                    System.out.print(arr[k][q]);
                    sb.append(arr[k][q]);
                }
                System.out.println();
                ls.add(sb.toString());
            }
            result.add(ls);
        }else {
            for (int j = 0;j<n;j++){
                if (isSalve(i,j,visit)){
                    visit[i] = j;
                    a(i+1,n,result,visit);
                }
            }
        }
    }
    //第i行，第j个
    public static boolean isSalve(int i,int j,int[] visit) {
        for (int k = 0;k<i;k++){
            if (visit[k] == j || Math.abs(j-visit[k])==Math.abs(k-i)){
                return false;
            }
        }
        return true;
    }
}
