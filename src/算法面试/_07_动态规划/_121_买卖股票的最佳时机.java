package 算法面试._07_动态规划;
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
/**
 * @ClassName _121_买卖股票的最佳时机
 * @Description
 * @Author StarLee
 * @Date 2022/1/14
 */
@SuppressWarnings("all")
public class _121_买卖股票的最佳时机 {
    /**
     * 给定一个数组prices，它的第i个元素prices[i]表示一支给定股票第i天的价格
     * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票
     * 设计一个算法来计算你所能获取的最大利润
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
     * 输入：[2,9,1,5,3,6,4]
     * 输出：5
     * 解释：在第2天（股票价格 = 1）的时候买入，在第5天（股票价格 = 6）的时候卖出，最大利润= 6-1 =5
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        /* 要想得到最大收益,则要知道每天的最大收益是多少,然后从中取出最大值 */
        /* 第i的最大收益,应该是【第i天的价格-i天之前的最低价格】 */
        int max = 0;  // 存储最大利润
        int minPrice = prices[0];  // 最小价格
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]){ // 史上新低价格,不可能再获得收益,所以只需更新最低价即可
                minPrice = prices[i];
            }else{  // 可以获得收益,但不一定是最大,所以用max进行筛选
                max = Math.max(max,prices[i] - minPrice);
            }
        }
        return max;
    }
}
