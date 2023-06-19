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
                     // Sign in or Sign up button
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = textFieldPadding1,
                        end = textFieldPadding1,
                        top = textFieldPadding1
                    ),
                shape = RoundedCornerShape(cornerRadius1),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                onClick = {
                    showToast(context = context, message = "Click: Button")
                }) {
                Text(
                    text = if (isSignUp) "Sign Up" else "Sign In",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider1()
                Text(
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    text = if (isSignUp) "Or Sign up with" else "Or Sign in with",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                        fontSize = 16.sp,
                        letterSpacing = 1.sp,
                        color = Color.Black
                    )
                )
                Divider1()
            }

            Row(
                modifier = Modifier.padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SignupWithIcons1(
                    iconRes = R.drawable.logo_google,
                    contentDescription = if (isSignUp) "Sign up with Google" else "Sign in with Google",
                    context = context
                )
                SignupWithIcons1(
                    iconRes = R.drawable.logo_facebook,
                    contentDescription = if (isSignUp) "Sign up with Facebook" else "Sign in with Facebook",
                    context = context
                )
            }
        }

        val textBottom1 = if (isSignUp) "Already a member? " else "Don’t have an account? "
        val textBottom2 = if (isSignUp) "Sign In" else "Sign Up"

        Row(
            modifier = Modifier.padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = textBottom1,
                color = Color.Black,
                fontFamily = FontFamily(
                    Font(
                        R.font.roboto_medium,
                        weight = FontWeight.Medium
                    )
                ),
                fontSize = 16.sp
            )

            Text(
                modifier = Modifier.clickable {
                    showToast(context = context, message = "Click")
                },
                text = textBottom2,
                color = MaterialTheme.colors.primary,
                fontFamily = FontFamily(
                    Font(
                        R.font.roboto_bold,
                        weight = FontWeight.Bold
                    )
                ),
                fontSize = 16.sp
            )

        }
    }
}

@Composable
private fun SignupWithIcons1(iconRes: Int, contentDescription: String, context: Context) {
    OutlinedButton(
        modifier = Modifier.size(46.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(8.dp),
        border = BorderStroke(0.dp, Color.Transparent),
        elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
        onClick = {
            showToast(context = context, message = "Click")
        }) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            tint = Color.Unspecified
        )
    }
}


@Composable
private fun Divider1() {
    Divider(
        modifier = Modifier.width(64.dp),
        color = Color(0xFF333333),
        thickness = 1.dp
    )
}

@Composable
private fun LoginSignup1TextFiled(
    text: String,
    hint: String,
    leadingIcon: ImageVector,
    onText: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = textFieldPadding1,
                end = textFieldPadding1,
                top = textFieldPadding1
            )
            .background(Color.White, RoundedCornerShape(cornerRadius1)),
        value = text,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = Color.White,
            cursorColor = MaterialTheme.colors.primary
        ),
        onValueChange = {
            onText(it)
        },
        singleLine = true,
        shape = RoundedCornerShape(cornerRadius1),
        textStyle = loginSignup1TextField(MaterialTheme.colors.primary),
        placeholder = {
            Text(
                text = hint,
                style = loginSignup1TextField(Color(0xFF808080))
            )
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = hint,
                tint = MaterialTheme.colors.primary
            )
        }
    )
}

@Composable
private fun loginSignup1TextField(textColor: Color) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
    letterSpacing = 1.sp,
    color = textColor
)

private fun showToast(context: Context, message: String) {
    Toast.makeText(
        context.applicationContext,
        message,
        Toast.LENGTH_SHORT
    ).show()
} 
