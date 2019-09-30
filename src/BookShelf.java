import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*
https://leetcode.com/problems/filling-bookcase-shelves/
 */

public class BookShelf {

    @Test
    public void test() {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelf_width = 4;
        assertEquals(6, minHeightShelves(books, shelf_width));
    }

    @Test
    public void test2() {
        int[][] books = {{1,3},{2,4},{3,2}};
        assertEquals(4, minHeightShelves(books, 6));
    }

    @Test
    public void test3() {
        int[][] books = {{1, 4}};
        int shelf_width = 4;
        assertEquals(4, minHeightShelves(books, shelf_width));
    }

    int minHeightShelves(int[][] books, int shelf_width) {
        int number = books.length;
        if (number == 1) return books[0][1];

        int[] dp = new int[number+1];
        for (int i = 1; i <= number; i++) {
            int height = 0;
            for (int j = i, width = 0; j > 0 && width + books[j-1][0] <= shelf_width; j--) {
                height = Math.max(books[j-1][1], height);
                width += books[j-1][0];
                dp[i] = Math.min(
                        dp[i] == 0 ? Integer.MAX_VALUE: dp[i],
                        dp[j-1] + height);
            }
        }
        return dp[number];
    }
}
