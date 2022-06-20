package facebook;

import java.util.HashSet;
import java.util.Set;

public class InterviewSG {
// Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:

// Input : A[] = {-7, 1, 5, 2, -4, 3, 0}
// Output : 3
// 3 is an equilibrium index, because:
// A[0] + A[1] + A[2]  =  A[4] + A[5] + A[6]

    // Given a sequence of size n, returns an equilibrium index.
    int getEquilibrium(int[] in) {
        int left = 0, right = 0;
        for (int i = 1; i < in.length; i++) right += in[i]; //{1, 5, 2, -4, 3, 0}
        //left = 0, right = 6
        for (int i = 1; i < in.length; i++) {

            left += in[i - 1]; //left = -7
            right -= in[i];  //right
            if (left == right) return i;
        }
        return -1;
    }


// Given a 2D grid of 0s and 1s, what is the maximum area of an island formed by flipping at most one 0 to 1. An island is formed when there are 1s in four directions (up, down, right, left).

// Find the maximum area of an island when you are allowed to flip one 0 to 1.

// Input:
// [[1, 0],
// [0, 1],
// [1, 1]]
// Output: 5

// Reason: Change 0 at (0, 1) to 1 and we get an island with area = 5

    int maxSquare(int[][] grid) {
        if (grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        Set<String> visited = new HashSet<>();
        int maxSquare = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited.contains(String.format("%,%d", r, c))) {
                    int prev = grid[r][c];
                    grid[r][c] = 1;
                    Set<String> visitedNow = new HashSet<>();
                    maxSquare = Math.max(maxSquare, findSquare(r, c, grid, visitedNow));
                    grid[r][c] = prev;
                    visited.addAll(visitedNow);
                }
            }
        }
        return maxSquare;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private int findSquare(int row, int col, int[][] grid, Set<String> visited) {
        visited.add(String.format("%,%d", row, col));
        int square = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (isValid(newRow, newCol) && grid[newRow][newCol] == 1 && isNotVisited(newRow, newCol, visited)) { // out of bounds for the grid
                square += findSquare(newRow, newCol, grid, visited);
            }
        }
        return square;
    }

    private boolean isNotVisited(int newRow, int newCol, Set<String> visited) {
        return false;
    }

    private boolean isValid(int newRow, int newCol) {
        return true;
    }
}
