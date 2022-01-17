package 算法面试._06_字符串操作;
// https://leetcode-cn.com/problems/valid-anagram/
/**
 * @ClassName _242_有效的字母异位词
 * @Description
 * @Author StarLee
 * @Date 2022/1/11
 */

public class _242_有效的字母异位词 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若s和 中每个字符出现的次数都相同，则称s 和 t互为字母异位词
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] charArr = s.toCharArray();
        char[] charArr1 = t.toCharArray();
        int[] counts = new int[26];
        for (char c : charArr) {
            int idx = c - 'a';
            counts[idx]++;
        }
        for (char c : charArr1) {
            int idx = c - 'a';
            if (--counts[idx] < 0) return false;
        }
        return true;
    }
}
