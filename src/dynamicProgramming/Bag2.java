package dynamicProgramming;

/**
 * 完全背包问题，每个物品都有无限件可用
 */
public class Bag2 {
    //使用基本方法的，只是在V的循环之后，又多了一个每种物品件数的循环
    //这是用了N*V空间的，时间复杂度大于N*V
    public static int[][] getResult(int n, int v, int[] costs, int[] values) {
        int[][] result = new int[n + 1][v + 1];
        for (int i = 0; i <= n; ++i) {
            result[i][0] = 0;
        }
        for (int i = 0; i <= v; ++i) {
            result[0][i] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= v; ++j) {
                if (j > costs[i - 1]) {
                    int recent = 0;
                    for (int k = 0; k * costs[i - 1] <= j; ++k) {
                        int value = result[i - 1][j - k * costs[i - 1]] + k * values[i - 1];
                        recent = recent > value ? recent : value;
                    }
                    result[i][j] = recent;
                }
            }
        }
        return result;
    }

    //todo 将问题转化为基本的01背包问题
    public static int[] getResult_v2(int n, int v, int[] costs, int[] values) {
        int[] result = new int[v + 1];
        for (int i = 0; i < result.length; ++i) {
            result[i] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= v / costs[i - 1]; j++) {
                zeroOnePack(costs[i - 1], values[i - 1], v, result);
            }
        }
        return result;
    }

    public static void zeroOnePack(int cost, int value, int v, int[] result) {
        for (int i = v; v >= cost; --v) {
            result[i] = Math.max(result[i], result[i - cost] + value);
        }
    }

    //这种方法是O(VN)的，v的循环从costs[i]->V,就已经涵盖了每种物品取多件
    public static int[] getResult_v1(int n, int v, int[] costs, int[] values) {
        int[] result = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            result[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = costs[i - 1]; j <= v; j++) {
                result[j] = Math.max(result[j], result[j - costs[i - 1]] + values[i - 1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] costs = {2, 3, 5, 6, 7};
        int[] values = {3, 5, 1, 4, 8};
        System.out.println("这是基本方法的输出结果");
        int[][] result = Bag2.getResult(5, 20, costs, values);
        for (int i = 0; i <= 5; ++i) {
            for (int j = 0; j <= 20; ++j) {
                System.out.printf("%5d", result[i][j]);
            }
            System.out.println();
        }
        System.out.println("这是优化的O(V)的方法输出的结果");
        int[] result2 = Bag2.getResult_v1(5, 20, costs, values);
        for (int i = 0; i <= 20; i++) {
            System.out.printf("%5d", result2[i]);
        }

        System.out.println("这是转化为01背包问题输出的结果");
        int[] result3 = getResult_v2(5, 20, costs, values);
        for (int i = 0; i <= 20; i++) {
            System.out.printf("%5d", result3[i]);
        }
    }
}
