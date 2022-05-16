package _99_代码随想录._02_链表;

import 算法面试._02_链表操作.ListNode;

/**
 * @ClassName _707_设计链表
 * @Description
 * @Author StarLee
 * @Date 2022/4/15
 */
@SuppressWarnings("all")
public class _707_设计链表 {
    static class MyLinkedList {
        private ListNode head;
        private ListNode tail;
        private int size;
        public MyLinkedList() {
            head = new ListNode(Integer.MIN_VALUE);
            tail = head;
        }

        public int get(int index) {
            ListNode node = getNode(index);
            return node == null ? -1 : node.val;
        }

        private ListNode getNode(int index){
            if (index >= size || index < 0) return null;
            ListNode first = head.next;
            for (int i = 0; i < index; i++) {
                first = first.next;
            }
            return first;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            ListNode newNode = new ListNode(val);
            ListNode prev;
            if (index <= 0){
                prev = head;
            }else if (index == size){
                prev = tail;
                tail = newNode;
            }else {
                prev = getNode(index - 1);
            }
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
            if (size == 1) tail = newNode;

        }

        public void deleteAtIndex(int index) {
            if (size == 0 || index >= size) return;
            ListNode prev;
            if (index == 0){
                prev = head;
            }else {
                prev = getNode(index - 1);
            }
            if (index == size - 1){
                tail = prev;
            }
            prev.next = prev.next.next;
            size--;
        }
    }

    public static void main(String[] args) {

    }
}
