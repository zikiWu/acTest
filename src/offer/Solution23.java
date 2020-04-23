package offer;

public class Solution23 {
    public static void main(String[] args){
        new Solution23().VerifySquenceOfBST(new int[]{5,9,7,6,9,11,10,8});
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)
            return false;
       return squenceOfBST(sequence,0,sequence.length-1);
    }
    public boolean squenceOfBST(int [] sequence,int l,int r) {
        if (l >= r)
            return true;
        int root = sequence[r];
        int i = l;
        while (sequence[i]<root){
            i++;
        }
        System.out.println(i+" "+ l+" "+r);
        for (int j = i; j < r; j++) {
            if (sequence[j]<root)
                return false;
        }
        return squenceOfBST(sequence,l,i-1) &&
                squenceOfBST(sequence,i,r-1);

    }
}
