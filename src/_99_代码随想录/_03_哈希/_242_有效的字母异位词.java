package _99_代码随想录._03_哈希;

import _0_Tools.CountTimes;

/**
 * @ClassName _242_有效的字母异位词
 * @Description
 * @Author StarLee
 * @Date 2022/4/17
 */

public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] charArr = s.toCharArray();
        char[] charArr1 = t.toCharArray();
        int[] counts = new int[26];
        for (char c : charArr) {
            counts[c - 'a']++;
        }
        for (char c : charArr1) {
            if (--counts[c - 'a'] < 0) return false;
        }
        return true;
    }
}
