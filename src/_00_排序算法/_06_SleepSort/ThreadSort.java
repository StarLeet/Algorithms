package _00_排序算法._06_SleepSort;

/**
 * @ClassName ThreadSort
 * @Description  二逼排序,时间复杂度O(n),了解就行
 * @Author StarLee
 * @Date 2021/12/11
 */

public class ThreadSort extends Thread{
    public int value;
    public ThreadSort(int value) {
        this.value = value;
    }
    public void run(){
        try{
            Thread.sleep(value);
            System.out.println(value);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int [] array = {10, 100, 50, 30, 60, 61, 64, 47,79, 59, 11000};
        for (int element : array) {
            new ThreadSort(element).start();
        }

    }
}
