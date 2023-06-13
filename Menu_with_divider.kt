import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
                    SimpleDividerMenu()
                }
            }
        }
    }
}

@Composable
fun SimpleDividerMenu() {
    val context = LocalContext.current
    var menus by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        IconButton(onClick = { menus = true }) {
            Icon(Icons.Filled.MoreVert, contentDescription = "Menu")
        }
        DropdownMenu(expanded = menus, onDismissRequest = { menus = false }) {
            DropdownMenuItem(onClick = {
                Toast.makeText(context, "Item 1 Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text("Item 1")
            }
            DropdownMenuItem(onClick = {
                Toast.makeText(context, "Item 2 Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text("Item 2")
            }
            DropdownMenuItem(onClick = {
                Toast.makeText(context, "Item 3 Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text("Item 3")
            }
            Divider()
            DropdownMenuItem(onClick = {
                Toast.makeText(context, "Item 4 Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text("Item 4")
            }
            DropdownMenuItem(onClick = {
                Toast.makeText(context, "Item 5 Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text("Item 5")
            }
        }
    }
}
