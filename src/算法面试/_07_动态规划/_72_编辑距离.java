package 算法面试._07_动态规划;
// https://leetcode-cn.com/problems/edit-distance/
/**
 * @ClassName _72_编辑距离
 * @Description
 * @Author StarLee
 * @Date 2022/1/14
 */

public class _72_编辑距离 {
    /**
     * 给你两个单词word1和word2，请你计算出将word1转换成word2 所使用的最少操作数
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符  删除一个字符  替换一个字符
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];  // 要将二者的空串也算进去,所以都需要+1
        /* dp[i][j]表示chars1[0,i)转成chars2[0,j)所需的最少操作数
         * chars1[0,i)为word1前i个字符  chars2[0,j)为word1前j个字符
         * 比如 "mice"与"arise",dp[2][3]表示"mi"转成"ari"的最少操作数
         */
        // 临界情况,word1或者word2为空串时,对dp数组进行单独处理
        for (int i = 0; i < chars2.length + 1; i++) {
            dp[0][i] = i;  // word1为空串的情况下,需要一个个添加
        }
        for (int i = 0; i < chars1.length + 1; i++) {
            dp[i][0] = i;  // word2为空串的情况下,需要一个个删除
        }
        // 一般情况,word1、word2都不为空串时
        for (int i = 1; i < chars1.length + 1; i++) {
            for (int j = 1; j < chars2.length + 1; j++) {
                // chars1[0,i)删除最后一位得到chars1[0,i-1),chars1[0,i-1)——>chars2[0,j)所需的最小步骤
                int top = dp[i - 1][j] + 1;
                // chars1[0,i)——>chars2[0,j-1)所需的最小步骤,在chars2[0,j-1)尾部添加一个chars[j-1]
                int left = dp[i][j - 1] + 1;
                // 如果chars1[i - 1] == chars2[j - 1]即最后一个字符相等
                // 就只需关注chars1[0,i-1)——>chars2[0,j-1),的最小步骤
                int leftTop = dp[i - 1][j - 1];
                // 如果不等,最后一个字符多使用一次替换操作即可
                if (chars1[i - 1] != chars2[j - 1]) leftTop++;
                // 三种计算方式的最小值即为dp的值
                dp[i][j] = Math.min(leftTop,Math.min(top,left));
            }
        }
        return dp[chars1.length][chars2.length];
    }
    // dp优化至一维数组
    public int minDistance1(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        if (chars1.length == 0 || chars2.length == 0) return Math.max(chars1.length, chars2.length);
        int[] dp = new int[chars2.length + 1];
        // 初始化第一行的dp
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        /*       a b c
        *      0 1 2 3
        *    a 1 0 1 2
        *    c 2 1 1 1
        */
        for (int i = 1; i < chars1.length + 1; i++) {
            // 每行开始对left、leftTop进行初始化
            int left = i;
            int leftTop = i - 1;
            for (int j = 1; j < chars2.length + 1; j++) {
                int top = dp[j] + 1;
                if (chars1[i - 1] != chars2[j - 1]) leftTop++;
                // 当前的dp[j]将成为下一元素的left
                left = Math.min(leftTop,Math.min(top,left + 1));
                // 在dp[j]变动之前先记录旧值,否则被新值覆盖j+1的计算会被影响
                leftTop = dp[j];
                // 新值覆盖旧值, 滚动数组
                dp[j] = left;
            }
        }
        return dp[chars2.length];
    }
}
