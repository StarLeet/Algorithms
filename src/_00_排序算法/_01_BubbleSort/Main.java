package _00_排序算法._01_BubbleSort;

import _0_Tools.Asserts;
import _0_Tools.CountTimes;
import _0_Tools.Integers;

/**
 * @ClassName Main
 * @Description  测试冒泡排序算法
 * @Author StarLee
 * @Date 2021/12/8
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        test();
    }

    /**
     *  @MethodName test
     *  @Description  尾部数据出现局部有序的情况下,未优化冒泡与优化冒泡的比较
     *  @Param []
     *  @return void
     */
    static void test(){
        Integer[] array = Integers.tailAscOrder(1,25_000,1000);
        Integer[] array1 = Integers.copy(array);
        CountTimes.test("bubbleSort",() -> {
            BubbleSort.sort(array);
        });
        CountTimes.test("bubbleSort_",() -> {
            BubbleSort.sortCheckSorted(array1);
        });
    }
}
