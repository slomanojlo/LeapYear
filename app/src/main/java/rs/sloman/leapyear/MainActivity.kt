package rs.sloman.leapyear

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
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

        binding.etEnterLeapYear.doOnTextChanged { text: CharSequence?, _, _, _ ->
            viewModel.handleOnTextChanged(text)
        }

        viewModel.state.observe(this) {

            binding.twResult.apply{
                text = getString(it.message)
                visibility = it.visibility
            }

        }

        viewModel.isBtnCheckStateEnabled.observe(this){
            binding.btnCheckYear.isEnabled = it
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
        val state = savedInstanceState.getSerializable(STATE) as State

        binding.etEnterLeapYear.setText(yearInput)
        viewModel.setState(state)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}