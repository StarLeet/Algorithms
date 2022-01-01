package _06_字符串匹配;

import _0_Tools.Asserts;

/**
 * @ClassName Main
 * @Description
 * @Author StarLee
 * @Date 2022/1/1
 */

public class Main {
    public static void main(String[] args) {
        Asserts.test(BruteForce01.indexOf("Hello World", "H") == 0);
        Asserts.test(BruteForce01.indexOf("Hello World", "d") == 10);
        Asserts.test(BruteForce01.indexOf("Hello World", "or") == 7);
        Asserts.test(BruteForce01.indexOf("Hello World", "abc") == -1);

        Asserts.test(BruteForce01.indexOf2("Hello World", "H") == 0);
        Asserts.test(BruteForce01.indexOf2("Hello World", "d") == 10);
        Asserts.test(BruteForce01.indexOf2("Hello World", "or") == 7);
        Asserts.test(BruteForce01.indexOf2("Hello World", "abc") == -1);

        Asserts.test(BruteForce02.indexOf("Hello World", "H") == 0);
        Asserts.test(BruteForce02.indexOf("Hello World", "d") == 10);
        Asserts.test(BruteForce02.indexOf("Hello World", "or") == 7);
        Asserts.test(BruteForce02.indexOf("Hello World", "abc") == -1);

        Asserts.test(KMP.indexOf("Hello World", "H") == 0);
        Asserts.test(KMP.indexOf("Hello World", "d") == 10);
        Asserts.test(KMP.indexOf("Hello World", "or") == 7);
        Asserts.test(KMP.indexOf("Hello World", "abc") == -1);
    }
}
