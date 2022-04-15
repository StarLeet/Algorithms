package _99_代码随想录;

import java.util.*;

/**
 * @ClassName _146_LRU缓存
 * @Description
 * @Author StarLee
 * @Date 2022/4/15
 */

public class _146_LRU缓存 {
    class LRUCache{
        Map<Integer,Page> hashMap;
        int capacity;
        int size;
        Page deque;  // 队头
        public LRUCache(int capacity) {
            this.capacity = capacity;
            hashMap = new HashMap<>();
            deque = new Page(-1,-1);
            deque.next = deque;
            deque.prev = deque;
        }
        // 如果存在返回,不存在返回-1  更新页面
        public int get(int key) {
            Page p = hashMap.get(key);
            if (p == null) return -1;
            updatePage(p);
            return p.value;
        }
        // 如果存在覆盖,如果不存在判断是否满了,满了逐出最后的
        public void put(int key, int value) {
            Page p = hashMap.get(key);
            if (p != null){
                p.value = value;
                updatePage(p);
                return;
            }else if (size == capacity){ // 逐出
                Page oldTail = deque.prev;
                hashMap.remove(oldTail.key);
                Page newTail = oldTail.prev;
                newTail.next = deque;
                deque.prev = newTail;
            }else {
                size++;
            }
            // 创建新的缓存页
            Page page = new Page(key, value);
            hashMap.put(key,page);
            page.prev = deque;
            page.next = deque.next;
            deque.next.prev = page;
            deque.next = page;
        }
        private void updatePage(Page p){
            if (p.prev == deque) return;
            // 从原位置移除
            p.prev.next = p.next;
            p.next.prev = p.prev;
            // 插入队头
            p.next = deque.next;
            p.prev = deque;
            deque.next.prev = p;
            deque.next = p;
        }

        class Page{
            int key;
            int value;
            Page prev;
            Page next;

            public Page(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
