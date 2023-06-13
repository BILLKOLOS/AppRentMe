import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
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
                    NumberTextField()
                }
            }
        }
    }
}

@Composable
fun NumberTextField() {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = textValue,
        onValueChange = { textValue = it },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
