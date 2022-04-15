package _99_代码随想录._01_数组.滑动窗口;

import _06_字符串匹配.BruteForce01;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _76_最小覆盖子串
 * @Description
 * @Author StarLee
 * @Date 2022/4/14
 */

public class _76_最小覆盖子串 {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || s.length() < t.length()) return "";
        int[] charSet = new int[1 << 7];
        int[] inString = new int[1 << 7]; // 原数组要是出现减为0会误判,所以备份个新数组
        for (int i = 0; i < t.length(); i++) {
            charSet[t.charAt(i)]++;
        }
        int begin = -1;
        // 第一个特殊字符,作初始左边界
        for (int i = 0; i < s.length(); i++) {
            if (charSet[s.charAt(i)] != 0){
                begin = i;
                break;
            }
        }
        if (begin == -1) return "";
        int charNum = t.length();
        int[] result = {-1,-1};
        // 找初始窗口的右边界
        for (int end = begin; end < s.length(); end++) {
            if (charSet[s.charAt(end)] == 0) continue;
            inString[s.charAt(end)]++;
            if (inString[s.charAt(end)] == charSet[s.charAt(end)]){
                charNum -= inString[s.charAt(end)];
            }
            if (charNum == 0){
                result[0] = begin;
                result[1] = end + 1;
                break;
            }
        }
        if (charNum != 0) return "";
        if (result[1] - result[0] == t.length()) return s.substring(result[0],result[1]);
        // "ADOBECODEBANC", "ABC"
        // 2. 收缩左边界、如果不满足了,左边界推到特殊字符,同时扩展右边界
        for (int end = result[1] - 1; end < s.length();) {
            int oldBegin = s.charAt(begin++);
            // 左推到特殊字符
            while (charSet[s.charAt(begin)] == 0) begin++;
            inString[oldBegin]--;
            // 没有富余,右推到该字符处
            if (inString[oldBegin] < charSet[oldBegin]){
                end++;
                while (end < s.length() && s.charAt(end) != oldBegin) {
                    if (charSet[s.charAt(end)] != 0) inString[s.charAt(end)]++;
                    end++;
                }
                if (end == s.length()) return s.substring(result[0],result[1]);
                inString[oldBegin]++;
            }
            // 普通字符以及富余字符的处理
            int newLen = end - begin + 1;
            if (newLen == t.length()) return s.substring(begin,end + 1);
            if (newLen < result[1] - result[0]){
                result[0] = begin;
                result[1] = end + 1;
            }
        }
        return s.substring(result[0],result[1]);
    }

    public static void main(String[] args) {
        _76_最小覆盖子串 v = new _76_最小覆盖子串();
        v.minWindow("acbbaca","aba");
    }

    public String minWindow1(String s, String t) {
        //利用hash数组替代Map
        int[] hash = new int[128];
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int slen = s.length();
        int tlen = t.length();
        int left=0,right=0,count=0;
        int start=0,end=0,minLen=Integer.MAX_VALUE;
        //初始化t字符串中的字母，例如：t中a出现了2次，对应的hash[a]=-2
        for (int i = 0; i <tlen ; i++) {
            hash[tchars[i]]--;
        }
        //滑动窗口
        while (right<slen){
            //右边界后移一位
            char c = schars[right++];
            //将当前字母出现次数+1
            hash[c]++;
            //如果出现次数<=0，说明该字母是t中包含的字母，则将count+1
            if (hash[c]<=0) count++;
            //如果count！=t字符串的长度，说明当前窗口中还未包含所有t中的字母，跳过循环，继续右移边界。
            if (count!=tlen) continue;
            //如果count==tlen，尝试缩小左边界
            //hash[schars[left]>0，说明该字母不是t中出现的字母，可以移出窗口
            while (hash[schars[left]]>0){
                hash[schars[left++]]--;
            }
            //计算当前窗口的大小，并记录当前窗口的索引
            if (right-left<minLen){
                start=left;
                end=right;
                minLen=right-left;
            }
            //将左窗口右移一位，目的是将一个t中有的字符移出窗口，来继续向下查找有没有更小的窗口
            count--;
            hash[schars[left++]]--;
        }
        return s.substring(start,end);
    }
}
