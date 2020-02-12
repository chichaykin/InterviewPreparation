package leetcode

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

data class Point(val row: Int, val col: Int)

class Maze2 {
    private val directions = arrayOf(arrayOf(1, 0), arrayOf(-1, 0), arrayOf(0, 1), arrayOf(0, -1))
    private var rows = 0
    private var columns = 0
    private lateinit var maze: Array<IntArray>
    private lateinit var distances: Array<IntArray>

    fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray): Int {
        rows = maze.size
        columns = maze[0].size
        this.maze = maze
        distances = Array(rows) { IntArray(columns) { Int.MAX_VALUE } }
        distances[start[0]][start[1]] = 0
        val startPoint = Point(start[0], start[1])
        val q = LinkedList<Point>()
        q.offer(startPoint)
        while (!q.isEmpty()) {
            val p = q.poll()
            for (dir in directions) {
                makeNextPoint(p, dir)?.apply {
                    q.push(this)
                }
            }
        }
        val result = distances[destination[0]][destination[1]]
        return if (result == Int.MAX_VALUE) -1 else result
    }

    private fun makeNextPoint(p: Point, dir: Array<Int>): Point? {
        val rowInc = dir[0]
        var row = p.row + rowInc
        if (row < 0 || row >= rows) return null
        val colInc = dir[1]
        var col = p.col + colInc
        if (col < 0 || col >= columns) return null
        if (maze[row][col] == 1) return null
        var count = 1
        do {
            val newRow = row + rowInc
            val newCol = col + colInc
            if (rowInc != 0) {
                if (newRow < 0 || newRow >= rows) break
            } else {
                if (newCol < 0 || newCol >= columns) break
            }
            if (maze[newRow][newCol] == 1) break

            row = newRow
            col = newCol
            count++
        } while (true)
        val newDistance = distances[p.row][p.col] + count
        if (distances[row][col] < newDistance) {
            return null
        } else {
            distances[row][col] = newDistance
        }
        return Point(row, col)
    }

    @Test
    fun test() {
        val maze = arrayOf(
                intArrayOf(0,0,1,0,0),
                intArrayOf(0,0,0,0,0),
                intArrayOf(0,0,0,1,0),
                intArrayOf(1,1,0,1,1),
                intArrayOf(0,0,0,0,0))
        assertEquals(12, shortestDistance(maze = maze, start = intArrayOf(0,4), destination = intArrayOf(4,4)))
    }

    @Test
    fun test2() {
        val maze = arrayOf(
                intArrayOf(0,0,1,0,0),
                intArrayOf(0,0,0,0,0),
                intArrayOf(0,0,0,1,0),
                intArrayOf(1,1,0,1,1),
                intArrayOf(0,0,0,0,0))
        assertEquals(-1, shortestDistance(maze = maze, start = intArrayOf(0,4), destination = intArrayOf(3,2)))
    }

    @Test
    fun test3() {
        val maze = arrayOf(
                intArrayOf(0,0,0,0,1,0,0),
                intArrayOf(0,0,1,0,0,0,0),
                intArrayOf(0,0,0,0,0,0,0),
                intArrayOf(0,0,0,0,0,0,1),
                intArrayOf(0,1,0,0,0,0,0),
                intArrayOf(0,0,0,1,0,0,0),
                intArrayOf(0,0,0,0,0,0,0),
                intArrayOf(0,0,1,0,0,0,1),
                intArrayOf(0,0,0,0,1,0,0))
        assertEquals(10, shortestDistance(maze = maze, start = intArrayOf(0,4), destination = intArrayOf(8,6)))
    }

}