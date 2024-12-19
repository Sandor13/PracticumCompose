package com.practicum.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SimpleColumnScreen()
        }
    }
}

@Composable
fun SimpleColumnScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(0))
    ) {
        repeat(1000) { value ->
            Text(text = value.toString(), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun SimpleColumnScreenPreview() {
    SimpleColumnScreen()
}