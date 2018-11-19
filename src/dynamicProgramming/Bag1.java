package dynamicProgramming;

/**
 * 背包问题
 */
public class Bag1 {

    //占用空间N*V的方法，使用了二维数组
    public static int[][] getResult(int n, int v, int[] costs, int[] values) {
        int[][] results = new int[n + 1][v + 1];
        int[][] paths = new int[n + 1][v + 1];
        for (int i = 0; i < paths.length; ++i) {
            for (int j = 0; j < paths[i].length; ++j) {
                paths[i][j]=0;
            }
        }
        for (int i = 0; i <= n; ++i) {
            results[i][0] = 0;
        }
        for (int i = 0; i <= v; ++i) {
            results[0][i] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= v; j++) {
                if (j > costs[i - 1]) {
                    if (results[i - 1][j] > results[i - 1][j - costs[i - 1]] + values[i - 1]) {
                        results[i][j] = results[i - 1][j];
                    } else {
                        results[i][j] = results[i - 1][j - costs[i - 1]] + values[i - 1];
                        paths[i][j]=1;
                    }
                }
            }
        }

        //输出数组paths的过程
        for (int i = 0; i < paths.length; ++i) {
            for (int j = 0; j < paths[i].length; ++j) {
                System.out.printf("%4d", paths[i][j]);
            }
            System.out.println();
        }
        return results;
    }

    //占用空间V的方法
    public static int[] getResult_v1(int n, int v, int[] costs, int[] values) {
        int[] result = new int[v + 1];
        /**
         * 初始化的时候，分为恰好装满和无需装满
         * 如果无需装满，初始化为0就可以了
         * 如果需要恰好装满，result[0]初始化为0，其余的要初始化为负值
         */
        for (int i = 0; i < v + 1; ++i) {
            result[i] = 0;//无需装满
        }
        for (int i = 1; i <= n; ++i) {
            zeroOnePack(v, costs[i - 1], values[i - 1], result);
        }
        return result;
    }

    //处理一个物品是否放入背包的过程
    public static void zeroOnePack(int v, int cost, int value, int[] result) {
        //这里的下限是cost是因为在一件物品的01问题中，明显容量小于cost的情况
        //不会影响到结果
        for (int i = v; i >= cost; --i) {
            result[i] = Math.max(result[i], result[i - cost] + value);
        }
    }

    public static void main(String[] args) {
        int[] costs = {2, 3, 5, 6, 7};
        int[] values = {3, 5, 1, 4, 8};
        int[][] results = getResult(5, 20, costs, values);
        for (int i = 0; i < costs.length + 1; ++i) {
            for (int j = 0; j <= 20; ++j) {
                System.out.printf("%4d", results[i][j]);
            }
            System.out.println();
        }
        int[] result2 = getResult_v1(5, 20, costs, values);
        for (int i = 0; i < result2.length; ++i) {
            System.out.printf("%4d", result2[i]);
        }
    }
}
