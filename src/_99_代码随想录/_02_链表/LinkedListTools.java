package _99_代码随想录._02_链表;

import 算法面试._02_链表操作.ListNode;

import java.util.Collection;

/**
 * @ClassName CreateLinkedList
 * @Description
 * @Author StarLee
 * @Date 2022/5/9
 */
public class LinkedListTools {
    /**
     *  创建一个长度为length,值为[min,min+range)的链表
     */
    public static ListNode create(int length, int min, int range){
        if (length < 1) throw new IllegalArgumentException("length不可小于1");
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (length-- > 0){
            int val = (int)(min + Math.random() * range);
            ListNode newNode = new ListNode(val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode;
        }
        return head.next;
    }

    /**
     *  由数组建立链表
     */
    public static ListNode create(int[] arr){
        if (arr.length < 1) throw new IllegalArgumentException("数组个数不可小于1");
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i : arr) {
            ListNode newNode = new ListNode(i);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode;
        }
        return head.next;
    }

    /**
     *  获取链表中间节点
     */
    public static ListNode midListNode(ListNode head){
        if (head == null || head.next == null) return head;
        /*      s f      s f
                1 2    1 2 3
         */
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     *  链表翻转
     */
    public static ListNode revert(ListNode head){
        return revertN(head,0);
    }

    public static ListNode revertN(ListNode head, int number){
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur;
        if (number == 0){
            pre = new ListNode(-1);
            cur = head;
        }else {
            int i = 1;
            while (i++ < number){
                if (pre.next == null) throw new RuntimeException("链表长度小于设置长度");
                pre = pre.next;
            }
            cur = pre.next;
            pre.next = null;
        }
        //  1 3 2 | 1 2 3
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return number == 0 ? pre.next : head;
    }


    public static ListNode sort(ListNode head){
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode mid = midListNode(head);
        ListNode prev = mid;
        mid = mid.next;
        prev.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left,right);
    }

    /**
     *  合并两个链表
     */
    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return newHead.next;
    }
}
