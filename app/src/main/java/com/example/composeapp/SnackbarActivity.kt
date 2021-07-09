package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class SnackbarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowDialog()
        }
    }
}

@Composable
fun ShowSnackbar(name: String) {
    Snackbar {
        Text(text = "Hello $name!")
    }
}

@Composable
fun ShowDialog() {
    val state = rememberScaffoldState()
    var textState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = state
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            TextField(
                value = textState,
                label = {
                    Text("Enter your name")
                },
                onValueChange = {
                    textState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    state.snackbarHostState.showSnackbar("Hello $textState")
                }
            }) {
                Text(text = "Click me")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ShowDialog()
//    ShowSnackbar(name = "World")
}