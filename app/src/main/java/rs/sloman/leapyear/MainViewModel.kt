package rs.sloman.leapyear

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repo: Repository) : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> get() = _state

    private val _isBtnCheckStateEnabled = MutableLiveData<Boolean>()
    val isBtnCheckStateEnabled: LiveData<Boolean> get() = _isBtnCheckStateEnabled

    init {
        _isBtnCheckStateEnabled.value = false
    }

    private suspend fun checkLeapYear(year: Int): Boolean {

        var isLeap = false

        val job = viewModelScope.launch {
            isLeap = LeapYearCheck.isLeapYear(year)
        }
        job.join()

        return isLeap
    }

    fun handleButtonClick(input: String) {
        if (input.isNotEmpty()) {

            viewModelScope.launch {
                val year = Integer.parseInt(input)
                _state.value = if (checkLeapYear(year)) State.LEAP else State.NOT_LEAP
            }

        }
    }

    fun handleOnTextChanged(input: CharSequence?) {
        setState(State.BLANK)
        _isBtnCheckStateEnabled.value = !input.isNullOrEmpty()
    }

    fun setState(state: State) {
        _state.value = state
    }

}