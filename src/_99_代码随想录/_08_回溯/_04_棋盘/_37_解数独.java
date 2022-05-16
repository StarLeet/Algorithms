package _99_代码随想录._08_回溯._04_棋盘;

/**
 * @ClassName _37_解数独
 * @Description  单独求一行是很简单的,无非是组合问题,找出一行的所有满足情况,在得到一种满足情况后
 *               递归终止，并调用dfsCol进入下一行继续找
 * @Author StarLee
 * @Date 2022/5/15
 */
public class _37_解数独 {
    private char[][] board;
    private boolean[][] colContain;  // 行为行号,列为值,值为1表示当前数字在该行存在
    private boolean[][] rowContain;
    private boolean[][] areaContain;  // 3×3中有无该元素

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        this.board = board;
        colContain = new boolean[9][9];
        rowContain = new boolean[9][9];
        areaContain = new boolean[9][9];
        // 初始化存在数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                setContainArray(i,j,board[i][j] - '1',true);
            }
        }
        // 从当前行开始找答案
        dfsCol(0);
    }

    private boolean dfsCol(int curDepth){
        // 找到一组答案,中断回溯
        if (curDepth == board.length) return true;
        // 没到最后一行,需要进入下一行继续找
        return dfsRow(curDepth,0);
    }

    private boolean dfsRow(int curDepth, int curWidth){
        // 含有数字的位置要跳过
        while (curWidth < board[curDepth].length && board[curDepth][curWidth] != '.'){
            curWidth++;
        }
        // 回溯到列尾，应该进入到下一行继续找
        if (curWidth == board[curDepth].length) {
            return dfsCol(curDepth + 1);
        }
        for (char i = '1'; i <= '9'; i++) {
            int val = i - '1';
            if (!isValid(curDepth,curWidth,val)) continue;
            board[curDepth][curWidth] = i;
            setContainArray(curDepth,curWidth,val,true);
            if (dfsRow(curDepth,curWidth + 1)) return true;
            // 回溯
            board[curDepth][curWidth] = '.';
            setContainArray(curDepth,curWidth,val,false);
        }
        return false;
    }

    private void setContainArray(int col, int row, int val, boolean bool){
        colContain[col][val] = bool;
        rowContain[row][val] = bool;
        // 行应该 * 3 与列是不一样的
        areaContain[(col / 3 * 3) + row / 3][val] = bool;
    }

    private boolean isValid(int col, int row, int val){
        // 判断行不重复
        if (colContain[col][val]) return false;
        // 判断列不重复
        if (rowContain[row][val]) return false;
        //判断3×3不重复
        return !areaContain[(col / 3 * 3) + row / 3][val];
    }

    private static void display(char[][] board){
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new _37_解数独().solveSudoku(board);
        display(board);
    }
}
