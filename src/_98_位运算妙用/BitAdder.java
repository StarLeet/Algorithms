package _98_位运算妙用;

/**
 * @ClassName Test
 * @Description 位运算实现加法
 * @Author StarLee
 * @Date 2022/4/15
 */

public class BitAdder {
    /**
     * ^ 异或                                & 判断有无进位   搭配 << 将进位信息正确进位(向左进位)
     * 1 ^ 1 = 0  (进位1)                    1 & 1 = 1   (1个进位)
     * 0 ^ 0 = 0                            1 & 0 = 0    不进位
     * 1 ^ 0 = 1                            0 & 0 = 0
     * 由此可见,异或发挥加法的作用             由此可见,与运算发挥进位作用
     * 但是没进位
     */
    /**
     *   011
     *   111
     */
    private static int add(int a, int b) {
        int sum = a ^ b;  // 异或起到加法作用
        int carry = (a & b) << 1;  // 与运算判断有无进位信息,以及进位是否有效(溢出)
        while (carry != 0) {   // 非0说明有进位且进位无溢出
            int oldSum = sum;
            // 这两步等价与while上面的两句
            sum = sum ^ carry;  // 加上进位(carry相当于b,作为加数)
            carry = oldSum & (carry << 1);  // 判断是否还有新的进位
        }
        return sum;
    }
}
