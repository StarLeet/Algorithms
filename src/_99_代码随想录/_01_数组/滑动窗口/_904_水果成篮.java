package _99_代码随想录._01_数组.滑动窗口;

import _04_分治._01_最大连续子序列.MaxSubArray;

/**
 * @ClassName _904_水果成篮
 * @Description  滑动窗口
 * @Author StarLee
 * @Date 2022/4/14
 */

public class _904_水果成篮 {
    public int totalFruit(int[] fruits) {
        if (fruits == null) return 0;
        if (fruits.length <= 2) return fruits.length;
        int begin = 0;
        int[] kinds = {-1,-1};
        int result = Integer.MIN_VALUE;
        int curNum = 0;
        // [1,0,0,0,1,0,4,0,4]
        for (int end = 1; end < fruits.length; end++) {
            if (fruits[end] == kinds[0] || fruits[end] == kinds[1]){
                curNum++;
            }else {  // 不符合,条件移动窗口左侧
                result = Math.max(curNum, result);
                begin = end - 1;
                while (begin > 0 && fruits[begin] == fruits[begin - 1]) begin--;
                curNum = end - begin + 1;
                // 更新窗口元素
                kinds[0] = fruits[begin];
                kinds[1] = fruits[end];
            }
        }
        // 防止curNum++直接跳出for被忽略
        return Math.max(result,curNum);
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1,0,4,0,4};
        _904_水果成篮 v = new _904_水果成篮();
        v.totalFruit(arr);
    }
}
