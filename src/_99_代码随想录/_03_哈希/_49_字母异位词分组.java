package _99_代码随想录._03_哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName _49_字母异位词分组
 * @Description
 * @Author StarLee
 * @Date 2022/4/17
 */

public class _49_字母异位词分组 {
    // 排序
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) map.put(s,new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // format字符串,造轮子,操作短字串效率低
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = formatString(str);
            if (!map.containsKey(s)) map.put(s,new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String formatString(String s){
        if (s == null) return null;
        if (s.length() == 0) return "";
        int[] chars = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0){
                sb.append((char)('a' + i)).append(chars[i]);
            }
        }
        return sb.toString();
    }
}






