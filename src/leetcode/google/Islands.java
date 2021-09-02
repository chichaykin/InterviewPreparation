package leetcode.google;

import org.junit.Assert;
import org.junit.Test;

public class Islands {
    int islands = 0;
    int rows = 0;
    int columns = 0;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (check(grid, i, j)) islands++;
            }
        }
        return islands;
    }

    boolean check(char[][] grid, int i, int j) {
        if (grid[i][j] != '1') return false;

        pass(grid, i, j);

        return true;
    }

    private void pass(char[][] grid, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= columns) return;
        if (grid[i][j] != '1') return;

        grid[i][j] = '2';

        pass(grid, i, j + 1);
        pass(grid, i + 1, j);
        pass(grid, i, j - 1);
        pass(grid, i - 1, j);
    }

    @Test
    public void test() {
        char[][] input = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Assert.assertEquals(1, numIslands(input));
    }


}
