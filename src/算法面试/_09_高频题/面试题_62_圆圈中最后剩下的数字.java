package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
/**
 * @ClassName 面试题_62_圆圈中最后剩下的数字
 * @Description  类似于约瑟夫环,但是不能用循环链表解决
 * @Author StarLee
 * @Date 2022/1/19
 */

public class 面试题_62_圆圈中最后剩下的数字 {
    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字
     * （删除后从下一个数字开始计数）求出这个圆圈里剩下的最后一个数字
     */
    public int lastRemaining(int n, int m) {
        return (n == 1) ? 0 : (lastRemaining(n - 1, m) + m) % n;
    }

    public int lastRemaining1(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) { // i是数据规模，代表有多少个数字（有多少个人）
            res = (res + m) % i;
        }
        return res;
    }
}
