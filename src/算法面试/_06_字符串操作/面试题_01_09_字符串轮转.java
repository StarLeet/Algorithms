package 算法面试._06_字符串操作;
// https://leetcode-cn.com/problems/string-rotation-lcci/
/**
 * @ClassName 面试题_01_09_字符串轮转
 * @Description
 * @Author StarLee
 * @Date 2022/1/10
 */

public class 面试题_01_09_字符串轮转 {
    /**
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
     * (比如，waterbottle是erbottlewat旋转后的字符串)
     *  输入：s1 = "waterbottle", s2 = "erbottlewat"
     *  输出：True
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2== null) return false;
        if (s1.length() != s2.length()) return false;
        return (s1+s2).contains(s2);
    }
}
