package _01_递归._01_Fibonacci;

/**
 * @ClassName Fibonacci
 * @Description 斐波那契数列多种方式实现
 * @Author StarLee
 * @Date 2021/12/26
 */
@SuppressWarnings("all")
public class Fibonacci {
    /**
     *  时间复杂度O(2^n)  空间复杂度O(n)
     */
    public static int fib0(int n) {
        if (n <= 2) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    /**
     *  用数组存放计算过的结果，避免重复计算
     *  时间复杂度O(n)  空间复杂度O(n)
     */
    public static int fib1(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[2] = array[1] = 1;
        return fib1(array, n);
    }
    private static int fib1(int[] array, int n) {
        if (array[n] == 0) {
            array[n] = fib1(array, n - 1) + fib1(array, n - 2);
        }
        return array[n];
    }

    /**
     *  改用迭代算法,从"自顶向下"到"自底向上"
     *  时间复杂度O(n)  空间复杂度O(n)
     */
    public static int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[2] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 迭代 + 滚动数组
     * 时间复杂度O(n)  空间复杂度O(1)
     */
    public static int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[1] = array[0] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }

    /**
     * 对fib3的优化,位运算优化取模数组
     */
    public static int fib4(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[1] = array[0] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }

    public static int fib5(int n) {
        if (n <= 2) return 1;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++){
            second = first + second;
            first = second - first;
        }
        return second;
    }

    /**
     * 基于数学递推公式
     * 时间复杂度O(1)  空间复杂度(1)
     */
    public static int fib6(int n) {
        double c = Math.sqrt(5);
        return (int)((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }
}
