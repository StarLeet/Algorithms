package _06_字符串匹配;

/**
 * @ClassName BruteForce02
 * @Description
 * @Author StarLee
 * @Date 2022/1/1
 */
@SuppressWarnings("all")
public class BruteForce02 {
    /**
     * 蛮力匹配2   易于理解但是不能过渡KMP算法
     */
    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (tlen == 0 || plen == 0 || tlen < plen) return -1;

        int tiMax = tlen - plen;
        for (int ti = 0; ti <= tiMax; ti++) {
            int pi = 0;
            for (; pi < plen; pi++) {
                if (textChars[ti + pi] != patternChars[pi]) break;
            }
            if (pi == plen) return ti;
        }
        return -1;
    }
}
