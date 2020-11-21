package rs.sloman.leapyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rs.sloman.leapyear.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}