package rs.sloman.leapyear

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    enum class State {
        BLANK,
        LEAP,
        NOT_LEAP
    }

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> get() = _state

}