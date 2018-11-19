package dynamicProgramming;

/**
 * 多重背包问题，第i件物品最多有n[i]件可用
 */
public class Bag3 {
    //空间复杂度是N*V，时间复杂度是O(N*∑n[i])
    public static int[][] getResult(int n, int v, int[] costs, int[] values, int[] numbers) {
        int[][] result = new int[n + 1][v + 1];
        for (int i = 0; i <= n; ++i) {
            result[i][0] = 0;
        }
        for (int i = 0; i <= v; ++i) {
            result[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {
                if (j > costs[i - 1]) {
                    int recent = 0;
                    for (int k = 0; k * costs[i - 1] <= j && k <= numbers[i - 1]; k++) {
                        int value = result[i - 1][v - k * costs[i - 1]] + k * values[i - 1];
                        recent = recent > value ? recent : value;
                    }
                    result[i][j] = recent;
                }
            }
        }
        return result;
    }

    //这个暂时还有问题，发现不了问题还
    public static int[] getResult_v1(int n, int v, int[] costs, int[] values, int[] numbers) {
        int[] result = new int[v + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j * costs[i - 1] <= v && j < numbers[i - 1]; ++j) {
                zeroOnePack(v, j * costs[i - 1], j * values[i - 1], result);
            }
        }
        return result;
    }

    public static void zeroOnePack(int v, int cost, int value, int[] result) {
        for (int i = v; i >= cost; --i) {
            result[i] = Math.max(result[i], result[i - cost] + value);
        }
    }

    public static void main(String[] args) {
        int[] costs = {2, 3, 5, 6, 7};
        int[] values = {3, 5, 1, 4, 8};
        int[] numbers = {5, 2, 5, 6, 8};
        int[][] results = getResult(5, 20, costs, values, numbers);
        for (int i = 0; i < costs.length + 1; ++i) {
            for (int j = 0; j <= 20; ++j) {
                System.out.printf("%4d", results[i][j]);
            }
            System.out.println();
        }
        int[] result2 = getResult_v1(5, 20, costs, values, numbers);
        for (int i = 0; i < result2.length; ++i) {
            System.out.printf("%4d", result2[i]);
        }
    }
}
