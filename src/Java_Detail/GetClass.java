package Java_Detail;

import java.util.ArrayList;

/**
 * @ClassName GetClass
 * @Description
 * @Author StarLee
 * @Date 2022/5/14
 */
public class GetClass {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println(list1.getClass() == list2.getClass());  // true 泛型擦除
        /*
            Java泛型并不是真正意义上的泛型,只不过是Java为编译器做的安全检查机制
            ArrayList<Integer>与ArrayList<String>在编译时,虽然同属于ArrayList类型
            但是因为打上了不同的标记,编译器会将其视为两个不同对象,进而做到同一类型的区分

            如果在ArrayList<Integer>中加入String类型会被认为类型错误,因为在编译时编译器看的是它们的标签
            这样就可以保证ArrayList<Integer>中只能放Integer类型

            在安全检查过后,标签被撕掉,即泛型擦除.没了标签二者又回归同一个对象类型了
            所以我们用getClass获取两者Class对象其实得到的是同一个
         */
    }
}
