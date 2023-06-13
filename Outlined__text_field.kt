import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.InternalTextApi
import com.shubham.sc_prep.ui.theme.SCPrepTheme

class MainActivity : AppCompatActivity() {
    @InternalTextApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SCPrepTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SimpleOutlinedTextField()
                }
            }
        }
    }
}

@Composable
fun SimpleOutlinedTextField() {
    var text by rememberSaveable {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text, onValueChange = { text = it },
        label = { Text(text = "Enter Name") },
        singleLine = true
    )
}
