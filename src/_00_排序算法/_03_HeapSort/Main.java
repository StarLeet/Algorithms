package _00_排序算法._03_HeapSort;

import _0_Tools.Asserts;
import _0_Tools.Integers;

/**
 * @ClassName Main
 * @Description  演示堆排序
 * @Author StarLee
 * @Date 2021/12/8
 */

public class Main {
    public static void main(String[] args) {
        test();
    }

    static void test(){
        Integer[] array = Integers.random(25,1,500);
        HeapSort.sort(array);
        Asserts.test(Integers.isAscOrder(array));
        for (Integer integer :
                array) {
            System.out.print(integer + " ");
        }
    }
}
