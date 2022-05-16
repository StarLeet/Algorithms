package _99_代码随想录._02_链表;

import 算法面试._02_链表操作.ListNode;

/**
 * @ClassName 面试题_02_04_分割链表
 * @Description
 * @Author StarLee
 * @Date 2022/5/9
 */
public class 面试题_02_04_分割链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode right = new ListNode(x);
        ListNode left = new ListNode(-1);
        ListNode tail = left;
        ListNode cur = head;
        // 1 4 3 | 5 6 8
        while (cur != null){
            ListNode next = cur.next;
            if (cur.val < x){
                if (left.next == null) tail = cur;
                cur.next = left.next;
                left.next = cur;
            }else {
                cur.next = right.next;
                right.next = cur;
            }
            cur = next;
        }
        tail.next = right.next;
        head = left.next;
        return head;
    }


}
