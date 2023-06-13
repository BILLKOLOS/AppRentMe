import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.sc_prep.ui.theme.SCPrepTheme
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SCPrepTheme {
                ShowTimePicker(this)
            }
        }
    }
}

@Composable
fun ShowTimePicker(context: Context) {

    val calendar = Calendar.getInstance()
    val mHour = calendar[Calendar.HOUR_OF_DAY]
    val mMinute = calendar[Calendar.MINUTE]

    val time = remember {
        mutableStateOf("")
    }

    val timePickerDialog = TimePickerDialog(
        context,
        { _, hourOfDay, minute ->
            time.value = "$hourOfDay:$minute"
        }, mHour, mMinute, false
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selected Time : ${time.value}")
        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = { timePickerDialog.show() }) {
            Text(text = "Show Time Picker")
        }
    }
}
