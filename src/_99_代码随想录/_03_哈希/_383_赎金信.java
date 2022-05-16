package _99_代码随想录._03_哈希;

/**
 * @ClassName _383_赎金信
 * @Description
 * @Author StarLee
 * @Date 2022/4/17
 */

public class _383_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        if (ransomNote.length() > magazine.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--chars[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
