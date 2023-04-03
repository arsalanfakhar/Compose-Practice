package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    BirthdayGreetingWithImage("Happy Birthday Arsalan", "from Zanish")
//                    ComposeArticle(
//                        title = stringResource(id = R.string.article_title),
//                        message1 = stringResource(id = R.string.article_subtitle_1),
//                        message2 = stringResource(id = R.string.article_subtitle_2)
//                    )

//                    TaskCompletedCard(
//                        icon = painterResource(id = R.drawable.ic_task_completed),
//                        title = "All tasks completed",
//                        subtitle = "Nice work!"
//                    )
                    ComposeQuadrantCard()

                }
            }
        }
    }
}


@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.DarkGray), verticalArrangement = Arrangement.Center
    ) {
        BusinessCardHeader(
            painterResource(id = R.drawable.android_logo),
            "John Doe",
            "Senior Android Developer ",
            Modifier
                .fillMaxWidth()
                .weight(1F)
        )
        BusinessCardDetailsSection(
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BusinessCardHeader(icon: Painter, fullName: String, jobTitle: String, modifier: Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = icon, contentDescription = null, tint = Color.White, modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        )
        Text(text = fullName, color = Color.White, fontSize = 34.sp)
        Text(
            text = jobTitle,
            color = Color(0xFF3ddc84),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BusinessCardDetailsSection(modifier: Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Bottom) {
        BusinessCardDetailData(icon = painterResource(id = R.drawable.android_logo), data = "dede")
        BusinessCardDetailData(icon = painterResource(id = R.drawable.android_logo), data = "dede")
        BusinessCardDetailData(icon = painterResource(id = R.drawable.android_logo), data = "dede")
    }
}


@Composable
fun BusinessCardDetailData(icon: Painter, data: String) {
    Divider(color = Color.LightGray, thickness = 1.dp)
    Row(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon, contentDescription = "", modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .align(Alignment.CenterVertically)
                .fillMaxHeight()
        )
        Text(text = data, modifier = Modifier.align(Alignment.CenterVertically))
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    ComposePracticeTheme {
        BusinessCardApp()
    }
}


@Composable
fun ComposeQuadrantCard() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.weight(1F)) {
            QuadrantCard(
                title = "Text composable",
                subtitle = "Displays text and follows Material Design guidelines.",
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1F)
            )
            QuadrantCard(
                title = "Row composable",
                subtitle = "Displays text and follows Material Design guidelines.",
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1F)
            )
        }
        Row(modifier = Modifier.weight(1F)) {
            QuadrantCard(
                title = "Text composable",
                subtitle = "Displays text ",
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1F)
            )
            QuadrantCard(
                title = "Text composable",
                subtitle = "Displays text and follows Material Design guidelines.",
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    subtitle: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = subtitle,
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }
}


@Composable
fun ComposeArticle(title: String, message1: String, message2: String) {
    val image = painterResource(id = R.drawable.bg_compose_background)

    Column {
        Image(painter = image, contentDescription = null, modifier = Modifier.fillMaxWidth())
        Text(
            text = title,
            modifier = Modifier
                .wrapContentWidth()
                .padding(16.dp),
            fontSize = 24.sp,
            style = TextStyle(Color.Black)
        )
        Text(
            text = message1,
            modifier = Modifier
                .wrapContentWidth()
                .padding(16.dp),
            style = TextStyle(
                Color.Black,
                textAlign = TextAlign.Justify
            )
        )
        Text(
            text = message2,
            modifier = Modifier
                .wrapContentWidth()
                .padding(16.dp),
            style = TextStyle(Color.Black),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskCompletedCard(icon: Painter, title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(painter = icon, contentDescription = null, modifier = Modifier.fillMaxWidth())
        Text(
            text = title,
            modifier = Modifier
                .wrapContentWidth()
                .padding(16.dp),
            style = TextStyle(Color.Black),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify
        )
        Text(
            text = subtitle,
            modifier = Modifier
                .wrapContentWidth()
                .padding(start = 16.dp),
            style = TextStyle(Color.Black),
            textAlign = TextAlign.Justify
        )
    }
}


@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {

    val image = painterResource(id = R.drawable.asaan_banner_2)

    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message, from)
    }


}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {

    Column {
        Text(
            text = message,
            fontSize = 34.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 16.dp, start = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(top = 16.dp, start = 16.dp),
            style = TextStyle(color = Color.White)
        )
    }

}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeQuadrantAppPreview() {
    ComposePracticeTheme {
        ComposeQuadrantCard()
    }
}


//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskAppPreview() {
    ComposePracticeTheme {
        TaskCompletedCard(
            icon = painterResource(id = R.drawable.ic_task_completed),
            title = stringResource(id = R.string.article_title),
            subtitle = stringResource(id = R.string.article_subtitle_2)
        )
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeArticlePreview() {
    ComposePracticeTheme {
        ComposeArticle(
            title = stringResource(id = R.string.article_title),
            message1 = stringResource(id = R.string.article_subtitle_1),
            message2 = stringResource(id = R.string.article_subtitle_2)
        )
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposePracticeThemePreview() {
    ComposePracticeTheme {
        BirthdayGreetingWithImage("Happy Birthday Arsalan", "Zanish")
    }
}




