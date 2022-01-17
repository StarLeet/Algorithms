package 算法面试._02_链表操作;
// https://leetcode-cn.com/problems/add-two-numbers/
/**
 * @ClassName _0002_两数相加
 * @Description
 * @Author StarLee
 * @Date 2022/1/8
 */

public class _0002_两数相加 {
    /***
     * 给你两个非空的链表，表示两个非负的整数。
     * 它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newHead = new ListNode(-1);  // 运用虚拟头结点
        ListNode last = newHead;
        int carry = 0;  // 初始进位为0
        while (l1 != null || l2 != null){
            int v1 = 0;   // 当l1到null时,默认其为0
            int v2 = 0;   // 当l2到null时,默认其为0
            if (l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10;  // 计算当前两结点的进位
            last.next = new ListNode(sum % 10);
            last = last.next;
        }
        if (carry != 0){   // 最后一个进位在while里是被忽略的,必须补上
            last.next = new ListNode(1);
        }
        return newHead.next;
    }
}
