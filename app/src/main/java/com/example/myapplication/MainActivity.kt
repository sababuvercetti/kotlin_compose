package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserCard()
        }
    }
}


@Composable
fun Title() {
    val context = LocalContext.current
    return Text(
        text = "Simplified coding",
        fontSize = 32.sp,
        fontFamily = FontFamily.Cursive,
        color = colorResource(id = R.color.purple_500),
        modifier = Modifier.clickable {
            Toast.makeText(context, "Clicked text", Toast.LENGTH_LONG).show()
        }
    )
}

@Composable
fun UserCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .border(1.dp, color = Color.Gray)
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.person),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        Column() {
            Text(text = stringResource(id = R.string.dummy_text))
            Button(onClick = {
                //perform button click action
            }) {
                Text(text = "View Profile")
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
        UserCard()
    }
}
