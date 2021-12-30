package _02_回溯._01_N皇后问题;

/**
 * @ClassName Queens1
 * @Description 八皇后问题——基本实现
 * @Author StarLee
 * @Date 2021/12/27
 */

public class Queens1 {
    // cols[row] = col; 表示第row行第col列摆放了皇后
    private static int cols[];
    // 一共有多少种合理的摆法
    private static int ways = 0;

    /**
     *  回溯:回溯特别像是图的深度遍历,一条路走到底,没路了还原上一次步骤(最近岔路口)继续走另一条
     *  n皇后
     */
    public static void placeQueens(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0); // 从第0行开始摆放皇后
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }
    /**
     * 从第 row 行开始摆放皇后
     */
    private static void place(int row) {
        // 如果已经放到第n行,说明找到了一种n皇后的摆法
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        // 不断的for循环其实就是一种回溯,在place(row + 1)执行完后,现场总会还原到place(row)
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {  // 剪枝操作,当isValid()为false时,place(row + 1)不执行
                cols[row] = col;  // 在第row行第col列摆放皇后
                place(row + 1);
            }
        }
    }

    /**
     * 判断第row行第col列是否可以摆放皇后
     * 判断依据是：所在行、列、正反对角线有无其他皇后存在
     */
    private static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后
            if (cols[i] == col) {
                //System.out.println("["+ row + "][" + col + "]=false");  //显示回溯细节
                return false;
            }
            // 第i行的皇后同第row行第col列格子处在同一斜线上
            // 45度角斜线: y-y0 = (x-x0), 则 (y-y0)/(x-x0) = 1, 表示为45度角的斜线
            if (row - i == Math.abs(col - cols[i])) {
                //System.out.println("["+ row + "][" + col + "]=false"); //显示回溯细节
                return false;
            }
        }
        //System.out.println("["+ row + "][" + col + "]=true");  //显示回溯细节
        return true;
    }

    private static void show() {  // 打印棋盘
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) { // 摆放了皇后
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
