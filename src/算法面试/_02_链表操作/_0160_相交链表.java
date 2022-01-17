package 算法面试._02_链表操作;
// https://leetcode-cn.com/problems/intersection-of-two-linked-lists/

/**
 * @ClassName _0160_相交链表
 * @Description
 * @Author StarLee
 * @Date 2022/1/8
 */

public class _0160_相交链表 {
    /***
     * 给你两个单链表的头节点headA和headB ，请你找出并返回两个单链表相交的起始节点(地址相同)。
     * 如果两个链表不存在相交节点，返回 null
     * listA = [1,9,1,2,4], listB = [3,2,4]
     * return 2   表示从结点2开始只有一份,被A、B共同指着
     */
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        /*   假设结点4是共有结点
         *   A、B不等长时,我们很难进行判断,将A拼到B后,B拼到A后,就可以了
         *  ListA 1 2 1 4    1 2  1(数值相同) 4 {2 4}
         *  ListB 2 4        2 4 {1(对象不同) 2  1 4}
         */
        while(curA != curB){ //如果没有相交的,最终二者都会是null,退出
            curA = (curA == null) ? headB : curA.next; // curA为空时拼接B的头
            curB = (curB == null) ? headA : curB.next; // curB为空时拼接A的头
        }

        // 这段代码在两个链表不相交的时候会死循环
        // curA = (curA.next == null) ? headB : curA.next;
        // curB = (curB.next == null) ? headA : curB.next;
        return curA;
    }
}
