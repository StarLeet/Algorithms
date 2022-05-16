package _99_代码随想录._04_字符串;

import java.util.Arrays;

/**
 * @ClassName 剑指_Offer_58_II_左旋转字符串
 * @Description
 * @Author StarLee
 * @Date 2022/5/2
 */
public class 剑指_Offer_58_II_左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        char[] chars1 = new char[n];
        System.arraycopy(chars,0,chars1,0,n);
        if (chars.length - n >= 0) {
            System.arraycopy(chars, n, chars, 0, chars.length - n);
        }
        System.arraycopy(chars1,0,chars,chars.length - n,chars1.length);
        return new String(chars);
    }
//    public String reverseLeftWords(String s, int n) {
//        if (s == null || s.length() <= 1) return s;
//        char[] chars = s.toCharArray();
//        reverseK(chars,0,chars.length);
//        reverseK(chars,0,chars.length - n);
//        reverseK(chars,chars.length - n,chars.length);
//        return new String(chars);
//    }

    private void reverseK(char[] arr, int left, int right){
        right--;
        if (left >= right) return;
        while (left < right){
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }
}
