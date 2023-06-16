import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header
import retrofit2.http.POST

data class LikeResponse(
    val success: Boolean
)

interface ProfileApiService {
    @POST("likeProfile")
    suspend fun likeProfile(@Header("Authorization") token: String): LikeResponse
}

class ProfileActivity : AppCompatActivity() {

    private lateinit var apiService: ProfileApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ProfileApiService::class.java)

        val likeButton: Button = findViewById(R.id.likeButton)
        likeButton.setOnClickListener {
            likeProfile()
        }
    }

    private fun likeProfile() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val token = "your_token_here" // Replace with the actual token value
                val response = apiService.likeProfile(token)

                if (response.success) {
                    runOnUiThread {
                        Toast.makeText(this@ProfileActivity, "Profile Liked", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(this@ProfileActivity, "Failed to Like Profile", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this@ProfileActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
