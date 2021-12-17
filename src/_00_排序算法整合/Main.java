package _00_排序算法整合;

import _00_排序算法整合._01_CompareSort.*;
import _0_Tools.Asserts;
import _0_Tools.Integers;

import java.util.Arrays;

/**
 * @ClassName Main
 * @Description
 * @Author StarLee
 * @Date 2021/12/8
 */
@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        Integer[] array = Integers.random(15_000,1,20_000);
        testSorts(array,
                new BubbleSort<>(),
                new BubbleSort1<>(),
                new SelectionSort<>(),
                new HeapSort<>(),
                new InsertionSort<>(),
                new InsertionSort_Binary<>(),
                new MergeSort<>()
                );
    }

    static void testSorts(Integer[] array, AbstractSort<Integer>... sorts) {
        for (AbstractSort<Integer> sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (AbstractSort<Integer> sort : sorts) {
            System.out.println(sort);
        }
    }
}
