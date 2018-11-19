package leetcode;

import java.util.Arrays;

/**
 * @author ：Lance Sun
 * @date ：Created in 17:35 2018/9/28
 * @description：
 * @modifiedBy：
 * @version: 1.0.0
 */
public class SmallestRangeI908 {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        int max = A[A.length - 1];
        int min = A[0];
        if (max - min <= 2 * K) {
            return 0;
        }
        return max - min - 2 * K;
    }
}
