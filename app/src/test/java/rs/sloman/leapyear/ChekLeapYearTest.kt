package rs.sloman.leapyear

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(JUnitParamsRunner::class)
class ChekLeapYearTest {

    @Test
    @Parameters(
        value = [
            "0",
            "4",
            "400",
            "800",
            "8",
            "2000",
            "4000",
        ]
    )
    fun shouldReturnTrue_WhenYearIsLeap(year: Int) {

        val actualResult: Boolean = LeapYearCheck.isLeapYear(year)

        assertTrue(actualResult)

    }

    @Test
    @Parameters(
        value = [
            "500",
            "600",
            "700",
            "2002",
        ]
    )
    fun shouldReturnFalse_WhenYearIsNotLeap(year: Int) {

        val actualResult: Boolean = LeapYearCheck.isLeapYear(year)

        assertFalse(actualResult)

    }


}
