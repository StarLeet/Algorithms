package _99_代码随想录._02_链表;

import _00_排序算法._03_HeapSort.HeapSort;
import 算法面试._02_链表操作.ListNode;

import javax.swing.plaf.SliderUI;
import java.util.List;

/**
 * @ClassName _24_两两交换链表中的节点
 * @Description
 * @Author StarLee
 * @Date 2022/4/16
 */

public class _24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        // 1 2 3 4
        while (fast != null){
            // 记录下一次处理的首部
            ListNode next = fast.next;
            // 交换拼接到新头部
            newTail.next = fast;
            fast.next = slow;
            slow.next = null;
            newTail = slow;
            // 到尾部退出
            if (next == null) break;
            slow = next;
            fast = next.next;
        }
        // 说明节点个数是奇数,有一个slow需要处理  1 2 3【slow】
        if (fast == null){
            newTail.next = slow;
        }
        return newHead.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        swap(newHead,head,head.next);
        return newHead.next;
    }
    // 尾递归
    private void swap(ListNode prev,ListNode left, ListNode right){
        // 1 2 3 4
        if (right == null) return;
        ListNode next = right.next;
        left.next = next;
        right.next = left;
        prev.next = right;
        if (next == null) return;
        swap(left,next,next.next);
    }
}
