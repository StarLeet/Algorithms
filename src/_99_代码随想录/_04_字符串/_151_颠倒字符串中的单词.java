package _99_代码随想录._04_字符串;

/**
 * @ClassName _151_颠倒字符串中的单词
 * @Description
 * @Author StarLee
 * @Date 2022/5/2
 */
public class _151_颠倒字符串中的单词 {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int begin = 0;
        // 忽略头部空格
        while (begin < chars.length && chars[begin] == ' ') begin++;
        int end = compressBlank(chars,begin);
        // 整体翻转
        reverseWord(chars,begin,end);
        int left = begin, right = begin;
        while (right <= end){
            if (right == end || chars[right] == ' '){
                // 单词现在还是逆序的,局部翻转还原它
                reverseWord(chars,left,right);
                left = (++right);
            }
            right++;
        }
        return new String(chars,begin,end - begin);
    }
    // 压缩空格 (关键！！！)
    private int compressBlank(char[] arr, int begin){
        int slow = begin;
        int end = arr.length;
        // 忽略尾部空格
        while (end > 0 && arr[end - 1] == ' ') end--;
        // 跳到第一个空格处,因为前面的没必要压缩
        while (slow < end && arr[slow] != ' ') slow++;
        for (int fast = slow; fast < end; fast++) {
            // 空格前面也是空格,则此空格是无效的,跳过
            if (arr[fast] == ' ' && arr[fast - 1] == ' ') continue;
            arr[slow++] = arr[fast];
        }
        return slow;
    }

    // [left,right)
    private void reverseWord(char[] arr, int left, int right){
        if (left >= right) return;
        // 整体翻转：将后面的单词换到前面
        right--;
        while (left < right){
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        new _151_颠倒字符串中的单词().reverseWords("  hello world  ");
    }
}
