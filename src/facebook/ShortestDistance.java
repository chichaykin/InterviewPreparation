package facebook;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class Cell {
    int first;
    int second;

    public Cell(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class ShortestDistance {
    List<Cell> buildings = new ArrayList<>();
    int rows;
    int cols;

    public int shortestDistance(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        if (cols == 0) return -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) buildings.add(new Cell(i, j));
            }
        }
        int cells[][][] = new int[buildings.size()][rows][cols];
        for (int building = 0; building < buildings.size(); building++) {
            int x = buildings.get(building).first;
            int y = buildings.get(building).second;
            calc(x, y, grid, cells[building]);
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int building = 0; building < buildings.size(); building++) {
                    if (grid[i][j] != 0) break;
                    if (cells[building][i][j] == 0) {
                        sum = 0;
                        break;
                    }
                    sum += cells[building][i][j];
                }
                if (sum != 0)
                    minDistance = Math.min(minDistance, sum);
            }
        }

//        for (int building = 0; building < buildings.size(); building++) {
//            print2D(cells[building]);
//            System.out.println("------------");
//        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

//    public static void print2D(int mat[][]) {
//        // Loop through all rows
//        for (int[] row : mat)
//
//            // converting each row as string
//            // and then printing in a separate line
//            System.out.println(Arrays.toString(row));
//    }

    int dirs[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private void calc(int i, int j, int[][] grid, int[][] cells) {
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(i, j));
        int value = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            value++;
            for (int k = 0; k < size; k++) {
                Cell pair = q.remove();
                for (int dir[] : dirs) {
                    i = pair.first;
                    j = pair.second;
                    i += dir[0]; j += dir[1];
                    if (i < 0 || j < 0 || i == rows || j == cols || cells[i][j] != 0 || grid[i][j] != 0)
                        continue;
                    cells[i][j] = value;
                    q.add(new Cell(i, j));
                }
            }
        }
    }

    public int shortestDistance2(int[][] grid) {
        // Corner case:
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dists = new int[rows][cols];    // dists[i][j] represent total distance to all buildings
        int[] res = new int[1];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {   // grid[i][j] is a building
                    res[0] = Integer.MAX_VALUE;
                    if(!bfs(grid, i, j, new boolean[rows][cols], res, dists)) {
                        return -1;
                    }
                }
            }
        }
        return (res[0] == Integer.MAX_VALUE) ? -1 : res[0];
    }

    // Check if building grid[i][j] can reach all other buildings or not.
    private boolean bfs(int[][] grid, int i, int j, boolean[][] visited, int[] res, int[][] dists) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int dist = 0;
        while(!queue.isEmpty()) {   // There have buildings in the queue
            dist++;
            int size = queue.size();
            for(int k=0; k<size; k++) {
                int[] curr = queue.poll();  // Poll one building from the queue
                for(int[] dir: dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && !visited[x][y]) {
                        visited[x][y] = true;
                        if(grid[x][y] == 0) {
                            dists[x][y] += dist;
                            queue.offer(new int[]{x, y});
                            res[0] = Math.min(res[0], dists[x][y]);
                        }
                    }
                }
            }
        }
        for(int x=0; x<visited.length; x++) {
            for(int y=0; y<visited[0].length; y++) {
                if(!visited[x][y]) {        // Cannot reach grid[i][j]
                    if(grid[x][y] == 1) {   // Cannot reach a building, i.e. from grid[i][j] cannot reach grid[x][y]
                        return false;
                    } else if(grid[x][y] == 0) {    // Building grid[i][j] cannot reach empty cell grid[x][y], then skip it next time
                        grid[x][y] = 2;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test3() {
        int[][] input = {{1}};
        assertEquals(-1, shortestDistance(input));
    }

    @Test
    public void test2() {
        int[][] input = {{1}, {0}};
        assertEquals(1, shortestDistance(input));
    }

    @Test
    public void test() {
        int[][] input = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        assertEquals(7, shortestDistance(input));
    }
}
