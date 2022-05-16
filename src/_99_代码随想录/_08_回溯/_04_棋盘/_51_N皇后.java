package _99_代码随想录._08_回溯._04_棋盘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _51_N皇后
 * @Description
 * @Author StarLee
 * @Date 2022/5/15
 */
public class _51_N皇后 {

    private List<List<String>> result;
    private int[] choose;  // 索引为行,值为列
    private char[][] chessBoard;  // 存棋盘来复用

    @SuppressWarnings("all")
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n <= 0 || n == 2 || n == 3) return result;
        choose = new int[n];
        chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }
        dfs(0);
        return result;
    }

    private void dfs(int curDepth){
        if (curDepth == choose.length){
            // choose转化为List
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < choose.length; i++) {
                chessBoard[i][choose[i]] = 'Q';
                strings.add(String.valueOf(chessBoard[i]));
                chessBoard[i][choose[i]] = '.';
            }
            result.add(strings);
            return;
        }
        /*
            0 1 0 0
            0 0 0 1
            1 0 0 0
            0 0 1 0
         */
        for (int i = 0; i < choose.length; i++) {
            if (!isValid(curDepth,i)) continue;
            choose[curDepth] = i;
            dfs(curDepth + 1);
        }
    }

    private boolean isValid(int col, int row){
        // 判断同列是否已经有
        for (int i = 0; i < col; i++) {
            if (choose[i] == row) return false;
        }
        // 判断正逆对角线是否已经有
        for (int i = 0; i < col; i++) {
            if (col - i == Math.abs(row - choose[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new _51_N皇后().solveNQueens(4);
    }
}
