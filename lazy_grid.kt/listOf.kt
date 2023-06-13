import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyGridList(this)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun LazyGridList(context: Context) {

    val itemNumber = (1..10).toList()
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(itemNumber.size) {
            Card(
                modifier = Modifier
                    .height(70.dp)
                    .padding(5.dp)
                    .clickable {
                        Toast
                            .makeText(context, "" + it, Toast.LENGTH_SHORT)
                            .show()
                    },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "item $it", fontSize = 18.sp)
                }
            }
        }
    }
}
