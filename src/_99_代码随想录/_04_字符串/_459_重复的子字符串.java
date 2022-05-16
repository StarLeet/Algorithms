package _99_代码随想录._04_字符串;

import java.util.HashMap;

/**
 * @ClassName _459_重复的子字符串
 * @Description
 * @Author StarLee
 * @Date 2022/5/2
 */
public class _459_重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) return false;
        // i为子串长度
        boolean result;
        for (int i = 1; i <= (s.length() >> 1); i++) {
            // 子串长度不为s的因子,说明s不可能由n个子串组成
            if (s.length() % i != 0) continue;
            // 取出子串
            String sub1 = s.substring(0, i);
            // 与尾部比较
            if (!sub1.equals(s.substring(s.length() - i))) continue;
            result = true;
            // 去掉首尾,将中间的部分进行比较
            int end = s.length() - 2 * i;
            for (int j = i; j <= end; j += i) {
                if (!sub1.equals(s.substring(j, j + i))){
                    result = false;
                    break;
                }
            }
            if (result) return true;
        }
        return false;
    }
}
