package _00_排序算法._05_BinarySearch;

import _0_Tools.Asserts;
import _0_Tools.Integers;

/**
 * @ClassName Main
 * @Description 二分查找测试
 * @Author StarLee
 * @Date 2021/12/10
 */

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1 ,3 ,5,7 ,6 , 4};
        Asserts.test(new BinarySearch(array).indexOf(1) == 0);
        Asserts.test(new BinarySearch(array).indexOf(5) == 2);
        Asserts.test(new BinarySearch(array).indexOf(8) == -1);
    }
}
