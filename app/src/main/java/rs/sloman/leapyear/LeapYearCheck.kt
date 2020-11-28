package rs.sloman.leapyear

object LeapYearCheck {

    fun isLeapYear(year: Int) = when {
        year % 4 == 0 -> {
            when {
                year % 100 == 0 -> year % 400 == 0
                else -> true
            }
        }
        else -> false

    }

}