package suanfabiji;

import java.util.Scanner;

/**
 * @Author ：sunlight
 * @Date ：Created in 19:36 2018/9/18
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class LIS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[i] >= a[j] && (dp[j] + 1 > dp[i])) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
