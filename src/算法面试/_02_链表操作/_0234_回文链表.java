package 算法面试._02_链表操作;
// https://leetcode-cn.com/problems/palindrome-linked-list/

/**
 * @ClassName _0234_回文链表
 * @Description
 * @Author StarLee
 * @Date 2022/1/8
 */

public class _0234_回文链表 {
    /***
     * 给你一个单链表的头节点head，请你判断该链表是否为回文链表
     * 如果是，返回true ；否则，返回false
     * 输入：head = [1,2,2,1]
     * 输出：true
     */
    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        // 来到这里说明链表至少有三个元素
        ListNode middle = findMiddle(head);
        System.out.println("翻转前(调试输出)   " + head);
        reverseSubList(middle);  // 反转中心节点之后的子链表
        System.out.println("翻转后(调试输出)   " + head);
        /*   当要求链表结构不能破坏时,需要以下三步  */
        ListNode oldHead = head;
        ListNode oldMiddle = middle;
        boolean result = true;

        middle = middle.next;
        while (middle != null){
            if (head.val != middle.val){
                result = false;
                break;
            }
            head = head.next;
            middle = middle.next;
        }
        reverseSubList(oldMiddle);
        System.out.println("翻转回来(调试输出) " + oldHead);
        return result;
    }

    /***
     * 快慢指针定位中心节点
     */
    private static ListNode findMiddle(ListNode head){
        if (head == null) return null;
        if (head.next == null || head.next.next == null) return head;
        ListNode slow = head;
        head = head.next;
        while (head != null && head.next != null){
            slow = slow.next;
            head = head.next.next;
        }
        return slow;
    }

    /***
     * 链表反转
     */
    private static void reverseSubList(ListNode middle){
        ListNode newHead = new ListNode(-1);
        ListNode cur = middle.next;
        while (cur != null){   // 易错点
            ListNode next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        middle.next = newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int[] arr = {2,3,2,1};
        ListNode last = head;
        for (int j : arr) {
            last.next = new ListNode(j);
            last = last.next;
        }
        System.out.println(isPalindrome(head));
    }

}
