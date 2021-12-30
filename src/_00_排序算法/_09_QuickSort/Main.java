package _00_排序算法._09_QuickSort;

import _0_Tools.Asserts;
import _0_Tools.Integers;

/**
 * @ClassName Main
 * @Description
 * @Author StarLee
 * @Date 2021/12/19
 */

public class Main {
    public static void main(String[] args) {
        Integer[] array = Integers.random(500,1,5000);
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();
        Asserts.test(Integers.isAscOrder(array));
    }
}
