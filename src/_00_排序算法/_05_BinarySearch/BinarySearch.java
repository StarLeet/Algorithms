package _00_排序算法._05_BinarySearch;

/**
 * @ClassName BinarySearch
 * @Description  二分查找
 * @Author StarLee
 * @Date 2021/12/10
 */
@SuppressWarnings("all")
public class BinarySearch {
    private final Integer[] array;

    public BinarySearch(Integer[] array) {
        this.array = array;
    }

    /**
     *  普通的二分查找,找出元素在数组中的索引
     *  为了增强编程体验,建议将区间设置成左闭右开的形式 [begin,end),比如下示例
     *     begin                        end
     *  索引  0   1   2   3   4   5   6  7
     *  元素  1   3   4   7   7   8  11
     */
    public int indexOf(int value){
        if (array == null || array.length == 0) return -1;
        int beginIndex = 0;
        int endIndex = array.length;  // 设置左闭右开的区间[begin,end)
        while(beginIndex < endIndex){  // 假如等于,则为[begin,begin)不存在元素
            int middle = (beginIndex + endIndex) >> 1; // (begin + end) / 2
            if (value < array[middle]){
                // 小于找左边
                endIndex = middle;    // 区间设置的好处,直接赋值middle
            }else if (value > array[middle]){
                // 大于找右边
                beginIndex = middle + 1;
            }else {
                // 剩下等于的情况
                return middle;
            }
        }

        return -1;
    }

    /**
     *  @MethodName getIndexForSort
     *  @Description  为插入排序寻找合适的插入索引
     *  核心思想:为了维护算法的稳定性(多个相等元素保持原有位置),应寻找第一个比自己大的值返回其索引
     *  @Param [index]
     *  @return int
     */
    public int searchIndex(int index) {  // index == unsortedIndex
        if (array == null || array.length == 0) return -1;
        // 1. 进行正常二分查找
        int beginIndex = 0;
        int endIndex = index;  // 2. 不同之处,插入区间在[0,beginIndex)
        while (beginIndex < endIndex) {
            int middle = (beginIndex + endIndex) >> 1;
            if (array[index] < array[middle]) {
                //小于找左边
                endIndex = middle;
            } else {
                //大于等于找右边
                beginIndex = middle + 1;
            }
        }
        return beginIndex;   // 返回endIndex也可以,到这里的只有一种情况【begin == end】
        /*
         *   begin   end
         *     7      8
         *     6     10
         *  假如array[index] >= 6, 则 begin = (7 + 8) / 2 + 1 = 8
         *  假如array[index] < 6, 则 end = (7 + 8) / 2 = 7
         *  一旦二者相同则出现区间[a,a),此区间本身就为空,同时也符合while退出条件
         * */
    }
}
