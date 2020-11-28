package rs.sloman.leapyear

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.sloman.leapyear.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        const val YEAR_INPUT = "year_input"
        const val STATE = "state"
    }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnCheckYear.setOnClickListener {
            viewModel.handleButtonClick(binding.etEnterLeapYear.text.toString())
        }

        viewModel.state.observe(this) {
            when (it) {
                MainViewModel.State.LEAP -> {
                    binding.twResult.text = getString(R.string.this_year_is_leap)
                    binding.twResult.visibility = View.VISIBLE
                }

                MainViewModel.State.NOT_LEAP -> {
                    binding.twResult.text = getString(R.string.this_year_is_not_leap)
                    binding.twResult.visibility = View.VISIBLE
                }

                else -> {
                    binding.twResult.visibility = View.INVISIBLE
                }
            }
        }

        binding.etEnterLeapYear.doOnTextChanged { text: CharSequence?, _, _, _ ->
            viewModel.setState(MainViewModel.State.BLANK)
            binding.btnCheckYear.isEnabled = !text.isNullOrEmpty()
        }


        setContentView(binding.root)

    }

    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState.apply {
            outState.putString(
                YEAR_INPUT, binding.etEnterLeapYear.text.toString()
            )
            outState.putSerializable(STATE, viewModel.state.value)
        })
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val yearInput = savedInstanceState.getString(YEAR_INPUT, "")
        val state = savedInstanceState.getSerializable(STATE) as MainViewModel.State

        binding.etEnterLeapYear.setText(yearInput)
        viewModel.setState(state)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}