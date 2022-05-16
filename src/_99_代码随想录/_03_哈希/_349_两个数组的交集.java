package _99_代码随想录._03_哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName _349_两个数组的交集
 * @Description
 * @Author StarLee
 * @Date 2022/4/18
 */

public class _349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> containKey = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (!set.contains(i)) continue;
            containKey.add(i);
        }
        int[] result = new int[containKey.size()];
        int i = 0;
        for (Integer integer : containKey) {
            result[i++] = integer;
        }
        return result;
    }
}
