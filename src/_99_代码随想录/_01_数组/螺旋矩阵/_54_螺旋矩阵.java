package _99_代码随想录._01_数组.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _54_螺旋矩阵
 * @Description
 * @Author StarLee
 * @Date 2022/4/15
 */

public class _54_螺旋矩阵 {
    /**     l   r
     *   t  1 2 3
     *      4 5 6
     *   b  7 8 9
     *  // 到最后只有两种情况,只剩一行,只剩2行(正好遍历完退出)  只剩一行的需要 top <= bottom 判断退出
     *  // 或者单列 只剩一列的需要 left <= right 判断退出
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom && left <= right){
            // 右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;
            // 下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            // 左
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            //上
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
