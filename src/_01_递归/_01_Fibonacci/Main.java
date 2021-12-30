package _01_递归._01_Fibonacci;

import _0_Tools.CountTimes;

/**
 * @ClassName Main
 * @Description
 * @Author StarLee
 * @Date 2021/12/26
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
		int n = 30;
		CountTimes.test("fib0", () -> {
			System.out.println(Fibonacci.fib0(n));
		});
		CountTimes.test("fib1", () -> {
			System.out.println(Fibonacci.fib1(n));
		});
		CountTimes.test("fib2", () -> {
			System.out.println(Fibonacci.fib2(n));
		});
		CountTimes.test("fib3", () -> {
			System.out.println(Fibonacci.fib3(n));
		});
		CountTimes.test("fib4", () -> {
			System.out.println(Fibonacci.fib4(n));
		});
		CountTimes.test("fib5", () -> {
			System.out.println(Fibonacci.fib5(n));
		});
		CountTimes.test("fib6", () -> {
			System.out.println(Fibonacci.fib6(n));
		});
    }
}
