package _99_代码随想录._06_栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @ClassName _225_用队列实现栈
 * @Description
 * @Author StarLee
 * @Date 2022/5/3
 */
public class _225_用队列实现栈 {
    class MyStack {
        Deque<Integer> queue;
        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            if (queue.isEmpty()) return Integer.MIN_VALUE;
            return queue.pollLast();
        }

        public int top() {
            if (queue.isEmpty()) return Integer.MIN_VALUE;
            return queue.peekLast();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
