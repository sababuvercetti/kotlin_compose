package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
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
            UserList()
        }
    }
}


@Composable
fun UserList() {
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        for(i in 1..10){
//            UserCard()
//        }
//    }

    LazyColumn() {
        items((users)) {
            UserCard()
        }
    }
}

data class User(
    val id: Int
)

val users = listOf<User>(
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1)
)


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
    Card(
        elevation = 4.dp, modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
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

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
        UserList()
    }
}
