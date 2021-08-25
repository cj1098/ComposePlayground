package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.layouts.SplitRow
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                SplitRow(modifier = Modifier.fillMaxSize(),composables = listOf({ Text(text = "testText") }, { RadioButton(
                    selected = true,
                    onClick = { /*TODO*/ }) }))
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        SplitRow(modifier = Modifier.fillMaxSize(), composables = listOf({ Text(text = "testText") }, { Button(
            onClick = {  }, content = {
                Text(text = "test") }) }))
    }
}