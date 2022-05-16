package _99_代码随想录._04_字符串;

/**
 * @ClassName _28_实现strStr
 * @Description
 * @Author StarLee
 * @Date 2022/5/2
 */
public class _28_实现strStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) return 0;
        if (needle == null || needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        boolean hasResult;
        int result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) continue;
            // 剩余的长度不够了
            if (haystack.length() - i < needle.length()) break;
            // 首字母匹配,假设能够匹配上
            result = i;
            hasResult = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    // 发现匹配失败,重置条件,进入下一次匹配
                    result = -1;
                    hasResult = false;
                    break;
                }
            }
            if (hasResult) break;
        }
        return result;
    }
}
