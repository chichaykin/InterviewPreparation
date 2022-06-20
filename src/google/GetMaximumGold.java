package google;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class GetMaximumGold {
    int columns;
    int rows;

    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        int max = 0;

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                if (grid[i][j] != 0) {
//                    max = Math.max(max, dfs(grid, i, j, new HashSet<>()));
//                }
//            }
//        }
        max = Math.max(max, max = Math.max(max, dfs(grid, 1, 0, new HashSet<>())));
        return max;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int dfs(int[][] grid, int i, int j, HashSet<Integer> visited) {
        visited.add(i * rows + j);
        //System.out.println(String.format("R: %d, C: %d, val: %d", i, j, grid[i][j]));
        int val = grid[i][j];
        //grid[i][j] = 0;
        int children = 0;
        for (int[] dir : dirs) {
            int newRow = i + dir[0], newCol = j + dir[1];
            int cell = newRow * rows + newCol;
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= columns || grid[newRow][newCol] == 0
                    || visited.contains(cell)) {
                continue;
            }
            int dfs = dfs(grid, newRow, newCol, visited);
            //System.out.println(String.format("R: %d, C: %d, dfs: %d", newRow, newCol, dfs));
            children = Math.max(children, dfs);
        }
        //grid[i][j] = val;
        return children + val;
    }

    @Test
    public void test() {
        int in[][] = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        assertEquals(24, getMaximumGold(in));
    }

    @Test
    public void test2() {
        int in[][] = {
                {1, 0, 7, 0, 0, 0},
                {2, 0, 6, 0, 1, 0},
                {3, 5, 6, 7, 4, 2},
                {4, 3, 1, 0, 2, 0},
                {3, 0, 5, 0, 20, 0}
        };
        assertEquals(60, getMaximumGold(in));
    }

    @Test
    public void test3() {
        int in[][] = {
                {0,  0,  19, 5, 8},
                {11, 20, 14, 1, 0},
                {0,  0,  1,  1, 1},
                {0,  2,  0,  2, 0},
        };
        assertEquals(77, getMaximumGold(in));
    }
}
