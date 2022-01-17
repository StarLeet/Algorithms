package 算法面试._02_链表操作;
// https://leetcode-cn.com/problems/remove-linked-list-elements/

/**
 * @ClassName _0203_移除链表元素
 * @Description
 * @Author StarLee
 * @Date 2022/1/7
 */

public class _0203_移除链表元素 {
    /***
     * 递归解决
     */
    private static ListNode removeElements1(ListNode head, int val) {
        if (head == null)  return null;
        // 这里的递归相当于从后往前,忽略要删除的元素
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head; //要删除的元素直接取下一位,不删除就包含进来
    }

    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);  //用虚拟头结点,避免空指针异常
        ListNode last = newHead;
        while (head != null){
            if (head.val != val){
                last.next = head;  //采用虚拟头结点,这里非常好写
                last = last.next;
            }
            head = head.next;
        }
        // 假如删除的元素在最后一个,那么倒数第二个就是此时的cur,next还指着它
        last.next = null;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int[] arr = {2,6,3,4,6,6,6};
        ListNode last = head;
        for (int j : arr) {
            last.next = new ListNode(j);
            last = last.next;
        }
        head = removeElements1(head,6);
        while (head != null){
            System.out.print(head.val + "——>");
            head = head.next;
        }
        System.out.println("null");
    }
}
