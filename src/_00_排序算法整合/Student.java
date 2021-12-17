package _00_排序算法整合;

/**
 * @ClassName Student
 * @Description  鉴定稳定性的测试类
 * @Author StarLee
 * @Date 2021/12/11
 */

public class Student implements Comparable<Student>{
    public int score;
    public int age;

    public Student(int score, int age) {
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return age - o.age;
    }
}
