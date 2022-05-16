package _99_代码随想录._06_栈与队列;

import java.util.Stack;

/**
 * @ClassName _232_用栈实现队列
 * @Description
 * @Author StarLee
 * @Date 2022/5/3
 */
public class _232_用栈实现队列 {
    class MyQueue {
        private final Stack<Integer> stack;
        private final Stack<Integer> stack1;
        public MyQueue() {
            stack = new Stack<>();
            stack1 = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            if (empty()) return Integer.MIN_VALUE;
            if (stack1.isEmpty()){
                while (!stack.isEmpty()){
                    stack1.push(stack.pop());
                }
            }
            return stack1.pop();
        }

        public int peek() {
            if (empty()) return Integer.MIN_VALUE;
            if (stack1.isEmpty()){
                while (!stack.isEmpty()){
                    stack1.push(stack.pop());
                }
            }
            return stack1.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && stack1.isEmpty();
        }
    }
}
