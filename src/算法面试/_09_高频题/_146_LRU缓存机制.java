package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/lru-cache/
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName _146_LRU缓存机制
 * @Description
 * @Author StarLee
 * @Date 2022/1/24
 */

public class _146_LRU缓存机制 { }
/**
 * 请你设计并实现一个满足LRU(最近最少使用)缓存约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity)以 正整数 作为容量capacity初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value
 * 如果不存在，则向缓存中插入该组key-value
 * 如果插入操作导致关键字数量超过capacity ，则应该逐出最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行
 */
class LRUCache {
    private int capacity;
    private Map<Integer,Node> hashmap;
    private Node head;  // 虚拟头结点
    private Node tail;  // 虚拟尾节点
    // 节点类
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key,int value) {
            this.value = value;
            this.key = key;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashmap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = hashmap.get(key);
        if (node == null) return -1;
        rmNode(node);
        addAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = hashmap.get(key);
        if (node != null) { // 如果key存在
            node.value = value;
            rmNode(node); // 更新链表
        } else { // 如果不存在,添加一对新的key-value
            if (hashmap.size() == capacity) { // 如果map容量已满
                // 淘汰最近最少使用的node
                rmNode(hashmap.remove(tail.prev.key));
            }
            hashmap.put(key, node = new Node(key, value));
        }
        addAfterHead(node);
    }
    private void rmNode(Node node){
        // 将node从原位置移除
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addAfterHead(Node node){
        // 将node插入head之后
        node.prev = head;
        node.next = head.next;
        // 维护head于head.next
        head.next.prev = node;
        head.next = node;
    }
}
