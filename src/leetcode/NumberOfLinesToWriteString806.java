package leetcode;

import java.util.ArrayList;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 18:14 2018/9/22
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class NumberOfLinesToWriteString806 {
    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[2];
        int total = 0;
        int lines = 1;
        for (char c : S.toCharArray()) {
            if (total + widths[c - 'a'] > 100) {
                total = 0;
                lines++;
            }
            total += widths[c - 'a'];
        }
        res[0] = lines;
        res[1] = total;
        return res;
    }

    public static void main(String[] args) {
        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String S = "bbbcccdddaaa";
        NumberOfLinesToWriteString806 a = new NumberOfLinesToWriteString806();
        int[] res = a.numberOfLines(widths, S);
        for (int i : res) {
            System.out.println(i);
        }

    }
}
