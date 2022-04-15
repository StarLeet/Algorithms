package _90_并发场景;

/**
 * @ClassName 死锁
 * @Description
 * @Author StarLee
 * @Date 2022/4/14
 */

public class 死锁 {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA){
                System.out.println("拿到A锁,等待B锁....");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.println("拿到B锁");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lockB){
                System.out.println("拿到B锁,等待A锁....");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA){
                    System.out.println("拿到A锁");
                }
            }
        }).start();
    }
}
