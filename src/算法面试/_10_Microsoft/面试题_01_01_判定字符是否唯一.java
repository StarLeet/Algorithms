package 算法面试._10_Microsoft;

import java.util.HashSet;

/**
 * @ClassName 面试题_01_01_判定字符是否唯一
 * @Description
 * @Author StarLee
 * @Date 2022/4/2
 */

public class 面试题_01_01_判定字符是否唯一 {
    public boolean isUnique(String astr) {
//        if(astr == null || astr.length() == 0) return true;
//        HashSet<Character> characters = new HashSet<>();
//        int i = 0;
//        boolean result = true;
//        while (i < astr.length()){
//            char c = astr.charAt(i++);
//            if (characters.contains(c)){
//                result = false;
//                break;
//            }
//            characters.add(c);
//        }
//        return result;
        if (astr == null || astr.length() == 0) return true;
        int[] chars = new int[4]; // 0 1   64   128
        int i = 0;
        boolean result = true;
        while (i < astr.length()) {
            char c = astr.charAt(i++);
            int j = c / 64;
            if ((chars[j] & (1 << c)) == 0){
                chars[j] |= (1 << c);
            }else {
                result = false;
                break;
            }
        }
        return result;
    }
}
