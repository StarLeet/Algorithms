package _00_排序算法整合;

import _00_排序算法整合._01_CompareSort.SelectionSort;
import _00_排序算法整合._01_CompareSort.ShellSort;
import _00_排序算法整合._02_OthersSort.CountingSort;
import _00_排序算法整合._02_OthersSort.RadixSort;

import java.text.DecimalFormat;

/**
 * @ClassName AbstractSort
 * @Description  抽象排序父类
 * @Author StarLee
 * @Date 2021/12/8
 */

public abstract class AbstractSort<T extends Comparable<T>>
        implements Comparable<AbstractSort<T>>{
    protected T[] array;
    private int cmpCount;  //比较次数
    private int swapCount;  // 交换次数
    private long time;
    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(T[] array) {
        if (array == null || array.length < 2) return;

        this.array = array;

        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    @Override
    public int compareTo(AbstractSort<T> o) {
        int result = (int)(time - o.time);
        if (result != 0) return result;

        result = cmpCount - o.cmpCount;
        if (result != 0) return result;

        return swapCount - o.swapCount;
    }

    protected abstract void sort();

    /*
     * 返回值等于0，代表 array[i1] == array[i2]
     * 返回值小于0，代表 array[i1] < array[i2]
     * 返回值大于0，代表 array[i1] > array[i2]
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }

    protected int cmp(T v1, T v2) {
        cmpCount++;
        return v1.compareTo(v2);
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        T tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        String stableStr = "稳定性：" + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + " \t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";
    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }

    /**
     *  @MethodName isStable
     *  @Description  判断算法是否稳定
     *  @Param []
     *  @return boolean
     */
    private boolean isStable() {
        if (this instanceof RadixSort) return true;
        if (this instanceof CountingSort) return true;
        if (this instanceof ShellSort) return false;
        if (this instanceof SelectionSort) return false;

        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i * 10, 10);
        }
        sort((T[]) students);
        for (int i = 1; i < students.length; i++) {
            int score = students[i].score;
            int prevScore = students[i - 1].score;
            if (score != prevScore + 10) return false;
        }
        return true;
    }
}
