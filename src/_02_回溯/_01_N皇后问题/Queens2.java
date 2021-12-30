package _02_回溯._01_N皇后问题;

/**
 * @ClassName Queens2
 * @Description  八皇后问题——进阶优化
 * @Author StarLee
 * @Date 2021/12/27
 */
@SuppressWarnings("all")
public class Queens2 {
    // 数组索引是行号，数组元素是列号(打印之用)
    private static int[] queens;
    // 标记着某一列是否有皇后
    private static boolean[] cols;
    // 标记着某一斜线上是否有皇后(左上角 -> 右下角)
    private static boolean[] leftTop;
    // 标记着某一斜线上是否有皇后(右上角 -> 左下角)
    private static boolean[] rightTop;
    //一共有多少种摆法
    private static int ways;

    /**
     *  n皇后算法起始
     */
    public static void placeQueens(int n) {
        if (n < 1) return;
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    /**
     * 从第row行开始摆放皇后
     */
    public static void place(int row) {
        // 如果已经放到第n行,说明找到了一种n皇后的摆法
        if (row == cols.length) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) continue; // 第col列已经有皇后, 继续下一轮
            int ltIndex = row - col + cols.length - 1; //计算所在正对角线索引
            if (leftTop[ltIndex]) continue; //正对角线存在后,继续下一轮
            int rtIndex = row +col;  //计算所在反对角线索引
            if (rightTop[rtIndex]) continue; //反对角线存在后,继续下一轮
            // 在打印棋盘中标记该点
            queens[row] = col;
            // 更新行、列、正反对角线的信息
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            // 进行回溯,还原摆放前的信息
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    private static void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (queens[row] == col) { //
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
