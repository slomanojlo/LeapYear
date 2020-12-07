package rs.sloman.leapyear

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.MutableLiveData
import org.junit.Assert.assertEquals
import org.junit.Test

class LeapYearLiveDataStateTest {

    @Test
    fun shouldReturnVisibilityGone_WhenStateIsBLANK(){

        val state = MutableLiveData(State.BLANK)

        assertEquals(state.value?.visibility, GONE)
    }

    @Test
    fun shouldReturnVisibilityVisible_WhenStateIsLEAP(){

        val state = MutableLiveData(State.LEAP)

        assertEquals(state.value?.visibility, VISIBLE)
    }

    @Test
    fun shouldReturnVisibilityVisible_WhenStateIsNotLEAP(){

        val state = MutableLiveData(State.NOT_LEAP)

        assertEquals(state.value?.visibility, VISIBLE)
    }


    @Test
    fun shouldReturnMessagegEmpty_WhenStateIsBlank(){

        val state = MutableLiveData(State.BLANK)

        assertEquals(state.value?.message, R.string.empty)
    }

    @Test
    fun shouldReturnMessageLeap_WhenStateIsLEAP(){

        val state = MutableLiveData(State.LEAP)

        assertEquals(state.value?.message, R.string.this_year_is_leap)
    }

    @Test
    fun shouldReturnMessageNotLeap_WhenStateIsNotLEAP(){

        val state = MutableLiveData(State.NOT_LEAP)

        assertEquals(state.value?.message, R.string.this_year_is_not_leap)
    }


}