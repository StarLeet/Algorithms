package _99_代码随想录;

import java.util.ArrayList;

/**
 * @ClassName 下一个更大的数
 * @Description
 * @Author StarLee
 * @Date 2022/5/10
 */
public class 下一个更大的数 {
    // 1234 输入 1243
    // 3124
    private int nextLarger(int num){
        ArrayList<Integer> numbers = new ArrayList<>();
        int cur = num;
        while (cur > 0){
            numbers.add(cur % 10);
            cur /= 10;
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)){
                int tmp = numbers.get(i);
                numbers.set(i,numbers.get(i + 1));
                numbers.set(i + 1,tmp);
                break;
            }
        }
        int result = 0;
        for (int i = numbers.size() - 1; i >= 0; i--) {
            result = result * 10 + numbers.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 下一个更大的数().nextLarger(1342));
    }
}
