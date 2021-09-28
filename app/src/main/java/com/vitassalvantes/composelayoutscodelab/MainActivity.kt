package com.vitassalvantes.composelayoutscodelab

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import androidx.constraintlayout.widget.ConstraintLayout
import com.vitassalvantes.composelayoutscodelab.ui.theme.ComposeLayoutsCodelabTheme
import kotlinx.coroutines.NonDisposableHandle.parent

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
fun ComposeLayoutsApp(content: @Composable () -> Unit) {
    ComposeLayoutsCodelabTheme {
        Scaffold(
            topBar = {
                MyTopAppBar()
            }
        ) {
            content()
        }
    }
}

@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "ComposeLayoutsApp")
        },
        actions = {
            IconButton(onClick = { /*Do something*/ }) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        }
    )
}

@Composable
fun MyScreenContent() {
    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin= margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeLayoutsAppPreview() {
    ComposeLayoutsApp {
        MyScreenContent()
    }
}