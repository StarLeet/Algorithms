package _99_代码随想录._01_数组.螺旋矩阵;

/**
 * @ClassName 剑指Offer_29_顺时针打印矩阵
 * @Description
 * @Author StarLee
 * @Date 2022/4/15
 */

public class 剑指Offer_29_顺时针打印矩阵 {
    /**      l   r
     *       1 2 3
     *    t  4 5 6
     *    b  7 8 9
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int totalLen = matrix[0].length * matrix.length;
        int[] result = new int[totalLen];
        totalLen = 0;
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom && left <= right){
            // 右
            for (int i = left; i <= right; i++) {
                result[totalLen++] = matrix[top][i];
            }
            top++;
            // 下
            for (int i = top; i <= bottom; i++) {
                result[totalLen++] = matrix[i][right];
            }
            right--;
            if (top > bottom || left > right) break;
            // 左
            for (int i = right; i >= left; i--) {
                result[totalLen++] = matrix[bottom][i];
            }
            bottom--;
            // 上
            for (int i = bottom; i >= top; i--) {
                result[totalLen++] = matrix[i][left];
            }
            left++;
        }
        return result;
    }
}
