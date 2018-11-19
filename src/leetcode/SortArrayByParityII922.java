package leetcode;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @author ：Lance Sun
 * @date ：Created in 15:44 2018/10/16
 */
public class SortArrayByParityII922 {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int i = 1, j = 0;
        while (i < n && j < n) {
            //i为奇数，A[i]为偶数，j为偶数，A[j]为奇数，交换
            if (isOdd(i) && isEven(A[i]) && isEven(j) && isOdd(A[j])) {
                swap(A, i, j);
            }
            if (isOdd(A[i])) {
                i += 2;
            }
            if (isEven(A[j])) {
                j += 2;
            }
        }
        return A;
    }

    public void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public boolean isOdd(int x) {
        return x % 2 == 1;
    }

    public boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static void main(String[] args) {
        int[] A = {2,4,5,7};
        SortArrayByParityII922 sortArrayByParityII922 = new SortArrayByParityII922();
        int[] b = sortArrayByParityII922.sortArrayByParityII(A);
        Arrays.stream(b).spliterator().forEachRemaining((IntConsumer) a -> System.out.print(a + " "));
    }
}
