package 算法面试._03_栈操作;
// https://leetcode-cn.com/problems/daily-temperatures/

import java.util.Stack;

/**
 * @ClassName _739_每日温度
 * @Description
 * @Author StarLee
 * @Date 2022/1/10
 */

public class _739_每日温度 {
    /**
     * 请根据每日气温列表temperatures，请计算在每一天需要等几天才会有更高的温度
     * 如果气温在这之后都不会升高，请在该位置用0来代替
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     *
     * 思路：同栈求第一个左右大于自己的元素索引一样 (_654_最大二叉树)
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return null;
        int[] afterDay = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int curIndex = stack.pop();
                afterDay[curIndex] = i - curIndex;
            }
            stack.push(i);
        }
        return afterDay;
    }

    /**
     * 倒推法实现
     * temperatures = [73,74,75,71,69,72,76,73]
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return null;
        int[] afterDay = new int[temperatures.length];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true){
                // 今天比明天(或者明天升温后)温度低
                if (temperatures[i] < temperatures[j]) {
                    afterDay[i] = j - i;
                    break;
                } else if (afterDay[j] == 0) {  // 发现明天(或者升温后的最高温低于自己)不升温了
                    afterDay[i] = 0;
                    break;
                }
                // 今天等于或者高于明天温度,需要随着明天的升温情况直到找到大于自己的
                j = j + afterDay[j];
            }
        }
        return afterDay;
    }
}
