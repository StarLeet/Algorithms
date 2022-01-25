package 算法面试._08_DFS;
// https://leetcode-cn.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _22_括号生成
 * @Description
 * @Author StarLee
 * @Date 2022/1/18
 */

public class _22_括号生成 {
    /**
     * 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(0,n,n,new char[2*n],list);
        return list;
    }

    /**
     *
     * @param depth 深度
     * @param leftCount 左括号个数
     * @param rightCount 右括号个数
     * @param string 存储每一种组合的字符串
     */
    private void dfs(int depth,int leftCount,int rightCount,char[] string,List<String> list){
        if (depth == string.length){
            list.add(new String(string));
            return;
        }
        // 可以添加左括号的条件
        if (leftCount > 0){
            string[depth] = '(';
            dfs(depth + 1,leftCount - 1,rightCount,string,list);
        }
        // 当左括号与右括号剩余数相同时,下一个只能是左括号,否则())会出现这种不合理情况
        if (leftCount != rightCount && rightCount > 0){
            string[depth] = ')';
            dfs(depth + 1,leftCount,rightCount - 1,string,list);
        }
    }
}
