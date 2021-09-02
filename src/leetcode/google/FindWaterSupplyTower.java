package leetcode.google;

import leetcode.Point;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/*
Given a m*n matrix of positive ints, the value of each point in the matrix is the height of that point.
Given two villages in the matrix, find a point to build a “Water supply tower”
so that water can flow to both of the villages. Water can only flow from high to low or equal to equal.
If there are multiple answers, return the one with the highest value.

1  1  1  1
1  6 [7] 4
1  5  1  3
1 (4) 1 (2)

Example:
Inputs: 2d matrix, (3, 1), (3, 3)
Expected output: (1, 2)
*/
public class FindWaterSupplyTower {

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int rows, columns;

    Point findTower(int[][] m, int[][] v) {
        rows = m.length;
        columns = m[0].length;

        Set<Point> intersection = new HashSet<>();
        for (int[] loc : v) {
            Set<Point> visited = new HashSet<>();
            dfs(new Point(loc[0], loc[1]), m, visited);
            if (intersection.isEmpty()) intersection.addAll(visited);
            else intersection.retainAll(visited);
        }

        Point highestPoint = null;
        for (Point point : intersection) {
            if (highestPoint == null || m[highestPoint.getCol()][highestPoint.getCol()] < m[point.getCol()][point.getCol()]) {
                highestPoint = new Point(point.getRow(), point.getCol());
            }
        }
        return highestPoint;
    }

    private void dfs(Point point, int[][] m, Set<Point> visited) {
        visited.add(point);
        int row = point.getRow(), col = point.getCol();
        for (int[] shift : dirs) {
            int nextRow = row + shift[0], nextCol = col + shift[1];
            Point nextPoint = new Point(nextRow, nextCol);
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns
                    || visited.contains(nextPoint)
                    || m[row][col] > m[nextRow][nextCol]) continue;

            dfs(nextPoint, m, visited);
        }
    }

    @Test
    public void test() {
        int[][] m = {
                {1, 1, 1, 1},
                {1, 6, 7, 4},
                {1, 5, 1, 3},
                {1, 4, 1, 2}
        };
        Point expected = new Point(1, 2);
        int[][] v = new int[][]{{3, 1}, {3, 3}};
        assertEquals(expected, findTower(m, v));
    }
}
