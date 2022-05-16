package _99_代码随想录._08_回溯._00_组合;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _17_电话号码的字母组合
 * @Description
 * @Author StarLee
 * @Date 2022/5/11
 */
public class _17_电话号码的字母组合 {
    // 存储映射关系
    private final char[][] charsMap = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
            {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    private List<String> result;
    private char[] numbers;
    private char[] choose;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        numbers = digits.toCharArray();
        choose = new char[numbers.length];
        dfs(0);
        return result;
    }

    private void dfs(int curDepth){
        if (curDepth == numbers.length){
            result.add(new String(choose));
            return;
        }

        for (char c : charsMap[numbers[curDepth] - '2']) {
            choose[curDepth] = c;
            dfs(curDepth + 1);
        }
    }
}
