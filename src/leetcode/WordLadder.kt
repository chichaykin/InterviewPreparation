package leetcode

//import org.junit.Test
//
//const val size = 26
//
//class WordLadder {
//
//    class TrieNode {
//        val nodes = arrayOfNulls<TrieNode>(size)
//        val endWord = false
//    }
//
//    lateinit var root: TrieNode
//    lateinit var endWord: String
//
//    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
//        root = TrieNode()
//        this.endWord = endWord
//
//        for (word in wordList) {
//            insertWord(word)
//        }
//        val permutationList = ArrayList<String>()
//        for (i in 1..size) {
//            if (beginWord[i] != endWord[i]) {
//                permutationList.add(beginWord.replaceRange(i, i + 1, "*"))
//            }
//        }
//        var minLength = Integer.MAX_VALUE
//        for (word in permutationList) {
//            val length = ladderLength(word, 1)
//            if (length < minLength) {
//                minLength = length
//            }
//        }
//        return if (minLength == Integer.MAX_VALUE) 0 else minLength
//    }
//
//    private fun ladderLength(inputWord: String, iteration: Int): Int {
//        val word: String = search(inputWord, root)
//        if (word.isEmpty()) return Integer.MAX_VALUE
//
//        if (word == endWord) return iteration
//        return ladderLength(inputWord, iteration + 1)
//    }
//
//    private fun search(inputWord: String, start: TrieNode): String {
//        var node = start
//        for (char in inputWord) {
//            if (char == '*') {
//
//            }
//            val index = 'a' - char
//            if (node.nodes[index] == null) return ""
//            node = node.nodes[index]!!
//        }
//    }
//
//    private fun insertWord(root: TrieNode, word: String): TrieNode {
//        val node = TrieNode()
//        root.nodes['a' - word[0]] = node
//        return node
//    }
//
//    @Test
//    fun test() {
//
//    }
//
//}