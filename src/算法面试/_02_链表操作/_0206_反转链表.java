package 算法面试._02_链表操作;

//   https://leetcode-cn.com/problems/reverse-linked-list/
public class _0206_反转链表 {
    /**
     * 分析:      反转前: head——> 4——>3——>2——>1——>null
     *           反转后: head——> 1——>2——>3——>4——>null
     *    1. 假设我们调用的函数是reverseList_1(4),如上图所示
     *           理解关键:单链表只能改变next而不能改变prev
     *    2. 那么我们最先关注的应该是reverseList_1(n--)返回的结果
     *       reverseList_1(3)为 3(head)——>reverseList_1(2)
     *       reverseList_1(2)为 2(head)——>reverseList_1(1)
     *       ======================================================
     *       reverseList_1(2)回溯时 1(newHead)——>null
     *                    2(head) ↗
     *       reverseList_1(3)回溯时 1(newHead)——>2——>null
     *                                 3(head) ↗
     *       reverseList_1(4)回溯时 1(newHead)——>2——>3——>null
     *                                     4(head) ↗
     *    3. 递归应该在何时停止呢？
     *       第一、当传入的是空链表时,不应该继续递归
     *       第二、当反转递归到最后一个结点时,不应该递归(因为反转后还是自己)
     * */
    private static ListNode reverseList_1(ListNode head) {  //递归解法
        if (head == null || head.next==null) return head;  //参照分析4.
        ListNode newHead = reverseList_1(head.next);  //参照分析2.
        head.next.next = head;//参照分析2.
        head.next = null; //参照分析2.
        return newHead;
    }


    private static ListNode reverseList_2(ListNode head){   //迭代解法
        ListNode newHead = null;
        while(head != null){
            ListNode p = head.next;
            head.next = newHead;
            newHead = head;
            head = p;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode list = initLinkedList(10);
        list = reverseList_2(list);
        while (list != null){
            System.out.print(list.val + "——>");
            list = list.next;
        }
    }

    private static ListNode initLinkedList(int num){
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= num; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return head;
    }

}


