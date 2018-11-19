package leetcode;

/**
 * @author ：Lance Sun
 * @date ：Created in 17:54 2018/10/17
 */
public class ToeplitzMatrix766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        return horizon(matrix) && vertical(matrix);
    }

    private boolean vertical(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            //q是列
            int p = 0, q = i;
            while ((p + 1) < m && (q + 1) < n) {
                if (matrix[p][q] != matrix[p + 1][q + 1]) {
                    return false;
                }
                p++;
                q++;
            }
        }
        return true;
    }

    private boolean horizon(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            //q是行
            int p = 0, q = i;
            while ((p + 1) < n && (q + 1) < m) {
                if (matrix[q][p] != matrix[q + 1][p + 1]) {
                    return false;
                }
                p++;
                q++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
        };
        ToeplitzMatrix766 a = new ToeplitzMatrix766();
        System.out.println(a.isToeplitzMatrix(matrix));
    }
}
