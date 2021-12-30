package _01_递归._02_ClimbStairs;

/**
 * @ClassName ClimbStairs
 * @Description  爬楼梯(与斐波那契数列是一样的就是临界条件有区别)
 * @Author StarLee
 * @Date 2021/12/26
 */

public class ClimbStairs {
    public static int climb1(int n){
        if (n <= 2) return n;  //1阶楼梯1种走法,2阶楼梯两种走法
        return climb1(n - 1) + climb1(n - 2);
    }

    public static int climb2(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for(int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
