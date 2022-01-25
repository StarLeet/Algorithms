package 算法面试._08_DFS;
// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _17_电话号码的字母组合
 * @Description DFS常用于大部分排列组合问题
 * @Author StarLee
 * @Date 2022/1/17
 */

public class _17_电话号码的字母组合 {
    // 存储号码与字母的映射
    private char[][] lettersArray = {  // 2 3 4 5 6对应的字母集合
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    // 将输入的字串转换为字符保存
    private char[] chars;
    // 存储一种组合的值
    private char[] string;
    private List<String> list;
    /**
     * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
     * 给出数字到字母的映射。注意 1 不对应任何字母
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    // 三步骤 (1)写出dfs方法 (2)dfs方法中补充最后一层的退出逻辑 (3)写出for循环、回溯dfs
    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        if (digits.length() == 0) return new ArrayList<>();
        chars = digits.toCharArray();
        // 字符串digits有多长,组合字串string就有多长
        string = new char[chars.length];
        list = new ArrayList<>();
        // digits一个字符作一层
        dfs(0);
        return list;
    }

    private void dfs(int depth){
        // 已经进入到最后一层了，不能再往下搜索。将组合好的string转换成字符串类型加入list中
        if (depth == chars.length){
            list.add(new String(string));
            return;
        }
        // 回溯与剪枝
        /* depth
        *    0       2           a               b                c
        *    1       3         d e f           d e f            d e f
        *    2       4     g h i ...       g h i ...        g h i ...
        *  for循环中反复dfs会在dg执行完后返回d,接着继续执行dh...
        * */
        // 枚举这一层可以选择的所有字符
        for (int i = 0; i < lettersArray[chars[depth] - '2'].length; i++) {
            string[depth] = lettersArray[chars[depth] - '2'][i];
            dfs(depth + 1);
        }
    }
}
