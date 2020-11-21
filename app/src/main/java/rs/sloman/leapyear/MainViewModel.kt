package rs.sloman.leapyear

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    enum class State {
        BLANK,
        LEAP,
        NOT_LEAP
    }

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> get() = _state

    private suspend fun checkLeapYear(year: Int) : Boolean{

        var isLeap = false

        val job = viewModelScope.launch {
            isLeap = isLeapYear(year)
        }
        job.join()

        return isLeap
    }

    suspend fun handleButtonClick(year: Int) {
        _state.postValue(if (checkLeapYear(year)) State.LEAP else State.NOT_LEAP)
    }

    private fun isLeapYear(year: Int) : Boolean{
        return when {
            year % 4 == 0 -> {
                when {
                    year % 100 == 0 -> year % 400 == 0
                    else -> true
                }
            }
            else -> false
        }
    }

    fun setState(state: State){
        _state.value = state
    }

}