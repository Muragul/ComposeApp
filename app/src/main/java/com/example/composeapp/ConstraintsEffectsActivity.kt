package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import kotlinx.coroutines.delay

class ConstraintsEffectsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectComposable()
        }
    }
}

@Composable
fun EffectComposable() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {
//        var counter = produceState(initialValue = 0) {
//            delay(3000L)
//            value = 4
//        }
        var counter by remember {
            mutableStateOf(0)
        }
        if (counter % 5 == 0 && counter > 0) {
            LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                scaffoldState.snackbarHostState.showSnackbar("Toast message")
            }
        }
        Button(onClick = { counter++ }) {
            Text(text = "Click me: $counter")
        }
    }
}

@Composable
fun SetConstraintLayout() {
    val constraints = ConstraintSet {
        val firstBox = createRefFor("firstBox")
        val secondBox = createRefFor("secondBox")
        val guideline = createGuidelineFromTop(0.5f)

        constrain(firstBox) {
//            top.linkTo(parent.top)
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(secondBox) {
            top.linkTo(parent.top)
            start.linkTo(firstBox.end)
            end.linkTo(parent.end)
//            width = Dimension.fillToConstraints
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(
            firstBox, secondBox,
            chainStyle = ChainStyle.Packed
        )
    }

    ConstraintLayout(
        constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .layoutId("firstBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("secondBox")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    EffectComposable()
}