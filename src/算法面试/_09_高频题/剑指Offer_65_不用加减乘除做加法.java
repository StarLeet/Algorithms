package 算法面试._09_高频题;

/**
 * @ClassName 剑指Offer_65_不用加减乘除做加法
 * @Description
 * @Author StarLee
 * @Date 2022/4/15
 */

public class 剑指Offer_65_不用加减乘除做加法 {
    // C++ 解法需要carry = (unsigned int)(a & b) << 1
    public int add(int a, int b) {
        int sum = a ^ b;    // 做加法
        int carry = (a & b) << 1;  // 判断有无进位,且进位是否有效
        while (carry != 0){
            int oldSum = sum;
            sum = sum ^ carry; // 加上进位
            carry = (oldSum & carry) << 1;  // 看下加上后,有无新的有效进位
        }
        return sum;
    }
}
