package profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.reviewme.R
import mainApp.Home

/**
 * The register page where the user can create their account.
 * Similar to the login page but as stated this is where the account creation happens.
 */
class Register : AppCompatActivity() {
    /**
     * The register button.
     */
    private lateinit var registerButton: Button

    /**
     * Input for the user email.
     */
    private lateinit var registerEmail : EditText

    /**
     * Input for the user password.
     */
    private lateinit var registerPassword : EditText

    /**
     * Input for the username.
     */
    private lateinit var registerUsername : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Defining the variables.
        registerButton = findViewById(R.id.registerButton)
        registerEmail = findViewById(R.id.registerEmail)
        registerPassword = findViewById(R.id.registerPassword)
        registerUsername = findViewById(R.id.registerUsername)

        // Stuff that does the click listeners and event listeners.
        registerButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        registerEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // No implementation needed
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkFieldsForEmptyValues()
            }

            override fun afterTextChanged(p0: Editable?) {
                // No implementation needed
            }
        })

        registerPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Not needed
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkFieldsForEmptyValues()
            }

            override fun afterTextChanged(p0: Editable?) {
                // Not needed
            }
        })

        registerUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Not needed
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkFieldsForEmptyValues()
            }

            override fun afterTextChanged(p0: Editable?) {
                // Not needed
            }
        })
    }

    /**
     * Checks for empty values in the input files, enabling or disabling the login button accordingly.
     */
    private fun checkFieldsForEmptyValues() {
        val userEmailRegister = registerEmail.text.toString()
        val userPasswordRegister = registerPassword.text.toString()
        val usernameRegister = registerUsername.text.toString()

        registerButton.isEnabled = userEmailRegister.isNotEmpty() && userPasswordRegister.isNotEmpty() && usernameRegister.isNotEmpty()
    }
}