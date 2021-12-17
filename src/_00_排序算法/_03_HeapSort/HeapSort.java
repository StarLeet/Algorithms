package _00_排序算法._03_HeapSort;

/**
 * @ClassName HeapSort
 * @Description  堆排序,选择排序的优化;大顶堆堆顶跟数组最后一个交换位置
 * @Author StarLee
 * @Date 2021/12/8
 */
@SuppressWarnings("all")
public class HeapSort {
    private static int heapSize; // 堆大小
    private static Integer[] heapArray;
    public static void sort(Integer[] array) {
        heapArray = array;
        // 1. 原地建堆（自下而上的下滤）
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
        int tmp = 0;
        while (heapSize > 1) {
            // 2. 交换堆顶元素和尾部元素
            tmp = heapArray[0];
            heapArray[0] = heapArray[--heapSize];
            heapArray[heapSize] = tmp;
            // 对0位置进行siftDown（恢复堆的性质）
            siftDown(0);
        }
    }

    /**
     *  @MethodName siftDown
     *  @Description  堆的下滤操作
     *  @Param [index]
     *  @return void
     */
    private static void siftDown(int index) {
        Integer element = heapArray[index];

        int half = heapSize >> 1;
        while (index < half) { // index必须是非叶子节点
            // 默认是左边跟父节点比
            int childIndex = (index << 1) + 1;
            Integer child = heapArray[childIndex];

            int rightIndex = childIndex + 1;
            // 右子节点比左子节点大
            if ((rightIndex < heapSize) &&
                    (heapArray[rightIndex] > child)) {
                child = heapArray[childIndex = rightIndex];
            }

            // 大于等于子节点
            if (element >= child) break;

            heapArray[index] = child;
            index = childIndex;
        }
        heapArray[index] = element;
    }
}
