package 算法面试._03_栈操作;
// https://leetcode-cn.com/problems/min-stack/

import java.util.Stack;

/**
 * @ClassName _155_最小栈
 * @Description
 * @Author StarLee
 * @Date 2022/1/9
 */
@SuppressWarnings("all")
public class _155_最小栈 {
    private class MinStack {
        public Stack<Integer> stack;  //正常栈
        public Stack<Integer> minStack;  //最小栈：存放当前正常栈内的每一次push的最小值
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()){  //最小栈为空时,正常栈也为空,val就是最小值
                minStack.push(val);
                return;
            }
            // 将当前push的val与最小栈栈顶(上一次push栈内最小值)比较
            minStack.push(Math.min(val,minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {  // 最小栈的每一个元素对应正常栈元素入栈时的最小值
            return minStack.peek();
        }
    }

    private class MinList{
        Node head = new Node(0,Integer.MAX_VALUE,null);
        class Node{  // 相当于将正常栈、最小栈横切串起来
            private int val; //相当于正常栈
            private int min; //相当于最小栈
            private Node next;

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }

            @Override
            public String toString() {
                return "{" + val + "," + min + "}——>" + next;
            }
        }
        public void push(int val) {
            head = new Node(val,Math.min(val,head.min),head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {  // 最小栈的每一个元素对应正常栈元素入栈时的最小值
            return head.min;
        }

    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,1,5,6};
        MinList minList = new _155_最小栈().new MinList();
        for (int i : arr) {
            minList.push(i);
        }
        System.out.println(minList.head);
    }
}
