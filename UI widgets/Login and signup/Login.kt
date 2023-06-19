import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
Helpful links to understand the code:

Status Bar Customization:
https://semicolonspace.com/status-bar-jetpack-compose/

Shape APIs:
https://semicolonspace.com/shapes-android-jetpack-compose/

State in Jetpack Compose:
https://semicolonspace.com/android-jetpack-compose-state/

Row, Column, and Box with Examples:
https://semicolonspace.com/jetpack-compose-row-column-box/

Padding and Margin:
https://semicolonspace.com/jetpack-compose-padding-margin/

 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogPostsTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        LoginSignup1(isSignUp = false)
                    }
                }
            }
        }
    }
}

private val textFieldPadding1 = 32.dp
private val cornerRadius1 = 25.dp

@Composable
fun LoginSignup1(
    isSignUp: Boolean,
    context: Context = LocalContext.current
) {

    var textFullName by remember {
        mutableStateOf("")
    }
    var textPhone by remember {
        mutableStateOf("")
    }

    var textEmail by remember {
        mutableStateOf("")
    }

    var textPassword by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .background(Color(0xFFEEEEEE))
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = if (isSignUp) "Create Account" else "Welcome back!",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                    fontSize = 30.sp,
                    letterSpacing = 1.sp,
                    color = Color.Black
                )
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = if (isSignUp) "Sign up to get started" else "Sign in to your account",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                    fontSize = 18.sp,
                    letterSpacing = 1.sp,
                    color = Color.Black
                )
            )

            // Full name text field
            if (isSignUp) {
                LoginSignup1TextFiled(
                    text = textFullName,
                    hint = "Full Name",
                    leadingIcon = Icons.Outlined.Person
                ) {
                    textFullName = it
                }
            }


            // Email text filed
            LoginSignup1TextFiled(
                text = textEmail,
                hint = "Email",
                leadingIcon = Icons.Outlined.Email,
                onText = {
                    textEmail = it
                })


            // Phone text field
            if (isSignUp) {
                LoginSignup1TextFiled(
                    text = textPhone,
                    hint = "Phone Number",
                    leadingIcon = Icons.Outlined.Phone
                ) {
                    textPhone = it
                }
            }

            // Password text filed
            LoginSignup1TextFiled(
                text = textPassword,
                hint = "Password",
                leadingIcon = Icons.Outlined.Lock,
                onText = {
                    textPassword = it
                })
