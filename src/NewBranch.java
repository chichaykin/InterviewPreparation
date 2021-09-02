import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class NewBranch {
    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (row != cell.row) return false;
            return col == cell.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    int columns;
    int rows;
    int A[][];

    public int solution(int K, int[][] A) {
        this.A = A;
        rows = A.length;
        columns = A[0].length;
        // find all houses
        List<Cell> houses = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (A[r][c] == 1) houses.add(new Cell(r, c));
            }
        }
        // Find intersection of available cells
        Set<Cell> intersection = new HashSet<>();
        for (Cell house : houses) {
            Set<Cell> visited = new HashSet<>();
            bfs(house, visited, K);
            //dfs(house.row, house.col, visited, K);
            //System.out.println("H: " + house + ", " + visited);
            if (intersection.isEmpty()) intersection.addAll(visited);
            else intersection.retainAll(visited);
        }

        return intersection.size();
    }

    private void bfs(Cell house, Set<Cell> visited, int k) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(house.row, house.col));
        k++;
        while (!queue.isEmpty()) {
            if (k == 0) return;
            k--;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell cell = queue.remove();
                if (A[cell.row][cell.col] == 0) {
                    if (!visited.add(new Cell(cell.row, cell.col))) {
                        continue;
                    }
                }

                for (int[] dir : dirs) {
                    int nextRow = cell.row + dir[0], nextCol = cell.col + dir[1];
                    Cell nextCell = new Cell(nextRow, nextCol);
                    //System.out.println("["+nextRow + "," + nextCol + "] visited: " + visited.contains(nextCell));
                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns
                            || A[nextRow][nextCol] != 0
                            || visited.contains(nextCell)
                    ) continue;

                    queue.add(nextCell);
                }
            }
        }

    }

    private void dfs(int row, int col, Set<Cell> visited, int k) {
        if (A[row][col] == 0) {
            visited.add(new Cell(row, col));
        }
        if (k == 0) {
            //System.out.println("[" + row + "," + col + "] ");
            return;
        }
        for (int[] dir : dirs) {
            int nextRow = row + dir[0], nextCol = col + dir[1];
            Cell nextCell = new Cell(nextRow, nextCol);
            //System.out.println("["+nextRow + "," + nextCol + "] visited: " + visited.contains(nextCell));
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns
                    || A[nextRow][nextCol] != 0
                    || visited.contains(nextCell)
            ) continue;

            dfs(nextRow, nextCol, visited, k - 1);
        }
    }

    @Test
    public void test() {
        int k = 2, A[][] = {{0, 0, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}};
        assertEquals(2, solution(k, A));
    }

    @Test
    public void test2() {
        int k = 4, A[][] = {{0, 0, 0, 1}, {0, 1, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}};
        assertEquals(6, solution(k, A));
    }
}
