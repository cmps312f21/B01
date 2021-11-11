package com.cmps312.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.cmps312.todoapp.component.GoogleSignInButton
import com.cmps312.todoapp.ui.theme.Lab11Theme
import com.cmps312.todoapp.utils.AuthenticationResult
import com.cmps312.todoapp.viewmodel.SignInViewModel
import com.cmps312.todoapp.viewmodel.TodoViewModel
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    //Todo ger the signin view model
    private val signInViewModel: SignInViewModel by viewModels()
    private val todoViewModel: TodoViewModel by viewModels()
    private val loggedIn = mutableStateOf<Boolean>(false)
    private val userExits = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Todo add firebase auth listner
        Firebase.auth.addAuthStateListener {
            userExits.value = it.currentUser?.uid != null
        }

        setContent {
            Lab11Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Todo add the condition here
                    if(userExits.value)   MainScreen() else SignInScreen(signInViewModel)
                }
            }
        }
    }
}


//Todo add AuthView
@Composable
fun AuthView(
    errorText: String?,
    onClick: () -> Unit,
) {
    var isLoading by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Login Page") }) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            GoogleSignInButton(
                text = "Sign In Using Google",
                icon = painterResource(id = R.drawable.btn_google_light),
                loadingText = "Signing in ...",
                isLoading = isLoading,
                onClick = {
                    isLoading = true
                    onClick()
                }
            )

            errorText?.let {
                isLoading = false
                Text(text = it)
            }

        }
    }
}

//Todo add SignInScreen
@Composable
fun SignInScreen(signInViewModel: SignInViewModel) {
    val scope = rememberCoroutineScope()
    var errorText by remember { mutableStateOf<String?>(null) }
    val user by remember(signInViewModel) { signInViewModel.user }.collectAsState()
    val singInRequestCode = 101
    val authenticationLauncher = rememberLauncherForActivityResult(contract = AuthenticationResult()) { task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if(account == null)
                    errorText =  "Failed to sign in to Google"
                else{
                    scope.launch {
                        signInViewModel.setSignInInfo(account.email!!, account.displayName!!)
                    }
                }

            } catch (e : ApiException){
                errorText = e.localizedMessage
            }
        }

    AuthView(errorText, onClick = {
        errorText = null
        authenticationLauncher.launch(singInRequestCode)
    })

    user?.let {
        MainScreen()
    }
}