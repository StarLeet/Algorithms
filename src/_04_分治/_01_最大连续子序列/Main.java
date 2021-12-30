package _04_分治._01_最大连续子序列;

/**
 * @ClassName Main
 * @Description
 * @Author StarLee
 * @Date 2021/12/29
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,-1,-4,-3,2,5};
        System.out.println("最大连续子序列为:" + MaxSubArray.maxSubArray(nums));
    }
}
