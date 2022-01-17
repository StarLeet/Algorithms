package 算法面试._06_字符串操作;
// https://leetcode-cn.com/problems/longest-palindromic-substring/

/**
 * @ClassName _5_最长回文子串
 * @Description
 * @Author StarLee
 * @Date 2022/1/15
 */
@SuppressWarnings("all")
public class _5_最长回文子串 {
    /**
     *  给你一个字符串 s，找到 s 中最长的回文子串
     *  输入：s = "babad"
     *  输出："bab"
     *  解释："aba" 同样是符合题意的答案
     */
    // 动态规划
    public String longestPalindrome(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return s;
        // dp[i][j] 表示chars[i,j]是否是回文串
        boolean[][] dp = new boolean[chars.length][chars.length];
        int maxLen = 1;
        int begin = 0;
        // 显然i>=j才有意义,并且如果chars[i+1,j-1]是回文串&&chars[i]==chars[j];chars[i,j]才可能是回文串
        /*
        *     b a b a
        *   b T F T F
        *   a   T F T     从左下脚推出右上角的值
        *   b     T F
        *   a       T
        */
        // 由下至上
        for (int i = chars.length - 1; i >= 0; i--) {
            // 由左至右
            for (int j = i; j < chars.length; j++) {
                int len = j - i + 1;
                dp[i][j] = (chars[i] == chars[j]) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen){
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return new String(chars,begin,maxLen);
    }

    // 扩展中心法
    public String longestPalindrome1(String s){
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return s;
        int maxLen = palindromeLength(chars,0,1) == 0 ? 1 : 2;
        int begin = 0;
        // b|a|b|a|d
        // 第一个b没必要作为中心,最后一个d也没必要,因为其已经是边界,求了也是自己
        // 从索引1也就是a开始拓展,显然b|a的这个缝隙会被忽略,干脆将其作为maxLen的初始值处理
        for (int i = 1; i < chars.length - 1; i++) {
            // 以索引为中心拓展【回文串长度为奇数情况】
            int len1 = palindromeLength(chars,i - 1,i + 1);
            // 以索引右边间隙为中心拓展【回文串长度为偶数情况】
            int len2 = palindromeLength(chars,i,i + 1);
            len1 = Math.max(len1,len2);
            if (len1 > maxLen){
                maxLen = len1;
                // begin是一种计算公式同时兼容了索引为中心、索引右边间隙为中心的情况
                begin = i - (maxLen - 1) / 2;
            }
        }
        return new String(chars,begin,maxLen);
    }

    public int palindromeLength(char[] chars,int left,int right){
        while (left >= 0 && right < chars.length && chars[left] == chars[right]){
            left--;
            right++;
        }
        // 出循环时,left与right都多运算了一次
        return right - left - 1;
    }

    /* 拓展中心法的优化
     * 我们发现以间隙为中心进行拓展的行为是针对xxxaaxxxx,即偶数串中心为两个相同字符的情况
     * 且我们在进行了a|a拓展的同时,还拓展了a|x这种显然不成立的情况,所以可以想办法消去这类拓展
     */
    public String longestPalindrome2(String s){
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return s;
        int maxLen = 1;
        int begin = 0;
        int i = 0;
        // d baaa d
        while (i < chars.length - 1){
            int left = i - 1;
            int right = i;
            // 向右涵盖相同的字符,也就是在处理所有有意义的间隙情况
            while (++right < chars.length && chars[i] == chars[right]);
            // 到此right应该是处于与chars[i]不相同的第一个字符处
            // 下一次应该从这里继续拓展
            i = right;
            // 左右进行拓展
            while (left >= 0 && right < chars.length && chars[left] == chars[right]){
                left--;
                right++;
            }
            // (left,right)
            int len = right - (++left);
            if (len > maxLen){
                maxLen = len;
                begin = left;
            }
        }
        return new String(chars,begin,maxLen);
    }

    private char[] preprocess(char[] oldCs) {
        // "aabbaacac" ——> ^#a#a#b#b#a#a#c#a#c#$
        char[] cs = new char[(oldCs.length << 1) + 3];
        cs[0] = '^';
        cs[1] = '#';
        cs[cs.length - 1] = '$';
        for (int i = 0; i < oldCs.length; i++) {
            int idx = (i + 1) << 1;
            cs[idx] = oldCs[i];
            cs[idx + 1] = '#';
        }
        return cs;
    }

    /**
     * 马拉车算法
     */
    public String longestPalindromeManacher(String s) {
        if (s == null) return null;
        char[] oldCs = s.toCharArray();
        if (oldCs.length <= 1) return s;

        // 预处理  类似于 "aabbaacac" ——> ^#a#a#b#b#a#a#c#a#c#$  【首尾字符必须不存在与字串中】
        char[] cs = preprocess(oldCs);
        // 构建m数组
        int[] m = new int[cs.length];
        int c = 1, r = 1, lastIdx = m.length - 2;
        int maxLen = 0, idx = 0;
        for (int i = 2; i < lastIdx; i++) {
            if (r > i) {
                int li = (c << 1) - i;
                m[i] = (i + m[li] <= r) ? m[li] : (r - i);
            }

            // 以i为中心，向左右扩展
            while (cs[i + m[i] + 1] == cs[i - m[i] - 1]) {
                m[i]++;
            }

            // 更新c、r
            if (i + m[i] > r) {
                c = i;
                r = i + m[i];
            }

            // 找出更大的回文子串
            if (m[i] > maxLen) {
                maxLen = m[i];
                idx = i;
            }
        }
        int begin = (idx - maxLen) >> 1;
        return new String(oldCs, begin, maxLen);
    }
}
