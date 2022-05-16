package _99_代码随想录._06_栈与队列;

import java.util.Stack;

/**
 * @ClassName _20_有效的括号
 * @Description
 * @Author StarLee
 * @Date 2022/5/3
 */
public class _20_有效的括号 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            // 右括号必须搭配左括号,所以栈不能为空
            if (stack.isEmpty()) return false;
            // 如果有效则栈顶一定与自己配对
            switch (ch){
                case ')':
                    if (stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.pop() != '{') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
