package com.vitassalvantes.composelayoutscodelab

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitassalvantes.composelayoutscodelab.ui.theme.ComposeLayoutsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutsApp {
                MyScreenContent()
            }
        }
    }
}

/**
 * Container function that sets theme and color for all elements on screen
 */
@Composable
fun ComposeLayoutsApp(content: @Composable (Modifier) -> Unit) {
    ComposeLayoutsCodelabTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "ComposeLayoutsApp")
                    }
                )
            }
        ) { innerPadding ->
            content(Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun MyScreenContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeLayoutsAppPreview() {
    ComposeLayoutsApp {
        MyScreenContent()
    }
}