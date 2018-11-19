package suanfabiji;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author ：sunlight
 * @Date ：Created in 20:47 2018/9/18
 * @Description：最长回文子串
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class LRS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = new String[100];
        int i=0;
        while (in.hasNext()) {
            a[i++]=in.next();
        }
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }
}
