package _99_代码随想录._01_数组.二分查找;

/**
 * @ClassName _69_x_的平方根
 * @Description  二分查找缩小范围
 * @Author StarLee
 * @Date 2022/4/12
 */

public class _69_x_的平方根 {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int begin = 0, end = x;
        // 比如4,最终范围会被压缩在[2,3)
        while (end != (begin + 1)){
            int mid = (begin + end) >> 1;
            // 不采用 mid * mid <= x 是因为容易溢出
            if (x / mid >= mid){  // mid * mid <= x  为真说明begin应该取更大
                begin = mid;
            }else {
                end = mid;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        _69_x_的平方根 v = new _69_x_的平方根();
        System.out.println(v.mySqrt(16));
    }
}
