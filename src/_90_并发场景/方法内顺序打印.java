package _90_并发场景;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName 方法内顺序打印
 * @Description
 * @Author StarLee
 * @Date 2022/5/12
 */
public class 方法内顺序打印 {

}


class foo{
    private static AtomicInteger conut = new AtomicInteger();

    public static void first(){
        System.out.println("1");
        conut.incrementAndGet();
    }

    public static void second(){
        while (conut.get() != 1);
        System.out.println("2");
        conut.incrementAndGet();
    }

    public static void third(){
        while (conut.get() != 2);
        System.out.println("3");
        conut.incrementAndGet();
    }

    public static void main(String[] args) {
//        new Thread(foo::second).start();
//        new Thread(foo::third).start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(foo::first).start();
        testFinally();
    }

    public static int testFinally(){
        System.out.println("测试开始~~");
        try {
            Thread.sleep(100);
            System.out.println("继续执行");
        } catch (InterruptedException e) {
            System.out.println("进入catch块");
            return 10;
        }finally {
            System.out.println("进入finally");
            return -10;

        }

    }
}
