package suanfabiji;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Codeup1934 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new FileInputStream("C:\\Users\\lang.sun\\Desktop\\input.txt"));
        int n = in.nextInt();
        int[][] f = new int[n + 1][n + 1], dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = in.nextInt();
            }
        }
        for (int j = 1; j <= n; j++) {
            dp[n][j] = f[n][j];
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + f[i][j];
            }
        }
        System.out.println(dp[1][1]);
    }
}
