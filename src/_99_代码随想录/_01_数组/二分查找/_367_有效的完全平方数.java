package _99_代码随想录._01_数组.二分查找;

/**
 * @ClassName _367_有效的完全平方数
 * @Description
 * @Author StarLee
 * @Date 2022/4/12
 */

public class _367_有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int begin = 0, end = num;
        // 1 2 3 4 5
        while (end - begin > 1){
            int mid = (begin + end) >> 1;
            if (num / mid >= mid){
                begin = mid;
            }else {
                end = mid;
            }
        }
        return (begin * begin) == num;
    }
}
