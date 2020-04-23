package offer;

public class Solution37 {
    public static void main(String[] args){
        System.out.println(new Solution37().GetNumberOfK(new int[]{3,3,3,3,4,5},3));
    }
    public int GetNumberOfK(int [] array , int k) {
        int i = 0;
        int j = array.length-1;
        if (j<0)
            return 0;
        int mid = (i+j)/2;
        while (i>j && array[mid] != k ){
            if (array[mid] > k)
                i = mid+1;
            else
                j = mid -1;
        }
        if (array[mid] != k)
            return 0;
        int l = mid-1;
        int r = mid+1;
        int num = 1;
        while (l>=0 && array[l--] == k)
            num++;
        while (r<array.length && array[r++] == k)
            num++;
        return num;
    }
}
