package _99_代码随想录._11_单调栈;

import java.util.Stack;

/**
 * @ClassName _739_每日温度
 * @Description
 * @Author StarLee
 * @Date 2022/4/17
 */

public class _739_每日温度 {
    // 多少天后有更高的温度？
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        // 使用单调栈
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];  // 存索引
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            // 如果大于弹出前面的
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    // 倒推法：根据后一天的升温情况来推自己的升温情况
    public int[] dailyTemperatures1(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        int[] result = new int[temperatures.length];
        // 最后一天肯定不能再升温了,所以为0
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int future = i + 1; // 起始值取明天
            // 因为大于等于明天需要持续找更大值,所以在这里加上循环
            while (true){
                if (temperatures[i] < temperatures[future]){
                    result[i] = future - i;
                    break;
                }else if (result[future] == 0){  // 未来不可能继续升温了
                    result[i] = 0;
                    break;
                }
                //  当前时间段还未发现大于今天温度的,需要继续往后找
                future += result[future];
            }
        }
        return result;
    }
}
