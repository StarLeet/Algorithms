package _99_代码随想录._01_数组.螺旋矩阵;

/**
 * @ClassName _59_螺旋矩阵II
 * @Description
 * @Author StarLee
 * @Date 2022/4/15
 */

public class _59_螺旋矩阵II {
    /**      l   r
     *    t  1 2 3
     *       8 9 4
     *    b  7 6 5
     *
     *        l        r
     *    t   1  2  3  4
     *       12 13 14  5
     *       11 16 15  6
     *    b  10  9  8  7
     */
    public int[][] generateMatrix(int n) {
        if (n <= 0) return null;
        int[][] result = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int count = 1;
        while (top <= bottom && left <= right){
            int l = left;
            while (l <= right){
                result[top][l++] = count++;
            }
            top++;
            // 难点！！！
            if (top > bottom) break;
            int t = top;
            while (t <= bottom){
                result[t++][right] = count++;
            }
            right--;
            if (left > right) break;
            int r = right;
            while (r >= left){
                result[bottom][r--] = count++;
            }
            bottom--;
            int b = bottom;
            while (b >= top){
                result[b--][left] = count++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        _59_螺旋矩阵II v = new _59_螺旋矩阵II();
        v.generateMatrix(3);
    }
}
