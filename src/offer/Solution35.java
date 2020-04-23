package offer;

public class Solution35 {
    static int result = 0;
    public static void main(String[] args){
        int[] a = new int[]{5,8,6,0,4,9,3,1,4};
        new Solution35().mergeSort(a,0,a.length-1);
        System.out.println(result);
    }
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length-1);
        return result%1000000007;
    }
    public void mergeSort(int [] array, int l, int r) {
        if (l>=r)
            return;
        int mid = (l+r)/2;
        mergeSort(array,l,mid);
        mergeSort(array,mid+1,r);
        merge(array,l,mid,r);
    }
    public int merge(int [] array, int l, int mid, int r) {
        int[] temp = new int[array.length];
        int i = l;
        int j = mid+1;
        int num = l;
        while (i<=mid && j<=r ){
            if (array[i]<=array[j]){
                temp[num++] = array[i++];
            }else {
                temp[num++] = array[j];
                result+=mid-i+1;
                j++;
            }
        }
        while (i<=mid){
            temp[num++] = array[i++];
        }
        while (j<=r){
            temp[num++] = array[j++];
        }
        for (int k = l; k <= r; k++) {
            array[k] = temp[k];
        }
        return 0;
    }
}
