package _99_代码随想录._08_回溯._01_分割;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _131_分割回文串
 * @Description  分割问题本质跟组合是一样的
 * @Author StarLee
 * @Date 2022/5/11
 */
public class _131_分割回文串 {
    private List<List<String>> result; // 结果集
    private char[] chars;
    private ArrayList<String> choose;  // 存储某一类情况
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        chars = s.toCharArray();
        choose = new ArrayList<>();
        dfs(0,s);
        return result;
    }

    private void dfs(int startIndex, String s){
        /* 只有当前面都是回文子串的时候,startIndex才有可能为chars.length
           而startIndex为chars.length,意味着后续再无元素可以划分,此时保存数据进行回溯
            a a b $
            否则在上一层都被if挡住了,根本没机会执行到这一步
         */
        if (startIndex == chars.length){
            result.add(new ArrayList<>(choose));
            return;
        }
        /* 按情况分割,分割线在元素chars[i]之后
              i
              a | b c
         */
        for (int i = startIndex; i < chars.length; i++) {
            // 只有当前部分为回文子串的时候,我们才有必要进行下一部分的划分
            if (isPalindrome(startIndex,i)){
                // 保存当前的回文子串
                choose.add(s.substring(startIndex,i + 1));
                dfs(i + 1,s);
                // 回溯操作
                choose.remove(choose.size() - 1);
            }
        }
    }

    /** 判断回文子串
     *  [begin,end]
     */
    private boolean isPalindrome(int begin, int end){
        while (begin < end){
            if (chars[begin++] != chars[end--]) return false;
        }
        return true;
    }
}
