package leetcode;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 21:26 2018/9/23
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class NumberComplement476 {
    public static int findComplement(int num) {
        int a = Integer.highestOneBit(num);
        int res = 0;
        int j = 0;
        while (a > 0) {
            a >>= 1;
            if ((num & 1) == 0) {
                res += Math.pow(2, j);
            }
            num >>= 1;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(3));
        System.out.println(findComplement(5));
        System.out.println(findComplement(16));
    }
}