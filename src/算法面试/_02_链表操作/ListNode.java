package 算法面试._02_链表操作;

/**
 * @ClassName ListCode
 * @Description  力扣链表节点
 * @Author StarLee
 * @Date 2022/1/8
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "——>" + next;
    }
}
