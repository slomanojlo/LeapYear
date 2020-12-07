package rs.sloman.leapyear

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.MutableLiveData
import org.junit.Assert.assertEquals
import org.junit.Test

class LeapYearLiveDataStateTest {

    @Test
    fun shouldReturnVisibilityGone_WhenStateIsLEAP(){

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




}