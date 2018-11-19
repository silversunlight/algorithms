package leetcode;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 18:58 2018/9/22
 * @Description：矩阵旋转
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class TransposeMatrix867 {
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
