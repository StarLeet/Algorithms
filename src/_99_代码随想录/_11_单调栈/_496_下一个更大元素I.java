package _99_代码随想录._11_单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName _496_下一个更大元素I
 * @Description  具体注释 看每日温度
 * @Author StarLee
 * @Date 2022/4/17
 */

public class _496_下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        int[] result = new int[nums1.length];
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                map.put(nums2[stack.pop()],nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            //  getOrDefault(key,defaultValue)  key不存在时赋的值
            result[i] = map.getOrDefault(nums1[i],-1);
        }
        return result;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        int[] result = new int[nums1.length];
        // 为了方便将nums1的值映射到nums2去,快速获取答案
        HashMap<Integer, Integer> map = new HashMap<>();
        // 倒推法
        for (int i = nums2.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true){
                if (nums2[i] < nums2[j]){
                    map.put(nums2[i],j);
                    break;
                }else if (!map.containsKey(nums2[j])){
                    break;
                }
                j = map.get(nums2[j]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.containsKey(nums1[i]) ? nums2[map.get(nums1[i])] : -1;
        }
        return result;
    }
}
