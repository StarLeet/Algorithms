package _03_贪心._00_01背包问题;

/**
 * @ClassName Main
 * @Description
 * @Author StarLee
 * @Date 2021/12/29
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        Backpack.select("价值主导", (Goods a1, Goods a2) -> {
            // 价值大的优先
            return a2.value - a1.value;
        });
        Backpack.select("重量主导", (Goods a1, Goods a2) -> {
            // 重量小的优先
            return a1.weight - a2.weight;
        });
        Backpack.select("价值密度主导", (Goods a1, Goods a2) -> {
            // 价值密度大的优先
            return Double.compare(a2.valueDensity, a1.valueDensity);
        });
    }
}
