package common48;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author Lance Sun
 * @date Created in 9:23 2018/11/2
 * @description 在一个元素为1到100的整数数组中，如何寻找缺失元素？
 */

public class FindLostElement {
    public static void main(String[] args) {
        // one missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

        // two missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

        // three missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

        // four missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

        // Only one missing number in array
        int[] iArray = new int[]{1, 2, 3, 5};
        int missing = getMissingNumber(iArray, 5);
        System.out.printf("Missing number in array %s is %d %n",
                Arrays.toString(iArray), missing);
    }

    /**
     * 只有一个缺失元素的情况
     *
     * @param iArray
     * @param i
     * @return
     */
    private static int getMissingNumber(int[] iArray, int n) {
        int expected = (n + 1) * n / 2;
        int sum = 0;
        for (int i : iArray) {
            sum += i;
        }
        return expected - sum;
    }

    /**
     * 可能缺失多个的情况
     *
     * @param ints
     * @param n
     */
    private static void printMissingNumber(int[] ints, int n) {
        int missing = n - ints.length;
        BitSet bitSet = new BitSet();
        for (int i : ints) {
            bitSet.set(i - 1);
        }
        int lastIndex = 0;
        for (int i = 0; i < missing; i++) {
            lastIndex = bitSet.nextClearBit(lastIndex);
            System.out.println(++lastIndex);
        }
    }
}
