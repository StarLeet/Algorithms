package 算法面试._09_高频题;
 // https://leetcode-cn.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _54_螺旋矩阵
 * @Description
 * @Author StarLee
 * @Date 2022/1/19
 */

public class _54_螺旋矩阵 {
    /**
     * 给你一个m行n列的矩阵matrix，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        /*
        *      1 2 3
        *  top 4 5 6
        *  bom 7 8 9
        *      l r
        *  // 到最后只有两种情况,只剩一行,只剩2行(正好遍历完退出)  只剩一行的需要 top <= bottom 判断退出
        *  // 或者单列 只剩一列的需要 left <= right 判断退出
        */
        List<Integer> result = new ArrayList<>();
        int top = 0,bottom = matrix.length - 1;
        int left = 0,right = matrix[0].length - 1;
        while (top <= bottom && left <= right){
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // 应对行为奇数的情况 || 列为1、2行的情况
            if (top > bottom || left > right) break;
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
