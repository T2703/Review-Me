package mainApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewme.R
import dataClasses.User

/**
 * This is the page where the users can look up users.
 */
class LookUpUsers : AppCompatActivity() {
    /**
     * The card view for the user.
     */
    private lateinit var recyclerViewUser: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look_up_users)

        // Define variables.
        recyclerViewUser = findViewById(R.id.recyclerViewUsers)
        recyclerViewUser.layoutManager = LinearLayoutManager(this)

        // For now we test with mock users because backend is hard and I don't know what I'm doing (I'm learning I think).
        val users = listOf(
            User("John"),
            User("Jane"),
            User("T")
        )

        val adapter = UserAdapter(users)
        recyclerViewUser.adapter = adapter

    }
}