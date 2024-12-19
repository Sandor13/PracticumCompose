package com.practicum.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SimpleLazyColumnUnOptimized(List(1000) { it.toString() })
        }
    }
}

@Composable
fun SimpleLazyColumnUnOptimized(customItems: List<String>) {
    var photos by rememberSaveable { mutableStateOf(customItems) }

    Box {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(photos) { number ->
                PhotoView(number)
            }
        }

        Row(modifier = Modifier.align(BottomCenter)) {
            Button(onClick = {
                photos = photos.toMutableList().also {
                    it.add(0, "666")
                }
            }) {
                Text(text = "Add")
            }
            Button(onClick = { photos = photos.drop(1) }) {
                Text(text = "Remove")
            }
            Button(onClick = { photos = photos.shuffled() })
            {
                Text(text = "Shuffle")
            }
        }
    }
}

@Composable
fun PhotoView(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Photo,
                contentDescription = "Person",
                modifier = Modifier
                    .size(60.dp)
            )
            Text(
                text = name,
                modifier = Modifier.align(CenterVertically),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun SimpleColumnScreenPreview() {
    SimpleLazyColumnUnOptimized(List(1000) { it.toString() })
}