package _99_代码随想录._04_字符串;

import java.lang.annotation.ElementType;
import java.util.Arrays;

/**
 * @ClassName _3_无重复字符的最长子串
 * @Description
 * @Author StarLee
 * @Date 2022/4/20
 */

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // abcabbb
        int[] prevIndexes = new int[1 << 7];
        int max = Integer.MIN_VALUE;
        // -1说明该字符还没出现过
        Arrays.fill(prevIndexes,-1);
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // 取出该字符前一次出现的位置
            int prevIndex = prevIndexes[s.charAt(right)];
            // 在窗口内
            if (prevIndex >= left){
                max = Math.max(max,(right - left));
                left = prevIndex + 1;
            }
            // 不在窗口内
            prevIndexes[s.charAt(right)] = right;
        }
        // 更新最后一次
        return Math.max(max,(s.length() - left));
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串 v = new _3_无重复字符的最长子串();
        v.lengthOfLongestSubstring("abcabbb");
    }
}
