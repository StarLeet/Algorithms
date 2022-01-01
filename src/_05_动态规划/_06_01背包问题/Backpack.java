package _05_动态规划._06_01背包问题;

/**
 * @ClassName Backpack
 * @Description
 * @Author StarLee
 * @Date 2021/12/31
 */
@SuppressWarnings("all")
public class Backpack {
    /**
     * 恰好装满
     */
    static int maxValue4(int[] values, int[] weights, int capacity) {
        // 检测非法数据
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (weights.length != values.length) return 0;
        if (capacity <= 0) return 0;

        int[] dp = new int[capacity + 1];
        for (int j = 1; j <= capacity; j++) {
            dp[j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j],
                        dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity] < 0 ? -1 : dp[capacity];
    }

    /**
     * 一维数组二次优化
     */
    static int maxValue3(int[] values, int[] weights, int capacity) {
        // 检测非法数据
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (weights.length != values.length) return 0;
        if (capacity <= 0) return 0;

        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j],
                        dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity];
    }

    /**
     * 转用一维数组
     */
    static int maxValue2(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (weights.length != values.length) return 0;
        if (capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= 1; j--) {
                if (j < weights[i - 1]) continue;
                dp[j] = Math.max(dp[j],
                        dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity];
    }

    /**
     * 动态规划
     */
    static int maxValue1(int[] values, int[] weights, int capacity) {
        // 检测非法输入
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (weights.length != values.length) return 0;
        if (capacity <= 0) return 0;

        // 特征方程: dp(i, j) 是最大承重为 j、有前 i 件物品可选时的最大总价值;
        int[][] dp = new int[values.length + 1][capacity + 1];
        // dp 初始化的值默认是0,Java中数组默认初始值即为0
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++){
                if (weights[i - 1] > j) { // 如果本次挑选的物品重量 > 承重, 则不装入该物品
                    dp[i][j] = dp[i - 1][j];
                } else { // 本次挑选的物品重量 <= 承重, 可以选择装入
                    // 比较【装】与【不装】分别获得的最大总价值来选择
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[values.length][capacity];
    }
}
