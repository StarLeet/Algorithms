package 算法面试._09_高频题;
//  https://leetcode-cn.com/problems/powx-n/
/**
 * @ClassName _50_Pow
 * @Description
 * @Author StarLee
 * @Date 2022/1/19
 */

public class _50_Pow {
    /**
     * 实现pow(x, n) ，即计算x的n次幂函数（即，xn ）
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     */
    // 分治(本质递归)
    // T(n) = T(n/2) + O(1) = O(logn)
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        // -1要单独判断,因为 n >> 1,n为负数,最终结果永远是-1
        if (n == -1) return 1 / x;
        // 为奇数时 3^11 = 3^5 * 3^5 * 3  为负奇数时 3^-11 = 3^-5 * 3^-5 * 3^-1
        // 为偶数时 3^10 = 3^5 * 3^5      为偶数时 3^-10 = 3^-5 * 3^-5
        double result = myPow(x,n >> 1);
        result *= result;
        // (n & 1) == 0) 说明为偶数
        // -11 >> 1 == -6  -6*-6 == -12  3^-12 * 3 = 3^-11 正好兼容
        return ((n & 1) == 0) ? result : result * x;
    }
    // 迭代
    public double myPow1(double x, int n){
        // 因为最小值为2^-31 最大值为2^31 - 1 为了包容最小值的绝对值采用long
        // 将负数幂转换为正数计算
        long y = (n < 0) ? -((long) n) : n;
        double result = 1.0;
        // 任何数都可以被二进制表示
        // 10 = 1001
        while (y > 0){
            // 为1表示幂中存在这个要素,应该包含
            if ((y & 1) == 1){
                result *= x;
            }
            x *= x;
            y >>= 1;
        }
        return (n < 0) ? (1 / result) : result;
    }

    /**
     * 对上题的拓展,如何快速求出  x^y Mod z?
     * 假设 x 与 y 可以是极大的数
     * 提示：有一个公式符合分治思想
     * 2^100 % 6  = (2^50 * 2^50) % 6 = ((2^50 % 6) * (2^50 % 6)) % 6
     * 2^101 % 6 = (2^50 * 2^50 * 2) % 6 = ((2^50 % 6) * (2^50 % 6) * (2 % 6)) % 6
     */
    // 迭代法
    public static int powMod1(int x, int y, int z) {
        if (y < 0 || z == 0) return 0;
        int res = 1 % z;
        x %= z;
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进制位是1，就累乘上x
                res = (res * x) % z;
            }
            x = (x * x) % z;
            // 舍弃掉最后一个二进制位
            y >>= 1;
        }
        return res;
    }


    // 分治法
    public static int powMod(int x, int y, int z) {
        if (y < 0 || z == 0) return 0;
        if (y == 0) return 1 % z;
        int half = powMod(x, y >> 1, z);
        half *= half;
        if ((y & 1) == 0) { // 偶数
            return half % z;
        } else { // 奇数
            return (half * (x % z)) % z;
        }
    }
}
