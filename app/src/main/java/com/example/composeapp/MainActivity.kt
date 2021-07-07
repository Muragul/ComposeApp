package com.example.composeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ChangeSizeAndAlignment("Android")
//            ChangeModifiers()
            val painter = painterResource(id = R.drawable.image)
            val description = "Team work joke image"
            val title = "Some title"
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)
            ) {
                CreateImageCardWithTitle(
                    painter = painter,
                    description = description,
                    title = title
                )
            }
        }
    }
}

@Composable
fun ChangeSizeAndAlignment(name: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
//            .fillMaxWidth(0.6f)
//            .fillMaxHeight(0.4f)
//            .width(300.dp)
//            .height(300.dp)
//            .fillMaxSize(0.5f)
            .background(Color.Green),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Hello")
        Text(name)
        Text("!!!")
    }
}

@Composable
fun ChangeModifiers() {
    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .width(300.dp)
            .height(300.dp)
//            .requiredWidth(300.dp)
//            .padding(top = 16.dp, start = 32.dp)
            .border(5.dp, Color.Magenta)
            .padding(15.dp)
            .border(5.dp, Color.Gray)
            .padding(25.dp)
            .border(5.dp, Color.Green)
            .padding(5.dp)
    ) {
        Text(
            "Hello",
            modifier = Modifier
                .border(5.dp, Color.DarkGray)
                .padding(5.dp)
                .offset(20.dp, 20.dp)
                .border(10.dp, Color.DarkGray)
                .padding(10.dp)
                .clickable {}
//                .draggable()
//                .scrollable()
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text("World")
    }
}

@Composable
fun CreateImageCardWithTitle(
    painter: Painter,
    description: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 150f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }

}

@Composable
fun StyleText() {
    val fontFamily = FontFamily(
        Font(R.font.manrope_medium, FontWeight.Medium)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Text(
            text = buildAnnotatedString {
                append("New")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp
                    )
                ) {
                    append("Styled")
                }
                append("Text")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    val painter = painterResource(id = R.drawable.image)
//    val description = "Team work joke image"
//    val title = "Some title"
//    CreateImageCardWithTitle(
//        painter = painter,
//        description = description,
//        title = title
//    )
}