package _99_代码随想录._02_链表.移除元素;

import 算法面试._02_链表操作.ListNode;

import java.util.Stack;

/**
 * @ClassName _19_删除链表的倒数第N个结点
 * @Description
 * @Author StarLee
 * @Date 2022/4/16
 */

public class _19_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        removeN(newHead,n);
        return newHead.next;
    }

    // 递归
    public int removeN(ListNode cur, int n){
        if (cur == null) return 0;
        int back = removeN(cur.next,n) + 1;
        if (back == n + 1) {
            cur.next = cur.next.next;
        }
        return back;
    }

    // 快慢指针
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        /*      删除倒数第2个
                newHead  1 2 3 4
                  slow     f
         */
        if (head == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;
        while (n-- > 0){   // 使fast快slow N步
            fast = fast.next;
            if (fast == null) return newHead.next;
        }
        while (fast.next != null){  // fast移至表尾
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;  // 此时的slow在目标元素之前
        return newHead.next;
    }

    // 栈
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        if (stack.size() - 1 < n) return head;
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return newHead.next;
    }
}
