package _99_代码随想录._02_链表;

import 算法面试._02_链表操作.ListNode;

/**
 * @ClassName _148_排序链表
 * @Description
 * @Author StarLee
 * @Date 2022/5/9
 */
public class _148_排序链表 {
    // 快排
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 1 1 2 3 5 6
        ListNode newHead = new ListNode();
        newHead.next = head;
        quickSort(head,null,newHead);
        return newHead.next;
    }
    // [head,end)
    private void quickSort(ListNode head, ListNode end, ListNode prev){
        if (head == end || head.next == end) return;
        ListNode pivot = findPivot(head,end,prev);
        quickSort(prev.next,pivot,prev);
        quickSort(pivot.next,end,pivot);
    }

    private ListNode findPivot(ListNode head, ListNode end, ListNode prev){
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 取对半的节点
        ListNode pivot = getPivot(head,end);
        int tmp = pivot.val;
        pivot.val = head.val;
        head.val = tmp;
        ListNode cur = head.next;
        ListNode tail = head;
        while (cur != end){
            ListNode next = cur.next;
            if (cur.val < tmp){
                tail.next = next;
                cur.next = pre.next;
                pre.next = cur;
            }else {
                tail = cur;
            }
            cur = next;
        }
        prev.next = pre.next;
        return head;
    }

    private ListNode getPivot(ListNode head, ListNode end){
        int length = 0;
        ListNode cur = head;
        while (cur.next != end){
            length++;
            cur = cur.next;
        }
        length = (int)(Math.random() * length);
        cur = head;
        while (cur.next != end){
            if (length-- == 0) break;
            cur = cur.next;
        }
        return cur;
    }


    // 归并
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        // 1 1 2
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("prev:  " + head);
        ListNode pre = slow;
        slow = slow.next;
        pre.next = null;
        System.out.println("split: " + head + "  |  " + slow);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        return merge(left,right);
    }
    // 1 3 2 6 4 5
    private ListNode merge(ListNode left, ListNode right){
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        while (left != null && right != null){
            ListNode mergeNode;
            if (left.val < right.val){
                mergeNode = left;
                left = left.next;
            }else {
                mergeNode = right;
                right = right.next;
            }
            mergeNode.next = tail.next;
            tail.next = mergeNode;
            tail = mergeNode;
        }
        tail.next = left == null ? right : left;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedListTools.create(5, 10, 5000);
        System.out.println(listNode);
        System.out.println(LinkedListTools.revertN(listNode,0));
//        System.out.println(new _148_排序链表().sortList1(listNode));
    }
}
