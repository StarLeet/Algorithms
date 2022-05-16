package _99_代码随想录._04_字符串;

/**
 * @ClassName _541_反转字符串II
 * @Description
 * @Author StarLee
 * @Date 2022/5/1
 */

public class _541_反转字符串II {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int round = chars.length / (2 * k);
        int curLeft = 0;
        for (int i = 0; i < round; i++) {
            curLeft = 2 * k * i;
            swapK(chars,curLeft,curLeft + k);
        }
        int remain = chars.length % (2 * k);
        curLeft = 2 * k * round;
        swapK(chars,curLeft,curLeft + Math.min(remain, k));
        return new String(chars);
    }
    // [left,right)
    private void swapK(char[] arr, int left, int right){
        if (left >= --right) return;
        while (left < right){
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        new _541_反转字符串II().reverseStr("abcdefg",2);
    }
}
