package leetcode

import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

interface Master {
    fun guess(word: String): Int
}

class MasterImpl(val secret: String) : Master {
    var guessed = false
    override fun guess(word: String): Int {
        val match = match(secret, word)
        guessed = match == secret.length
        return match
    }
}

fun match(a: String, b: String): Int {
    var matches = 0
    for (i in a.indices) if (a[i] == b[i]) matches++
    return matches
}

class RandomGuessAndMinimaxGuessWithComparison {
    fun findSecretWord(_wordlist: ArrayList<String>, master: Master) {
        var i = 0
        var x = 0
        var wordlist = _wordlist
        while (i < 10 && x < 6) {
            val guess = wordlist[Random().nextInt(wordlist.size)]
            x = master.guess(guess)
            val wordlist2 = ArrayList<String>()
            for (w in wordlist) {
                if (match(guess, w) == x) {
                    wordlist2.add(w)
                }
            }
            println("Suppose $guess: $wordlist2")
            wordlist = wordlist2
            i++
        }
    }

    @Test
    fun test() {
        val input = arrayListOf("123456", "r23456", "023456", "654321", "acckzz", "ccbazz", "eiowzz", "abcczz")
        val master = MasterImpl("654321")
        findSecretWord(input, master)
        assertTrue(master.guessed)

    }

}