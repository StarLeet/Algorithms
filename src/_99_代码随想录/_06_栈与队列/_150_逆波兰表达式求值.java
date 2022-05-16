package _99_代码随想录._06_栈与队列;

import java.util.Stack;

/**
 * @ClassName _150_逆波兰表达式求值
 * @Description
 * @Author StarLee
 * @Date 2022/5/3
 */
public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        if (tokens == null) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            char ch = token.charAt(0);
            // 考虑负数情况
            if (ch >= '0' && ch <= '9' || token.length() > 1) {
                stack.push(Integer.valueOf(token));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(first + second);
                        break;
                    case '-':
                        stack.push(first - second);
                        break;
                    case '*':
                        stack.push(first * second);
                        break;
                    case '/':
                        stack.push(first / second);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        _150_逆波兰表达式求值 v = new _150_逆波兰表达式求值();
        v.evalRPN(arr);
    }
}
