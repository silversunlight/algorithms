package dynamicProgramming;

public class LongestSharedSubString {
    //求最长公共子序列
    public static int[][] getLongestCommonSequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] c = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; ++i) {
            for (int j = 0; j <= len2; ++j) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c;
    }

    //最大公共子串
    public static int[][] longestSharedSubString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] c = new int[len1 + 1][len2 + 2];
        for (int i = 0; i <= len1; ++i) {
            for (int j = 0; j <= len2; ++j) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = 0;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "dabc";
        int[][] result = getLongestCommonSequence(s1, s2);
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[i].length; ++j) {
                System.out.printf("%4d", result[i][j]);
            }
            System.out.println();
        }
    }
}
