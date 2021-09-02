package leetcode.google;

import java.util.*;

public class NumberOfIslands {
    int rows;
    int columns;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        Set<List<Integer>> visited = new HashSet<>();
        int islands = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] != 0 && !visited.contains(Arrays.asList(r, c))) {
                    dfs(grid, r, c, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c,  Set<List<Integer>> visited) {
        if (r < 0 || r >= rows || c < 0 || c >= columns || grid[r][c] == 0 || visited.contains(Arrays.asList(r, c))) {
            return;
        }
        visited.add(Arrays.asList(r, c));

        dfs(grid, r + 1, c, visited);
        dfs(grid, r - 1, c, visited);
        dfs(grid, r, c - 1, visited);
        dfs(grid, r, c + 1, visited);
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
//            if (find(position)) {
//                res.add();
//            }
        }
        return res;
    }
}
