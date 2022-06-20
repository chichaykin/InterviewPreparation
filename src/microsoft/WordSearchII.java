package microsoft;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

//https://leetcode.com/problems/word-search-ii/
public class WordSearchII {
    static class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }

    int dirs[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    char[][] board;
    String[] words;
    int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {
        // Make trie
        TrieNode root = buildTrie(words);
        rows = board.length;
        cols = board[0].length;
        Set<String> resultSet = new HashSet<>();
        this.board = board;
        this.words = words;
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                find(r, c, root, visited, resultSet);
            }
        }
        return new ArrayList<>(resultSet);
    }

    private void find(int r, int c, TrieNode root, boolean[][] visited, Set<String> result) {
        TrieNode child = root.children[board[r][c] - 'a'];
        if (child == null) return;
        if (child.word != null) {
            result.add(child.word);
            child.word = null;
        }
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int nextRow = r + dir[0], nextCol = c + dir[1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols
                    || visited[nextRow][nextCol]) continue;
            find(nextRow, nextCol, child, visited, result);
        }
        visited[r][c] = false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            buildTrie(word, 0, root);
        }
        return root;
    }

    private void buildTrie(String word, int i, TrieNode root) {
        char c = word.charAt(i);
        TrieNode node = root.children[c - 'a'];
        if (node == null) {
            node = new TrieNode();
            root.children[c - 'a'] = node;
        }
        if (word.length() == i + 1) {
            node.word = word;
            return;
        }
        buildTrie(word, i + 1, node);
    }

    @Test
    public void test() {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain", "hklf", "hf"};
        Set<String> expected = new HashSet<>(Arrays.asList("oath", "eat", "hklf", "hf"));
        assertEquals(expected, new HashSet<>(findWords(board, words)));
    }
}
