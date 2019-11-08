package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.tooling.preview.Preview

@Composable
fun Greeting() {
    Text(text = "Hello World")
}

@Preview
@Composable
fun PreviewGreeting() {
    Greeting()
}