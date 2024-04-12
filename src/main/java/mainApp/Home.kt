package mainApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.reviewme.R
import java.util.Calendar

/**
 * The homepage of the app.
 */
class Home : AppCompatActivity() {
    /**
     * The login button.
     */
    private lateinit var greetText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Defining the variables.
        greetText = findViewById(R.id.greetText)

        dateGreeting()
    }

    /**
     * This greets the user based on the time of day.
     */
    private fun dateGreeting() {
        // Kotlin has no dates like Java so I do this.
        val calendar = Calendar.getInstance()

        // This is the greeting variable so when the hour of day is within
        // a certain hour we greet based on that.
        val greeting = when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good morning"
            in 12..17 -> "Good afternoon"
            in 18..23 -> "Good evening"
            else -> "No date found not good :("
        }

        // Sets the greetText text variable to this.
        greetText.text = greeting

    }
}