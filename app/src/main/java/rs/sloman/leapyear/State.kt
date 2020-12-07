package rs.sloman.leapyear

import android.view.View

enum class State(val visibility: Int, val message: Int) {

    BLANK(View.GONE, R.string.empty),
    LEAP(View.VISIBLE, R.string.this_year_is_leap),
    NOT_LEAP(View.VISIBLE, R.string.this_year_is_not_leap)

}