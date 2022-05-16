package _99_代码随想录._03_哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _438_找到字符串中所有字母异位词
 * @Description
 * @Author StarLee
 * @Date 2022/4/17
 */

public class _438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) return result;
        char[] pChars = new char[26];
        char[] sChars = new char[26];
        // 初始化列表
        for (int i = 0; i < p.length(); i++) {
            pChars[p.charAt(i) - 'a']++;
            sChars[s.charAt(i) - 'a']++;
        }
        // 左闭右开
        int left = 0, right = p.length();
        // 滑动窗口
        while (right <= s.length()){
            if (Arrays.equals(pChars,sChars)) result.add(left);
            sChars[s.charAt(left++) - 'a']--;
            if (right == s.length()) break;
            sChars[s.charAt(right) - 'a']++;
            right++;
        }
        return result;
    }
}
