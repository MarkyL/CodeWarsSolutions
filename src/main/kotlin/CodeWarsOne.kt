import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CodeWarsOne {
    fun printerError(s: String): String {
        val regex = Regex("[a-m]")
        val correctCount = regex.findAll(s, 0).count()
        val errorCount = s.length - correctCount
        return "$errorCount/${s.length}"
    }

    @Test
    fun testFixed() {
        assertEquals("3/56", printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"))
        assertEquals("6/60", printerError("kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"))
        assertEquals("11/65", printerError("kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyzuuuuu"))
        assertEquals("0/53", printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmm"))
    }

    fun longestConsec(strarr: Array<String>, k: Int): String {
        val n = strarr.size
        if (n == 0 || k > n || k <= 0) return ""
        var longestExpression = ""

        strarr.forEachIndexed { index, s ->
            var currentExpression = ""
            for (i in index until index + k) {
                if (i < n) {
                    currentExpression = currentExpression.plus(strarr[i])
                }
            }
            if (currentExpression.length > longestExpression.length) {
                longestExpression = currentExpression
            }
        }

        return longestExpression
    }

    @Test
    fun test() {
        println("longestConsec Fixed Tests")
        testing(
            longestConsec(arrayOf("zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"), 2),
            "abigailtheta"
        )
        testing(
            longestConsec(
                arrayOf(
                    "ejjjjmmtthh",
                    "zxxuueeg",
                    "aanlljrrrxx",
                    "dqqqaaabbb",
                    "oocccffuucccjjjkkkjyyyeehh"
                ), 1
            ), "oocccffuucccjjjkkkjyyyeehh"
        )

    }

    companion object {
        private fun testing(actual: String, expected: String) {
            assertEquals(expected, actual)
        }
    }

    fun high(str: String): String {
        val tokens = str.split(" ")
        var maxVal = 0
        var maxStr = ""
        tokens.forEach {
            var currentMaxVal = 0
            it.forEach { ch ->
                currentMaxVal += ch.code
            }
            if (currentMaxVal > maxVal) {
                maxVal = currentMaxVal
                maxStr = it
            }
        }
        return maxStr
    }

    @Test
    fun high() {
        assertEquals("taxi", high("man i need a taxi up to ubud"))
        assertEquals("volcano", high("what time are we climbing up the volcano"))
        assertEquals("semynak", high("take me to semynak"))
        assertEquals("aa", high("aa b"))
        assertEquals("b", high("b aa"))
        assertEquals("bb", high("bb d"))
        assertEquals("d", high("d bb"))
        assertEquals("aaa", high("aaa b"))
    }
}
