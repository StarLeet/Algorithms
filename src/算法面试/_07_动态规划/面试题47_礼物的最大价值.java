package 算法面试._07_动态规划;
// https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
/**
 * @ClassName 面试题47_礼物的最大价值
 * @Description
 * @Author StarLee
 * @Date 2022/1/14
 */

public class 面试题47_礼物的最大价值 {
    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     */
    public static int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        // 因为规定只能向下/向右,所以下一格的最大礼物价值只与上边/左边的格子有关联
        int[] topMax = new int[grid[0].length];  // 记录走到上边格子的最大礼物价值
        topMax[0] = grid[0][0];
        for (int i = 1; i < topMax.length; i++) {
            topMax[i] = grid[0][i] + topMax[i - 1];
        }
        for (int i = 1; i < grid.length; i++) {  // grid.length行
            int leftMax = 0;  // 记录走到左边格子的最大礼物价值
            for(int j = 0; j < grid[0].length; j++){  // grid[0].length列
                leftMax = Math.max(leftMax,topMax[j]) + grid[i][j];
                topMax[j] = leftMax;
            }
        }
        return topMax[topMax.length - 1];
    }

    public static void main(String[] args) {

    }
}
