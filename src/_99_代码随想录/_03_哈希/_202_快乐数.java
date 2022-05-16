package _99_代码随想录._03_哈希;

/**
 * @ClassName _202_快乐数
 * @Description
 * @Author StarLee
 * @Date 2022/4/18
 */

public class _202_快乐数 {
    public boolean isHappy(int n) {
        int slow = n, fast = squareAndAdd(slow);
        // 如果出现循环,slow最终一定会和fast相遇,参考链表判断有环
        while (slow != fast){
            // 到1不用判断,因为1进入函数只能返回1
            slow = squareAndAdd(slow);
            fast = squareAndAdd(fast);
            fast = squareAndAdd(fast);
        }
        return fast == 1;
    }

    private int squareAndAdd(int n){
        int sum = 0;
        while (n > 0){
            sum += Math.pow(n % 10,2);
            n /= 10;
        }
        return sum;
    }
}
