package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/meeting-rooms/

import java.util.Arrays;

/**
 * @ClassName _252_会议室
 * @Description
 * @Author StarLee
 * @Date 2022/1/23
 */
@SuppressWarnings("all")
public class _252_会议室 {
    /**
     * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)
     * 请你判断一个人是否能够参加这里面的全部会议
     * 输入: [[0,30],[5,10],[15,20]]
     * 输出: false
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;

        // 按照会议的开始时间，从小到大排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        // 遍历每一个会议
        for (int i = 1; i < intervals.length; i++) {
            // 如果后一个会议开始了，前一个还没结束，返回false
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }

        return true;
    }
}
