package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Lance Sun
 * @date ：Created in 20:35 2018/10/19
 */
public class FizzBuzz472 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
