package _99_代码随想录._04_字符串;

/**
 * @ClassName _344_反转字符串
 * @Description
 * @Author StarLee
 * @Date 2022/5/1
 */

public class _344_反转字符串 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int right = s.length - 1;
        for (int left = 0; left < right; left++,right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
