package leetcode;

/**
 * @author ：Lance Sun
 * @date ：Created in 19:47 2018/10/17
 */
public class BinaryGap868 {
    public int binaryGap(int N) {
        int count = 0;
        int temp = -1000;
        int number = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                count = Math.max(count, temp);
                temp = 0;
                number++;
            }
            temp++;
            N >>= 1;
        }
        if (number <= 1) {
            return 0;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        BinaryGap868 a = new BinaryGap868();
        System.out.println(a.binaryGap(22));
        System.out.println(a.binaryGap(5));
        System.out.println(a.binaryGap(6));
        System.out.println(a.binaryGap(8));
        System.out.println(a.binaryGap(12));
    }
}
