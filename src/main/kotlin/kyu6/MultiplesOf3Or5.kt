package kyu6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MultiplesOf3Or5 {

    fun solution(number: Int): Int {
        if (number < 0) return 0
        return (1 until number).sumOf {
            if (it % 3 == 0 || it % 5 == 0) it else 0
        }
    }

    @Test
    fun testFixed() {
        assertEquals(23, solution(10))
        assertEquals(78, solution(20))
        assertEquals(9168, solution(200))
    }
}