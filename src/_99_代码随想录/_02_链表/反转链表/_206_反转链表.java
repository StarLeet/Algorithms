package _99_代码随想录._02_链表.反转链表;

import 算法面试._02_链表操作.ListNode;

import java.util.List;

/**
 * @ClassName _206_反转链表
 * @Description
 * @Author StarLee
 * @Date 2022/4/16
 */

public class _206_反转链表 {
    // 迭代
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }


    public ListNode reverseList1(ListNode head) {
        return reverse1(null,head);
    }
    // 尾递归  由迭代推出
    public ListNode reverse1(ListNode prev, ListNode cur) {
        // h 1 2 3    1——>null   2——>1——>null 3——>2——>1——>null
        if (cur == null) return prev;
        ListNode next = cur.next;
        cur.next = prev;
        return reverse1(cur,next);
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        return reverse2(head);
    }
    // 普通递归 由后向前反转(较难理解)
    public ListNode reverse2(ListNode cur) {
        // 1. 指定退出条件   // 2. 返回信息：应该给上一级返回什么? 反转后的头部
        if (cur.next == null) return cur;
        // 3. 递归需要反复进行的逻辑(在这里是将节点接到上一级传回来的尾部)
        // 1 2 3 null ——> 3 2 null
        ListNode newHead = reverse2(cur.next);
        ListNode prev = cur.next;
        cur.next = prev.next;
        prev.next = cur;
        return newHead;
    }
}
