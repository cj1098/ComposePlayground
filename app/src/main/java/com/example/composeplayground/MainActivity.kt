package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.layouts.Direction
import com.example.composeplayground.layouts.SplitColumn
import com.example.composeplayground.layouts.SplitRow
import com.example.composeplayground.layouts.SplitRowLayoutComposable
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                SplitRow(modifier = Modifier.fillMaxWidth(), composables = listOf(
                    SplitRowLayoutComposable(direction = Direction.START) { Text(text = "testText") },
                    SplitRowLayoutComposable(direction = Direction.END) { RadioButton(selected = true, onClick = {  }) }))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplitRowPreview() {
    SplitRow(modifier = Modifier.fillMaxWidth(), composables = listOf(
        SplitRowLayoutComposable(direction = Direction.START) { Text(text = "testText") },
        SplitRowLayoutComposable(direction = Direction.END) { RadioButton(selected = true, onClick = {  }) },
        SplitRowLayoutComposable(direction = Direction.END) { Text(text = "oooooh") },
        SplitRowLayoutComposable(direction = Direction.START) { Text(modifier = Modifier.offset(x = 16.dp) ,text = "oooooh") }))
}

@Preview(showBackground = true)
@Composable
fun SplitColumnPreview() {
    SplitColumn(modifier = Modifier.fillMaxHeight(), composables = listOf(
        SplitRowLayoutComposable(direction = Direction.START) { Text(text = "testText") },
        SplitRowLayoutComposable(direction = Direction.END) { RadioButton(selected = true, onClick = {  }) },
        SplitRowLayoutComposable(direction = Direction.END) { Text(text = "oooooh") },
        SplitRowLayoutComposable(direction = Direction.START) { Text(modifier = Modifier.offset(x = 16.dp) ,text = "oooooh") }))
}