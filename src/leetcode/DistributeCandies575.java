package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：Lance Sun
 * @date ：Created in 20:13 2018/10/19
 */
public class DistributeCandies575 {
    public int distributeCandies(int[] candies) {
        int n = candies.length;
        Set<Integer> set = new HashSet<>();
        Arrays.stream(candies).parallel().forEach(a -> set.add(a));
        if (set.size() >= n / 2) {
            return n / 2;
        }
        if (set.size() < n / 2) {
            return set.size();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] candices = {1, 2, 2, 1, 3, 3};
        DistributeCandies575 a = new DistributeCandies575();
        System.out.println(a.distributeCandies(candices));
    }
}
