package leetCode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Solution48 {
    public static void main(String[] args){
        new Solution48().rotate(new int[][]{
                {1,2},{3,4}
        });
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
        Lock rl = rw.readLock();
        Lock wl = rw.writeLock();
        rl.lock();
        rl.unlock();
        wl.lock();
        wl.unlock();
    }
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0 ;i<r; i++){
            for (int j = 0 ;j<i; j++){
                swap(matrix,i,j,j,i);
            }
        }
        for (int i = 0 ;i<r; i++){
            for (int j = 0 ;j<r/2; j++){
                swap(matrix,i,j,i,r-j-1);
            }
        }
    }
    public  void swap(int[][] nums,int i,int j,int n ,int m) {
        int tamp = nums[i][j];
        nums[i][j] = nums[n][m];
        nums[n][m] = tamp;
    }
}
