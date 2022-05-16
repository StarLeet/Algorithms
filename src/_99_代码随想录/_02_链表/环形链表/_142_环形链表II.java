package _99_代码随想录._02_链表.环形链表;

import 算法面试._02_链表操作.ListNode;

import java.util.HashSet;

/**
 * @ClassName _142_环形链表II
 * @Description
 * @Author StarLee
 * @Date 2022/4/16
 */

public class _142_环形链表II {
    // hashSet 通过判断存在确定是否有环
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode result = null;
        while (head != null){
            if (hashSet.contains(head)){
                result = head;
                break;
            }
            hashSet.add(head);
            head = head.next;
        }
        return result;
    }

    // 快慢指针 (纯数学题)  教训：fast、slow最好成对执行,提前判出会影响找出环点
    // 同一head出发,fast走两步、slow走一步,二者相等说明有环
    // 在fast、slow环中相遇后,slow重新从head走,fast换为一个步长,再次相遇即为入环点
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 判断是否有环
        while (fast != null && fast.next != null){
            fast = fast.next.next;
             /*
              不可以多加这一步,这一步只能提前判断有环,但会使求入环点公式失效
              公式是根据fast、slow成对执行推出的
              */
            // if (fast == slow) break;
            slow = slow.next;
            if (fast == slow) break;  // 有环,fast为相遇点
        }
        if (fast == null || fast.next == null) return null;  // 无环直接退出
        // slow重回head
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
