package _0_Tools;

/**
 * @ClassName Asserts
 * @Description  断言式测试接口
 * @Author StarLee
 * @Date 2021/12/8
 */

public class Asserts {
    public static void test(boolean value) {
        try {
            if (!value) throw new Exception("测试未通过");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
