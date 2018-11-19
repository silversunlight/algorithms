package leetcode;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 19:14 2018/9/21
 * @Description：给定一个数组,把偶数交换到前面,奇数放到后面
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class ArrayPartition561 {
    public static int[] sortArrayByPairty(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        int head = 0;
        int tail = A.length - 1;
        while (head < tail) {
            if (A[head] % 2 == 1 && A[tail] % 2 == 0) {
                int temp = A[head];
                A[head] = A[tail];
                A[tail] = temp;
                head++;
                tail--;
            }
            if (A[head] % 2 == 0) {
                head++;
            }
            if (A[tail] % 2 == 1) {
                tail--;
            }
        }
        return A;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        Arrays.stream(sortArrayByPairty(nums)).spliterator().forEachRemaining((IntConsumer) i -> System.out.println(i));
    }
}
