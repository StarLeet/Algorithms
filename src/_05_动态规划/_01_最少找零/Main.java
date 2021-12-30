package _05_动态规划._01_最少找零;

/**
 * @ClassName Main
 * @Description
 * @Author StarLee
 * @Date 2021/12/29
 */

public class Main {
    public static void main(String[] args) {
//		System.out.println(CoinChange.coins1(41));
//		System.out.println(CoinChange.coins2(41));
//		System.out.println(CoinChange.coins3(41));
//		System.out.println(CoinChange.coins4(41));
        System.out.println(CoinChange.coins5(41, new int[]{2, 5, 20, 25}));

        // dp(41) = 凑够41需要的最少硬币数量 = min { dp{40}, dp{36}, dp{21}, dp{16} } + 1
        // dp(41 - 1) = dp(40) = 凑够40需要的最少硬币数量
        // dp(41 - 5) = dp(36) = 凑够36需要的最少硬币数量
        // dp(41 - 20) = dp(21) = 凑够21需要的最少硬币数量
        // dp(41 - 25) = dp(16) = 凑够16需要的最少硬币数量
        // min { dp{40}, dp{36}, dp{21}, dp{16} } + 1
    }
}
