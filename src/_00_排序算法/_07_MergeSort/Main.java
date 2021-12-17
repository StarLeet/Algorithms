package _00_排序算法._07_MergeSort;

import _0_Tools.Asserts;
import _0_Tools.Integers;

/**
 * @ClassName Main
 * @Description  归并排序的测试
 * @Author StarLee
 * @Date 2021/12/11
 */

public class Main {
    public static void main(String[] args) {
        Integer[] array = Integers.random(30,1,300);
        new MergeSort(array).sort();
        Asserts.test(Integers.isAscOrder(array));
        for (Integer integer :
                array) {
            System.out.print(integer + " ");
        }
    }
}
