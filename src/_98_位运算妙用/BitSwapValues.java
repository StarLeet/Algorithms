package _98_位运算妙用;

import _0_Tools.CountTimes;

/**
 * @ClassName BitChangeValues
 * @Description  位运算实现值交换。经测试比临时变量慢,不建议使用
 * @Author StarLee
 * @Date 2022/5/1
 */

public class BitSwapValues {
    /**  原理：
     *     a      0011 1010
     *     b      1010 0111
     *    a^b     1001 1101
     *  b^(a^b)   0011 1010   其实就是a
     */
    public void swap(int a, int b){
        System.out.println("prev:\n" + "a is " + a + ", b is " + b);
        a ^= b;  // a = a ^ b
        b ^= a;  // b = b ^ (a ^ b)
        a ^= b;  // a = (a ^ b) ^ (b ^ (a ^ b))
        System.out.println("after:\n" + "a is " + a + ", b is " + b);
    }

    public static void main(String[] args) {
        new BitSwapValues().swap(5000,1000);
    }
}
