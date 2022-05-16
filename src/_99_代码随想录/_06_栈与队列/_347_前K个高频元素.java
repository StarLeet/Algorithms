package _99_代码随想录._06_栈与队列;

import java.util.*;

/**
 * @ClassName _347_前K个高频元素
 * @Description
 * @Author StarLee
 * @Date 2022/5/3
 */
public class _347_前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length <= k) return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // [出现次数|数字]
        int[][] nodes = new int[map.entrySet().size()][2];
        int size = 0;
        // 将数据从map中移出来,便于快选的进行
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nodes[size][0] = entry.getValue();
            nodes[size][1] = entry.getKey();
            size++;
        }
        quickSelect(nodes,0,nodes.length,k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nodes[nodes.length - k + i][1];
        }
        return result;
    }
    // 快选法：快速排序 + 减治思想(跟二分查找类似)
    private void quickSelect(int[][] nodes, int left, int right, int k){
        if (right - left < 2) return;
        int pointIndex = findIndex(nodes,left,right);
        // 可以确定的最大值的数量
        int rightPartNum = nodes.length - pointIndex;
        // 这里的道理是跟二分查找一样的
        if (rightPartNum < k){  // 最大值数量小于k,继续往左找
            quickSelect(nodes,left,pointIndex,k);
        }else {
            quickSelect(nodes,pointIndex + 1,right,k);
        }
    }
    // 此处逻辑依旧是快选的
    private int findIndex(int[][] arr, int left, int right){
        int random = left + (int)(Math.random() * (right - left));
        int[] selectedInt = arr[random];
        arr[random] = arr[left];
        arr[left] = selectedInt;
        right--;
        while (left < right){
            while (left < right){
                if (arr[right][0] > selectedInt[0]){
                    right--;
                }else {
                    arr[left++] = arr[right];
                    break;
                }
            }
            while (left < right){
                if (arr[left][0] < selectedInt[0]){
                    left++;
                }else {
                    arr[right--] = arr[left];
                    break;
                }
            }
        }
        arr[left] = selectedInt;
        return left;
    }

    // 优先队列实现 本质是小顶堆
//    public int[] topKFrequent(int[] nums, int k) {
//        if (nums == null || nums.length <= k) return nums;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (priorityQueue.size() == k){
//                if (entry.getValue() < priorityQueue.peek().getValue()) continue;
//                priorityQueue.poll();
//                priorityQueue.add(entry);
//            }else {
//                priorityQueue.add(entry);
//            }
//        }
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = priorityQueue.poll().getKey();
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        new _347_前K个高频元素().topKFrequent(arr,2);
    }
}
