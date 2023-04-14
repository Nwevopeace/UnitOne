package com.example.unitone

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitone.ui.theme.UnitOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeTutorial("Welcome", "Content")
                }
            }
        }
    }
}

@Composable
fun ComposeTutorial(title: String, description: String) {
    val image = painterResource(id = R.drawable.jet)
    Column {
        Spacer(modifier = Modifier.padding(30.dp))
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .border(1.5.dp, MaterialTheme.colors.secondary)
        )
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.caption
        )
        Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp, color = MaterialTheme.colors.secondary) {
            Text(
                text = description,
                modifier = Modifier.padding(16.dp),
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.body1
            )
            //  Text(text = description1, modifier = Modifier.padding(16.dp), fontSize = 16.sp, textAlign = TextAlign.Justify)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "JetPack Compose", showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    UnitOneTheme {
        ComposeTutorial(
            stringResource(id = R.string.title),
            stringResource(id = R.string.description)
            // stringResource(id = R.string.description1)
        )
    }
}