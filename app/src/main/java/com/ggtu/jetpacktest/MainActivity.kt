package com.ggtu.jetpacktest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.ggtu.jetpacktest.ui.theme.JetPackTestTheme
import com.ggtu.jetpacktest.viewmodel.DiceViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackTestTheme {
                // A surface container using the 'background' color from the theme
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    val diceViewModel = DiceViewModel()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(Icons.Filled.Refresh, contentDescription = "Обновить") },
                onClick = {diceViewModel.roll()},
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                imageVector = ImageVector.vectorResource(diceViewModel.diceDetailState.value),
                contentDescription = "Кубик",
                alignment = Alignment.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackTestTheme {
        Greeting()
    }
}