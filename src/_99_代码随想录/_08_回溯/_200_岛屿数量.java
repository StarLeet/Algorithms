package _99_代码随想录._08_回溯;

import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName _200_岛屿数量
 * @Description
 * @Author StarLee
 * @Date 2022/4/20
 */

public class _200_岛屿数量 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int islandNum = 0, mark = '2';
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 发现新岛屿
                if (grid[i][j] == '1'){
                    islandNum++;
                    dfs(grid,i,j,(char)(mark++));
                }
            }
        }
        return islandNum;
    }

    private void dfs(char[][] grid, int row, int col, char mark){
        if (row < 0 || row == grid.length) return;
        if (col < 0 || col == grid[0].length) return;
        if (grid[row][col] != '1') return;
        grid[row][col] = mark;
        dfs(grid,row,col + 1,mark);
        dfs(grid,row + 1,col,mark);
        dfs(grid,row,col - 1,mark);
        dfs(grid,row - 1,col,mark);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','1','1'},{'0','1','0','1','0'},{'1','0','0','0','0'},{'0','0','0','1','1'}};
        _200_岛屿数量 v = new _200_岛屿数量();
        v.numIslands(grid);
        System.out.println();
    }
}
