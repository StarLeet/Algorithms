package _99_代码随想录._03_哈希;

import java.util.HashMap;

/**
 * @ClassName _454_四数相加II
 * @Description
 * @Author StarLee
 * @Date 2022/4/27
 */

public class _454_四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (!checkValid(nums1,nums2,nums3,nums4)) return 0;
        //   map{和值,出现次数}
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int v1 : nums1) {
            for (int v2 : nums2) {
                // 将nums1和nums2能够相加成的所有和,存入map中
                int sum = v1 + v2;
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }
        int count = 0;
        for (int v3 : nums3) {
            for (int v4 : nums4) {
                int otherSum = -(v3 + v4);
                count += map.getOrDefault(otherSum,0);
            }
        }
        return count;
    }

    private boolean checkValid(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        if (nums1 == null || nums1.length == 0) return false;
        if (nums2 == null || nums2.length == 0) return false;
        if (nums3 == null || nums3.length == 0) return false;
        return nums4 != null && nums4.length != 0;
    }
}
