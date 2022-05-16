package _99_代码随想录._02_链表.移除元素;


import 算法面试._02_链表操作.ListNode;

/**
 * @ClassName _203_移除链表元素
 * @Description
 * @Author StarLee
 * @Date 2022/4/15
 */

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);  // 虚拟头节点
        ListNode cur = newHead;
        while (head != null){
            if (head.val != val){
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return newHead.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode newNode = new ListNode(Integer.MIN_VALUE);
        newNode.next = head;
        removeE(newNode,head,val);
        return newNode.next;
    }
    private void removeE(ListNode prev, ListNode head, int val){
        // 1 2 3
        if (head == null){
            prev.next = null;
            return;
        }
        if (head.val != val){
            prev.next = head;
            prev = head;
        }
        removeE(prev,head.next,val);
    }
}
