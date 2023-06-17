package com.example.jetblizcard

import android.graphics.Paint.Style
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetblizcard.ui.theme.JetBlizCardTheme
import com.example.jetblizcard.ui.theme.MontserratFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBlizCardTheme {
                CreateBlizCard()
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun CreateBlizCard() {

    val buttonClickState = remember {
        mutableStateOf(true)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        shadowElevation = 10.dp
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //  Profile Image
                CreateProfileImage()

                //  Divider line
                Divider(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    thickness = 1.dp
                )

                //  Person Information
                PersonInformation()

                // Portfolio Button
                Button(
                    modifier = Modifier
                        .padding(30.dp),
                    onClick = {
                        buttonClickState.value = !buttonClickState.value
                    },
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "Portfolio",
                        fontFamily = MontserratFamily,
                        fontWeight = FontWeight.Medium
                    )
                }

                if (buttonClickState.value) {
                    Content()
                }

            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(2.dp, Color.LightGray),
            color = Color.White
        ) {
            Portfolio(listOf("Project 1", "Project 2", "Project 3", "Project 4", "Project 5"))
        }
    }
}


@Composable
fun Portfolio(projects: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(projects) { project ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(80.dp),
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = "profile image"
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Column() {
                        Text(text = project, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.padding(vertical = 3.dp))
                        Text(text = "Hello project ${projects.indexOf(project) + 1}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            Divider()
        }
    }
}

@Composable
private fun PersonInformation() {
    //  Name
    Text(
        modifier = Modifier.padding(5.dp),
        text = "MAUSAM SARU MAGAR",
        color = MaterialTheme.colorScheme.primary,
        fontSize = 25.sp,
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.SemiBold
    )
    //  Position
    Text(
        modifier = Modifier.padding(bottom = 2.dp),
        text = "Android Developer | Kotlin",
        fontSize = 16.sp,
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.Medium
    )
    //  Profile Link
    Text(
        text = "linkedin.com/in/mausam-saru-magar/",
        fontSize = 16.sp,
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.Medium
    )
}

@Composable
private fun CreateProfileImage() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(10.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 5.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "profile picture"
        )
    }
}
