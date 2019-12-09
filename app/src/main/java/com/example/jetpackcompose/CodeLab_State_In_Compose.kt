package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.tooling.preview.Preview

@Model
class CounterState(var count: Int = 0)

// Simplified version of a typical AppState
class AppState(val counterState: CounterState = CounterState())


// ----data state
@Composable
fun MyScreenState(appState: AppState = AppState()) {
    Column {
        Counter(appState.counterState)
    }
}

// View.isInEditMode()
@Composable
fun Counter(state: CounterState) {
    Button(
        text = "I've been clicked ${state.count} times",
        onClick = {
            state.count++
        }
    )
}


@Preview("Data State Preview")
@Composable
fun DefaultPreviewState() {
    MyScreenState()
}
