package offer;

public class Solution28 {
    public static void main(String[] args){
        System.out.println(new Solution28().MoreThanHalfNum_Solution(new int[]{2,2,1,2,2,1,3,4,1}));

    }
    public int MoreThanHalfNum_Solution(int [] array) {
        int time = 1;
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == temp){
                time++;
            }else {
                time--;
            }
            if (time == 0){
                temp = array[i];
                time = 1;
            }
        }
        time = 0;
        for (int k = 0; k < array.length; k++) {
            if(array[k]==temp)
                time++;
        }
        return time*2>array.length?temp:0;
    }


    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array.length == 0)
            return 0;
        int i = 0;
        int j = array.length-1;
        int mid = (i+j)/2;
        int mmd = pation(array,i,j);
        while (mmd!=mid && i<mid && j>mid){
            if (mmd>mid){
                j = mmd-1;
            }else if(mmd<mid){
                i = mid+1;
            }
            mmd = pation(array,i,j);
        }
        System.out.println(mmd+" "+mid);
        if (mmd!=mid)
            return 0;
        int time = 0;
        for (int k = 0; k < array.length; k++) {
            if(array[k]==array[mmd])
                time++;
        }
        System.out.println(time);
        return time*2>array.length?array[mmd]:0;
    }
    public int pation(int [] array,int i,int j) {
        int len = j;
        int mid = array[j];
        while (i<j){
            while (i<j && array[i]<=mid){
                i++;
            }
            while (i<j && array[j]>mid){
                j--;
            }
            if (i<j)
                swap(array,i,j);
        }
        swap(array,i,len);
        return i;
    }
    public static void swap(int[] nums,int j,int i) {
        if (i == j)
            return;
        int tamp = nums[i];
        nums[i] = nums[j];
        nums[j] = tamp;
    }
}
