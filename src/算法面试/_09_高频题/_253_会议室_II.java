package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/meeting-rooms-ii/

import java.util.Arrays;

/**
 * @ClassName _253_会议室_II
 * @Description
 * @Author StarLee
 * @Date 2022/1/23
 */

public class _253_会议室_II {
    /**
     * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)
     * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排
     * 示例 1:
     * 输入: [[0, 30],[5, 10],[15, 20]]
     * 输出: 2
     * 示例 2:
     * 输入: [[7,10],[2,4]]
     * 输出: 1
     */
    // 双指针
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 存放所有会议的开始时间
        int[] begins = new int[intervals.length];
        // 存放所有会议的结束时间
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // 排序
        Arrays.sort(begins);
        Arrays.sort(ends);

        int room = 0, endIdx = 0;
        for (int begin : begins) {
            if (begin >= ends[endIdx]) { // 能重复利用会议室
                endIdx++;
            } else { // 需要新开一个会议室
                room++;
            }
        }

        return room;
    }
}
