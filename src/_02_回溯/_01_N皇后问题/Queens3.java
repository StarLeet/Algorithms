package _02_回溯._01_N皇后问题;

/**
 * @ClassName Queens3
 * @Description  八皇后问题——位运算二次优化
 * @Author StarLee
 * @Date 2021/12/27
 */

public class Queens3 {
    private static int[] queens;
    private static byte cols;  //8位代表8行,某位为1代表某行已经存在皇后
    private static short leftTop;  //同理
    private static short rightTop;  //同理
    private static int ways;

    public static void place8Queens() {
        queens = new int[8];
        place(0);
        System.out.println("8皇后一共有" + ways + "种摆法");
    }

    /**
     * 从第row行开始摆放皇后
     * @param row
     */
    private static void place(int row) {
        if (row == 8) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < 8; col++) {
            int cv = 1 << col;  // 00000001 00000010 00000011 ...
            if ((cols & cv) != 0) continue; //col列已经有皇后

            int lv = 1 << (row - col + 7);
            if ((leftTop & lv) != 0) continue;

            int rv = 1 << (row + col);
            if ((rightTop & rv) != 0) continue;

            queens[row] = col;
            cols |= cv;
            leftTop |= lv;
            rightTop |= rv;
            place(row + 1);
            cols &= ~cv;
            leftTop &= ~lv;
            rightTop &= ~rv;
        }
    }

    private static void show() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (queens[row] == col) {
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
