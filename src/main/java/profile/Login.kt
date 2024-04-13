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
 * This is the login page of the app.
 */
class Login : AppCompatActivity() {
    /**
     * The login button.
     */
    private lateinit var loginButton: Button

    /**
     * Input for the user email.
     */
    private lateinit var loginEmail : EditText

    /**
     * Input for the user password.
     */
    private lateinit var loginPassword : EditText

    /**
     * The link for going to the register page.
     */
    private lateinit var registerLink : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Defining the variables.
        loginButton = findViewById(R.id.loginButton)
        loginEmail = findViewById(R.id.loginEmail)
        loginPassword = findViewById(R.id.loginPassword)
        registerLink = findViewById(R.id.registerLink)

        // Stuff that does the click listeners and event listeners.
        loginButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        registerLink.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        loginEmail.addTextChangedListener(object : TextWatcher {
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

        loginPassword.addTextChangedListener(object : TextWatcher {
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
        val userEmailLogin = loginEmail.text.toString()
        val userPasswordLogin = loginPassword.text.toString()

        loginButton.isEnabled = userEmailLogin.isNotEmpty() && userPasswordLogin.isNotEmpty()
    }
}