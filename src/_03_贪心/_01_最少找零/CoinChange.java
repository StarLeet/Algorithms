package _03_贪心._01_最少找零;

import java.util.Arrays;

/**
 * @ClassName CoinChange
 * @Description  最小找零问题
 * @Author StarLee
 * @Date 2021/12/29
 */

public class CoinChange {
    static void coinChange3(Integer[] faces, int money) {
        Arrays.sort(faces);
        int coins = 0, index = faces.length - 1;
        while (index >= 0) {
            while (money >= faces[index]){
                System.out.print(faces[index] + " ");
                money -= faces[index];
                coins++;
            }
            index--;
        }
        System.out.println("使用了" + coins + "个硬币。");
    }

    /**
     *  @MethodName coinChange2
     *  @Description  比之coinChange1()区别只在于Arrays比较器
     */
    static void coinChange2(Integer[] faces, int money) {
        // 排序, 传入了比较器, 所以是从大到小排序
        Arrays.sort(faces, (Integer f1, Integer f2) -> f2 - f1); //应用lambda表达式

        int coins = 0, i = 0;
        // 贪心策略, 选择面值最大的硬币, 由于顺序大->小, 从前往后放
        while (i < faces.length) {
            if (money < faces[i]) {
                i++;
                continue;
            }
			System.out.print(faces[i] + " ");
            money -= faces[i];
            coins++;
        }
		System.out.println("使用了" + coins + "个硬币。");
    }

    /**
     *  @MethodName coinChange1
     *  @Description  贪心策略得到局部的最优解,未必就是最少的
     *  @Param [faces  钞票面额数组, money 需要找零金额]
     */
    static void coinChange1(Integer[] faces, int money) {
        Arrays.sort(faces); // 排序, 默认从小到大

        int coins = 0;
        // 贪心策略, 选择面值最大的硬币, 由于顺序小->大, 从后往前放
        for (int i = faces.length - 1; i >= 0; i--) {
            // 如果找零金额大于等于当前面额,则选择当前面额,否则选择更小面额
            while(money >= faces[i]){
                System.out.print(faces[i] + " ");
                money -= faces[i];
                coins++;
            }
        }
        System.out.println("使用了" + coins + "个硬币。");
    }
}
