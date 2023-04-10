package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(bgColor: Color, title: String, text: String) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    Column(
        modifier = Modifier
            .height((screenHeight * 0.5).dp)
            .width((screenWidth * 0.5).dp)
            .background(color = bgColor)
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
            text = text
        )
    }
}

@Composable
fun ComposeQuadrant() {
    Column() {
        Row {
            Quadrant(
                bgColor = Color.Green,
                title = stringResource(R.string.text_composable),
                text = stringResource(R.string.text_composable_text)
            )
            Quadrant(
                bgColor = Color.Yellow,
                title = stringResource(R.string.image_composable),
                text = stringResource(R.string.image_composable_text)
            )
        }

        Row {
            Quadrant(
                bgColor = Color.Cyan,
                title = stringResource(R.string.row_composable),
                text = stringResource(R.string.row_composable_text)
            )
            Quadrant(
                bgColor = Color.LightGray,
                title = stringResource(R.string.column_composable),
                text = stringResource(R.string.column_composable_text)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ComposableQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}