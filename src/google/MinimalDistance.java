package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimalDistance {
    int[][] map = {
            {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
            {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5},
            {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5},
            {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5},
            {4, 0}, {4, 1},
    };

    public int minimumDistance(String word) {
        return min(word.toCharArray(), 0, new int[]{-1, -1});
    }

    private int min(char[] word, int index, int[] prevHandIndex) {
        if (index == word.length) return 0;

        int leftDistance = distance(word, index, prevHandIndex[0])
                + min(word, index + 1, new int[]{index, prevHandIndex[1]});
        int rightDistance = distance(word, index, prevHandIndex[1])
                + min(word, index + 1, new int[]{prevHandIndex[0], index});

        return Math.min(leftDistance, rightDistance);
    }

    private int distance(char[] word, int index, int prevHandIndex) {
        int prevIndex = prevHandIndex == -1 ? index : prevHandIndex;
        if (index != prevIndex) {
            int i = word[index] - 'A';
            int j = word[prevIndex] - 'A';
            return Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]);
        }
        return 0;
    }

    @Test
    public void test0() {
        assertEquals(5, minimumDistance("TUGR"));
    }

    @Test
    public void test() {
        assertEquals(3, minimumDistance("CAKE"));
    }

    @Test
    public void test2() {
        assertEquals(6, minimumDistance("HAPPY"));
    }

    @Test
    public void test3() {
        assertEquals(3, minimumDistance("NEW"));
    }

    @Test
    public void test4() {
        assertEquals(7, minimumDistance("YEAR"));
    }
}
