package 算法面试._02_链表操作;
// https://leetcode-cn.com/problems/partition-list/

/**
 * @ClassName _0086_分隔链表
 * @Description
 * @Author StarLee
 * @Date 2022/1/8
 */

public class _0086_分隔链表 {
    /***
     * 给你一个链表的头节点head和一个特定值x
     * 请你对链表进行分隔，使得所有小于x的节点都出现在大于或等于x的节点之前。
     * 注意：应当保留两个分区中每个节点的初始相对位置
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     */
    private ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode smallHead = new ListNode(-1); // 用来串上比x小的结点
        ListNode lastSmall = smallHead;
        ListNode bigHead = new ListNode(-1);  // 用来串上大于等于x的结点
        ListNode lastBig = bigHead;
        while (head != null){  //普通地遍历原链表
            if (head.val < x){   //比x小的串在Small链表
                lastSmall.next = head;
                lastSmall = lastSmall.next;
            }else {
                lastBig.next = head;
                lastBig = lastBig.next;
            }
            head = head.next;
        }
        /*
         * 可能的情况： 1 2 3 4 2   如果x为2
         * bigHead [3,4,2]  最后一个lastBig.next仍可能还连着其它结点
         * 这里做主动脱钩处理
         */
        lastBig.next = null;
        lastSmall.next = bigHead.next; //Small的尾拼上Big的头
        return smallHead.next;
    }
}
