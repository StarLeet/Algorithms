package _03_贪心._01_最少找零;

/**
 * @ClassName Main
 * @Description  贪心策略只是局部最优,总体上看未必是最优的
 * @Author StarLee
 * @Date 2021/12/29
 */

public class Main {
    public static void main(String[] args) {
		CoinChange.coinChange1(new Integer[] {25, 20, 5, 1}, 41);
		CoinChange.coinChange2(new Integer[] {25, 20, 5, 1}, 41);
        CoinChange.coinChange3(new Integer[] {25, 20, 5, 1}, 41);
    }
}
