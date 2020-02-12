package leetcode

import org.junit.Test
import java.io.*
import java.nio.CharBuffer
import java.util.*
import kotlin.test.assertEquals

class TestStreamReading {

    val currentFileVersion = 3
    val json = """{
                "SDKJsonVariable": {
                    "value": "sdkVersion"
                }
        }
        """
    private val etag: String? = null//UUID.randomUUID().toString()

    @Test
    fun test() {
        val file = File("test")
        BufferedWriter(OutputStreamWriter(file.outputStream())).use {
            it.write(currentFileVersion)
            it.write(etag?.length ?: 0)
            etag?.apply { it.write(this) }
            it.write(json)
        }

        BufferedReader(InputStreamReader(file.inputStream())).use {
            val fileVersion = it.read()
            val mobileVariablesETagLength = it.read()
            val buffer = CharArray(mobileVariablesETagLength)
            it.read(buffer)
            assertEquals(etag, String(buffer))
            assertEquals(json, it.readText())
        }
    }
}