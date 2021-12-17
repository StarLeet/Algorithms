package _00_排序算法._04_InsertionSort;

import _0_Tools.Asserts;
import _0_Tools.CountTimes;
import _0_Tools.Integers;

/**
 * @ClassName Main
 * @Description  展示插入算法
 * @Author StarLee
 * @Date 2021/12/10
 */

public class Main {
    public static void main(String[] args) {
        Integer[] array = Integers.random(15_000,1,20_000);
        Integer[] array1 = Integers.copy(array);
        CountTimes.test("sort_Binary",() -> {
            new InsertionSort(array).sort_Binary();
        });
        Asserts.test(Integers.isAscOrder(array));
    }
}
