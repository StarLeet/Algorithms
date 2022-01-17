package 算法面试._06_字符串操作;
// https://leetcode-cn.com/problems/reverse-words-in-a-string/

/**
 * @ClassName _151_翻转字符串里的单词
 * @Description
 * @Author StarLee
 * @Date 2022/1/11
 */

public class _151_翻转字符串里的单词 {
    /**
     * 给你一个字符串s，逐个翻转字符串中的所有单词 。
     * 单词是由非空格字符组成的字符串。s中使用至少一个空格将字符串中的 单词 分隔开。
     * 请你返回一个翻转s中单词顺序并用单个空格相连的字符串
     *
     * 说明：
     * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
     * 翻转后单词间应当仅用一个空格分隔。
     * 翻转后的字符串中不应包含额外的空格
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        char[] sChars = s.toCharArray();
        // 去除多余空格
        boolean validSpace = false; // 是否是必要的空格
        int cur = 0;
        for (int i = 0; i < sChars.length; i++) {
            // [ asd sda  csa! ]
            if (sChars[i] == ' '){
                if (!validSpace){
                    continue;
                }
                validSpace = false;
            }else {
                validSpace = true;
            }
            sChars[cur++] = sChars[i];
        }
        int len = validSpace ? cur : cur - 1;
        if (len <= 0) return "";
        // 反转整个字符串 [asd sda csa!]——>[!asc ads dsa]
        reverseString(sChars,0,len);
//        System.out.println(new String(sChars,0,len));   // 调试代码
        // 反转每个单词  [!asc ads dsa]——>[csa! sda asd]
        cur = -1;
        for (int i = 0; i < len; i++) {
            if (sChars[i] == ' '){
                reverseString(sChars,cur + 1,i);
                cur = i;
            }
        }
        reverseString(sChars,cur + 1,len);
        System.out.println(new String(sChars,0,len)); // 调试代码
        return new String(sChars,0,len);
    }

    public void reverseString(char[] chars,int left,int right){
        for (int l = left,r = right - 1; l < r; l++,r--) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
        }
    }

    public static void main(String[] args) {
        String a = " asd sda  csa! ";
        String b = " M6eAL   RxnYFfCA kibo     oEw    z36tp     kufsBMitF K  sMG A 1 H io";
        _151_翻转字符串里的单词 demo = new _151_翻转字符串里的单词();
        demo.reverseWords(a);
    }
}
