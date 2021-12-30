package _03_贪心._00_01背包问题;

/**
 * @ClassName Goods
 * @Description  货品类
 * @Author StarLee
 * @Date 2021/12/29
 */

public class Goods {
    int weight; // 重量
    int value;  // 价值
    double valueDensity; // 价值密度

    public Goods(int weight, int value) {
        this.weight = weight;
        this.value = value;
        valueDensity = value * 1.0 / weight;
    }
    @Override
    public String toString() {
        return "Article [weight=" + weight + ", value=" + value + ", ValueDensity=" + valueDensity + "]";
    }
}
