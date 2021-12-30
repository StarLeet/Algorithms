package _03_贪心._00_01背包问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Backpack
 * @Description  背包类
 * @Author StarLee
 * @Date 2021/12/29
 */

public class Backpack {
    /**
     * 以一个属性为主导实现贪心策略
     * @param title 显示标题
     * @param cmp 比较器决定主导属性, [价值、重量、价值密度]
     */
    static void select(String title, Comparator<Goods> cmp) {
        // 模拟题意的物品
        Goods[] goods = new Goods[] {
                new Goods(35, 10), new Goods(30, 40),
                new Goods(60, 30), new Goods(50, 50),
                new Goods(40, 35), new Goods(10, 40),
                new Goods(25, 30)
        };

        // 通过比较器, 按某个主导属性进行排序
        Arrays.sort(goods, cmp);

        // 以某个属性为主导, 实现贪心策略
        int capacity = 150, weight = 0, value = 0;
        List<Goods> selectedGoods = new LinkedList<>(); // 选择的物品集合
        for (int i = 0; i < goods.length && weight < capacity; i++) {
            int newWeight = weight + goods[i].weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += goods[i].value;
                selectedGoods.add(goods[i]);
            }
        }
        printSelectedGoods(title,selectedGoods,value);
    }

    private static void printSelectedGoods(String title,List<Goods> selectedGoods,int value){
        System.out.println("-----------------------------");
        System.out.println("【" + title + "】");
        System.out.println("总价值: " + value);
        for (Goods article : selectedGoods) {
            System.out.println(article);
        }
    }
}
