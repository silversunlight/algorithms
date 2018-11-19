package leetcode;

/**
 * @author ：Lance Sun
 * @date ：Created in 20:50 2018/10/19
 */
public class ReshapeTheMatrix566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if (r * c != row * column) {
            return nums;
        }
        int[][] result = new int[r][c];
        int i1 = 0, j1 = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[i1][j1];
                j1++;
                if (j1 >= column) {
                    j1=0;
                    i1++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2},
                {3, 4}
        };
        ReshapeTheMatrix566 a = new ReshapeTheMatrix566();
        int[][] result = a.matrixReshape(nums, 1, 4);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
