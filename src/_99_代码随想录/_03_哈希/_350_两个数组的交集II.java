package _99_代码随想录._03_哈希;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName _350_两个数组的交集II
 * @Description
 * @Author StarLee
 * @Date 2022/4/18
 */

public class _350_两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        HashMap<Integer,Integer> mapNums1 = new HashMap<>();
        int[] prevResult = new int[Math.min(nums1.length, nums2.length)];
        for (int i : nums1) {
            if (mapNums1.containsKey(i)){
                mapNums1.put(i,mapNums1.get(i) + 1);
            }else {
                mapNums1.put(i,1);
            }
        }
        int count = 0;
        for (int i : nums2) {
            if (mapNums1.containsKey(i) && mapNums1.get(i) > 0){
                prevResult[count++] = i;
                mapNums1.put(i,mapNums1.get(i) - 1);
            }
        }
        return Arrays.copyOf(prevResult,count);
    }
}
