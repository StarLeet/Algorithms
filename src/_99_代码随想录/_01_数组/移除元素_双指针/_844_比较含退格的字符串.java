package _99_代码随想录._01_数组.移除元素_双指针;

/**
 * @ClassName _844_比较含退格的字符串
 * @Description
 * @Author StarLee
 * @Date 2022/4/13
 */

public class _844_比较含退格的字符串 {
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sLen = backSpace(sChars);
        int tLen = backSpace(tChars);
        if (sLen != tLen) return false;
        for (int i = 0; i < tLen; i++) {
            if (sChars[i] != tChars[i]) return false;
        }
        return true;
    }

    private int backSpace(char[] chars){
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != '#'){
                chars[slow++] = chars[fast];
            }else {
                slow = slow == 0 ? 0 : slow - 1;
            }
        }
        return slow;
    }
}
