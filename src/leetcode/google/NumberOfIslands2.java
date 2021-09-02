package leetcode.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class NumberOfIslands2 {
    int columns;
    int rows;
    Map<Integer, Integer> map;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        ArrayList<Integer> result = new ArrayList<>();
        if (m == 0 && n == 0 || positions.length == 0) return result;

        if (positions.length == 1) {
            result.add(1);
            return result;
        }

        columns = n;
        rows = m;
        int islands = 0;
        map = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            islands = buildRelations(positions, i, islands);
            result.add(islands);
        }
        return result;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private int buildRelations(int[][] positions, int i, int islands) {
        int row = positions[i][0];
        int col = positions[i][1];
        int root = columns * row + col;
        if (map.containsKey(root)) {
            return islands;
        }
        map.put(root, root);
        islands++;
        for (int[] dir : dirs) {
            int nRow = row + dir[0], nCol = col + dir[1];
            int nb = nRow * columns + nCol;
            if (nRow < 0 || nCol < 0 || nRow >= rows || nCol >= columns || !map.containsKey(nb)) continue;

            int nbRoot = find(nb);
            if (nbRoot != root) {
                map.put(root, nbRoot);
                root = nbRoot;
                islands--;
            }
        }
        return islands;
    }

    private int find(int nb) {
        while(nb != map.get(nb)) {
            nb = map.get(map.get(nb));
        }
        return nb;
    }


    @Test
    public void test() {
        List<Integer> result = numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}});
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3}, result.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void test2() {
        List<Integer> result = numIslands2(2, 2, new int[][]{{0, 0}, {1, 1}, {0, 1}});
        Assert.assertArrayEquals(new int[]{1, 2, 1}, result.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void test3() {
        List<Integer> result = numIslands2(3, 3, new int[][]{{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}});
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 3, 2, 1}, result.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void test4() {
        List<Integer> result = numIslands2(2, 2, new int[][]{{0, 1}, {0, 1},{0, 1},{0, 1}});
        Assert.assertArrayEquals(new int[]{1, 1, 1, 1}, result.stream().mapToInt(Integer::intValue).toArray());
    }

}
