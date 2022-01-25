package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/reverse-integer/
/**
 * @ClassName _7_整数反转
 * @Description
 * @Author StarLee
 * @Date 2022/1/22
 */

public class _7_整数反转 {
    /**
     * 给你一个32位的有符号整数x ，返回将x中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围[−2^31,2^31 − 1] ，就返回0
     * 假设环境不允许存储 64 位整数（有符号或无符号）
     * 输入：x = 123
     * 输出：321
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int prevRes = res;
            int mod = x % 10;
            res = prevRes * 10 + mod;
            if ((res - mod) / 10 != prevRes) return 0;
            x /= 10;
        }
        return res;
    }
    // 简化prevRes变量
    public int reverse1(int x) {
        // (321 % 10) * 10 + 32 % 10
        long result = 0;
        while (x != 0){
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE) return 0;
            if (result < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int)result;
    }
}
