package _99_代码随想录._02_链表;

import 算法面试._02_链表操作.ListNode;

/**
 * @ClassName 三分链表
 * @Description
 * @Author StarLee
 * @Date 2022/5/9
 */
public class 三分链表 {
    // 1 2 3 4 5 6   0 x 2x 3x
    public ListNode[] threePartsLinkedList(ListNode head){
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode slow = head;
        ListNode mid = head;
        ListNode fast = head;
        // 划分三段
        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            mid = mid.next.next;
            fast = fast.next.next.next;
        }
        // 断开连接
        fast = head;
        while (fast != null){
            if (fast.next == slow){
                fast.next = null;
                fast = slow;
            }else if (fast.next == mid){
                fast.next = null;
                fast = mid;
            }else {
                fast = fast.next;
            }
        }
        return new ListNode[]{head,slow,mid};
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedListTools.create(0, 500,1000);
        ListNode[] nodes = new 三分链表().threePartsLinkedList(listNode);
        for (ListNode node : nodes) {
            System.out.println(node);
        }
    }
}
