package 算法面试._06_字符串操作;
// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

import java.util.Arrays;

/**
 * @ClassName _3_无重复字符的最长子串
 * @Description
 * @Author StarLee
 * @Date 2022/1/14
 */

public class _3_无重复字符的最长子串 {
    /***
     * 给定一个字符串s，请你找出其中不含有重复字符的 最长子串 的长度
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] sChar = s.toCharArray();
        if (sChar.length <= 1) return sChar.length;
        int[] preView = new int[128];  // 默认使用ASCII中的字符作为测试字串,记录字符上一次出现的索引
        Arrays.fill(preView, -1); // 初始化索引数组,没出现过为-1
        //记录前一个元素结尾的最长无重复字符串的第一个元素索引
        int leftIndex = 0;  // abcabcbb  当i=2时,leftIndex为0
        int max = -1;  // 记录最大无重复字符串的长度
        for (int i = 0; i < sChar.length; i++) {
            int preIndex = preView[sChar[i]]; //当i为0时,preIndex为-1,leftIndex仍旧为0
            if (preIndex >= leftIndex){
                leftIndex = preIndex + 1; // abcabcbb  ...cabc 取第一个c后的a索引
            }
            preView[sChar[i]] = i; // 将当前字符的下标更新入preView
            max = Math.max(max,i - leftIndex + 1);
        }
        return max;
    }
}
