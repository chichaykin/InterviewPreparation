package facebook;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean isLast;
}

public class WordDictionary {
    TrieNode root = new TrieNode();

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isLast = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char word[], int index, TrieNode node) {
        if (node == null) return false;
        else if (word.length == index) return node.isLast;

        char ch = word[index];
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (search(word, index + 1, child)) return true;
            }
            return false;
        }

        node = node.children[ch - 'a'];
        if (node == null) {
            return false;
        }
        return search(word, index + 1, node);
    }

    @Test
    public void test() {
        addWord("bad");
        addWord("dad");
        addWord("mad");
        assertFalse(search("d"));
        assertFalse(search("pad"));
        assertTrue(search("bad"));
        assertTrue(search(".ad"));
        assertTrue(search("b.."));
    }
}
