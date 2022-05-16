package Java_Detail;

/**
 * @ClassName Final_Return
 * @Description 综合下面示例来看,只有两种情况 finally中有return语句,以及finally中没有return语句
 * @Author StarLee
 * @Date 2022/5/14
 */
public class Final_Return {
    // 从f1到f4可见,catch和finally中同时有return语句,其中之一的return会被优化掉,返回的值综合考虑catch和finally的操作
    @SuppressWarnings("all")
    private static int f1(){
        System.out.println("");
        try {
            int a = 5 / 0;
        } catch (Exception e) {
            return 10;
        } finally {
            return -10;
        }
        /*  反编译后
        try {
            int var0 = 5 / 0;
            return -10;
        } catch (Exception var5) {
            boolean var1 = true;
            return -10;
        } finally {
            ;
        }
         */
    }
    @SuppressWarnings("all")
    private static int f2(){
        int i = 0;
        try {
            i = 5 / 0;
        } catch (Exception e) {
            return i;
        } finally {
            i++;
            return i;
        }
        /*  反编译后
        try {
            i = 5 / 0;
        } catch (Exception var6) {
        } finally {
            ++i;
            return i;
        }
         */
    }
    @SuppressWarnings("all")
    private static int f3(){
        int i = 0;
        try {
            i = 5 / 0;
        } catch (Exception e) {
            return i++;
        } finally {
            return i;
        }
        /*
        try {
            int i;
            try {
                i = 5 / 0;
                return i;
            } catch (Exception var6) {
                i = var0 + 1;
                return i;
            }
        } finally {
            ;
        }
         */
    }
    @SuppressWarnings("all")
    private static int f4(){
        int i = 0;
        try {
            i = 5 / 0;
            i = 100;
        } catch (Exception e) {
            return ++i;
        } finally {
            return ++i;
        }
        /*
        try {
            i = 5 / 0;
            i = 100;
        } catch (Exception var6) {
            ++i;
        } finally {
            ++i;
            return i;
        }
         */
    }

    /**
     * a1 和 a2可以看出来,如果finally中不存在return,那么finally中对i的操作都是无效的,JVM会用一个变量来存储
     * 旧值，返回也返回的旧值
     */
    private static int a1(){
        int i = 0;
        try {
            i = 5 / 0;
            i = 100;
            return i;
        } catch (Exception e) {
            return ++i;
        } finally {
            ++i;
        }
        /*
        try {
            i = 5 / 0;
            i = 100;
            int var1 = i;
            return var1;
        } catch (Exception var6) {
            ++i;
            var2 = i;
        } finally {
            ++i;
        }
        return var2;
         */
    }

    private static int a2(){
        int i = 0;
        try {
            i = 100;
            return i;
        } catch (Exception e) {
            return ++i;
        } finally {
            ++i;
        }
        /*
        try {
            i = 100;
            int var1 = i;
            return var1;
        } catch (Exception var6) {
            ++i;
            var2 = i;
        } finally {
            ++i;
        }

        return var2;
         */
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
        f4();
        a1();
        a2();
    }
}
