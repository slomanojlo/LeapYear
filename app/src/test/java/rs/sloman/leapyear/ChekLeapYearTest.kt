package rs.sloman.leapyear

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ChekLeapYearTest(
    private val year: Int,
    private val isLeapYear: Boolean,
) {

    @Test
    fun checkLeapYear() {

        val actualResult: Boolean = when {
            year % 4 == 0 -> {
                when {
                    year % 100 == 0 -> year % 400 == 0
                    else -> true
                }
            }
            else -> false
        }

        assertEquals(isLeapYear, actualResult)

    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0} is leap year: {1}")
        fun rounds() = listOf(
            arrayOf(0, true),
            arrayOf(1, false),
            arrayOf(4, true),
            arrayOf(400, true),
            arrayOf(500, false),
            arrayOf(600, false),
            arrayOf(700, false),
            arrayOf(800, true),
            arrayOf(8, true),
            arrayOf(2000, true),
            arrayOf(2002, false),
            arrayOf(4000, true),
        )
    }

}
