package _99_代码随想录._02_链表;

import 算法面试._02_链表操作.ListNode;

/**
 * @ClassName 面试题_02_07_链表相交
 * @Description
 * @Author StarLee
 * @Date 2022/4/16
 */

public class 面试题_02_07_链表相交 {
    // 只需找到一个节点相等即可,后续的一定都是相等的
    // 解决方式：使二者遍历长度一样,遍历判断即可
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        // 1 2 3 | 5 1 2 3
        // 5 1 2 3 | 1 2 3
        while (curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
