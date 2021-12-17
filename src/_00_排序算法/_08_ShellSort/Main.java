package _00_排序算法._08_ShellSort;

import _0_Tools.Asserts;
import _0_Tools.Integers;

/**
 * @ClassName Main
 * @Description
 * @Author StarLee
 * @Date 2021/12/15
 */

public class Main {
    public static void main(String[] args) {
        Integer[] array = Integers.random(30,1,10_00);
        ShellSort shellSort = new ShellSort(array);
        shellSort.sort();
        for (Integer integer:
             array) {
            System.out.print(integer + " ");
        }
    }
}
