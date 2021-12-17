package _00_排序算法._01_BubbleSort;

/**
 * @ClassName BubbleSort
 * @Description  冒泡排序,从头到尾,将大的换到后面,每轮可以确定一个最大值
 * @Author StarLee
 * @Date 2021/12/8
 */
@SuppressWarnings("all")
public class BubbleSort {
    /**
     *  @MethodName sort
     *  @Description  未优化的冒泡排序
     */
    public static void sort(Integer[] array){
        int tmp = 0;
        /*
        *  每一轮外for可以确定一个最大值,并将其固定在endIndex的位置
        *  被固定的元素不需要再跟其他元素比较(意味着可以被"忽略"),所以endIndex要--
        * */
        for (int endIndex = array.length - 1; endIndex > 0; endIndex--) {
            // 迭代地比较两个相邻索引的元素(1-2,2-3,3-4...),将元素较大地往后交换
            for (int cmpIndex = 1; cmpIndex <= endIndex; cmpIndex++) {
                if (array[cmpIndex-1] > array[cmpIndex]){
                    tmp = array[cmpIndex];
                    array[cmpIndex] = array[cmpIndex-1];
                    array[cmpIndex-1] = tmp;
                }
            }
        }
    }

    /***
     *  冒泡排序优化
     *  引入标记,如果最后范围的值出现局部有序,则记录最开始有序的下标
     */
    public static void sortCheckSorted(Integer[] array){
        int tmp = 0;
        for (int endIndex = array.length - 1; endIndex > 0; endIndex--) {
            int headSortedIndex = 1; // 标记记录有序部分的第一个元素索引
            for (int cmpIndex = 1; cmpIndex <= endIndex; cmpIndex++) {
                if (array[cmpIndex-1] > array[cmpIndex]){
                    tmp = array[cmpIndex];
                    array[cmpIndex] = array[cmpIndex-1];
                    array[cmpIndex-1] = tmp;
                    headSortedIndex = cmpIndex;  // 当前比较中,大的值被交换到cmpIndex
                    //如果往后都是有序的>array[cmpIndex],那就说明有序部分的head是cmpIndex
                }
            }
            endIndex = headSortedIndex;  //此句之后endIndex--,headSortedIndex的元素被忽略
            //在全排序队列中,endIndex被直接赋值1,然后endIndex--直接退出外循环
        }
    }
}
