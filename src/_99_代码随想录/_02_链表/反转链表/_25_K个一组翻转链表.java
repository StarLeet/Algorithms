package _99_代码随想录._02_链表.反转链表;

import 算法面试._02_链表操作.ListNode;

/**
 * @ClassName _25_K个一组翻转链表
 * @Description
 * @Author StarLee
 * @Date 2022/4/20
 */

public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) return head;  // 临界判断
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        ListNode curOld = head;  // 用于遍历旧链表
        int length = countNodes(head);
//        if (k > length) return head;  // k大于链表长度的处理
        int revertNum = length / k; // 反转的次数

        while (revertNum-- > 0){  // 反转操作
            ListNode[] nodes = revertKNode(curOld,newTail,k);
            curOld = nodes[0];
            newTail = nodes[1];
        }
        newTail.next = curOld; // 对留余的旧链表节点进行直接拼接
        return newHead.next;
    }

    /**
     * 计算链表长度
     */
    private int countNodes(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * @param curOld 旧链表当前节点
     * @param newTail 新链表尾部
     * @param k 需要反转的节点个数
     *   头插法
     */
    private ListNode[] revertKNode(ListNode curOld, ListNode newTail, int k){
        ListNode new_newTail = curOld;
        while (k-- > 0){
            ListNode curNext = curOld.next;
            curOld.next = newTail.next;
            newTail.next = curOld;
            curOld = curNext;
        }
        return new ListNode[]{curOld, new_newTail};  // 返回旧链表当前遍历到的节点,以及新链表的尾部
    }
}
