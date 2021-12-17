package _00_排序算法._02_SelectionSort;

import _0_Tools.Asserts;
import _0_Tools.Integers;

/**
 * @ClassName Main
 * @Description  测试选择排序
 * @Author StarLee
 * @Date 2021/12/8
 */

public class Main {
    public static void main(String[] args) {
        test();
    }

    /**
     *  测试选择排序的功能
     * */
    static void test(){
        Integer[] array = Integers.random(100,2,5000);
        SelectionSort.sort(array);
        Asserts.test(Integers.isAscOrder(array));
    }
}
