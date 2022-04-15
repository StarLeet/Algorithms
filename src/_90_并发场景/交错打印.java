package _90_并发场景;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Test
 * @Description
 * @Author StarLee
 * @Date 2022/4/5
 */

public class 交错打印 {
    private static int cur = 0;
//    private static final Object lock = new Object();
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    public static void main(String[] args) {
        String s = "dhskjacbnmzxcjkdhska";
        final int l = s.length();
        new Thread(() -> {
            lock.lock();
            while (cur < l) {
                System.out.println(s.charAt(cur++));
                condition.signal();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signal();
            lock.unlock();
        }).start();
        new Thread(() -> {
            lock.lock();
            while (cur < l) {
                System.out.println(s.charAt(cur++));
                condition.signal();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signal();
            lock.unlock();
        }).start();
//        new Thread(()->{
//            synchronized (lock){
//                while (cur < l){
//                    System.out.println(s.charAt(cur++));
//                    lock.notify();
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                lock.notify();
//            }
//        }).start();
//        new Thread(() ->{
//            synchronized (lock){
//                while (cur < l){
//                    System.out.println(s.charAt(cur++));
//                    lock.notify();
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                lock.notify();
//            }
//        }).start();
    }
}
