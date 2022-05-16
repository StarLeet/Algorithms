package _99_代码随想录._04_字符串;

/**
 * @ClassName 剑指_Offer_05_替换空格
 * @Description
 * @Author StarLee
 * @Date 2022/5/2
 */

public class 剑指_Offer_05_替换空格 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
