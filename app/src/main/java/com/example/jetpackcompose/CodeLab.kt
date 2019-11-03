package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview

/**
 * https://codelabs.developers.google.com/codelabs/jetpack-compose-basics/index.html?index=..%2F..index#0
 */

@Composable
fun myScreenContent() {
    Column {
        Greeting(name = "Android")
        Divider(color = Color.Blue)
        Greeting(name = "iOS")
    }
}

@Composable
fun myButtonContent() {
    Column {
        EnableButton(text = "Button1", enable = true)
        EnableButton(text = "Button2", enable = true)
        EnableButton(text = "Button3", enable = true)
        EnableButton(text = "Button4", enable = true)
        EnableButton(text = "Button5", enable = true)
        EnableButton(text = "Button6", enable = true)
        EnableButton(text = "Button7", enable = true)
        EnableButton(text = "Button8", enable = true)
        EnableButton(text = "Button9", enable = true)
        EnableButton(text = "Button10", enable = true)
    }
}


//当使用可组合函数作为参数时，请注意@composable中的额外括号。
//因为注释是应用在函数上的，所以它们是必需的！
@Composable
fun myApp(child: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            child()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name", modifier = Spacing(24.dp))
}

val myNames = listOf("Android", "iOS", "React")
@Composable
fun MyExampleFunction(names: List<String> = myNames) {
    Column {
        for (name in names) {
            Text(text = name)
        }
    }
}

@Composable
fun EnableButton(text: String, enable: Boolean) {
    Button(
        text = text, style = ContainedButtonStyle(
            color = if (enable) Color.White else Color.Gray
        )
    )
}


@Preview("Data State Preview")
@Composable
fun DefaultPreviewState() {
    MyScreenState()
}

//----data state
@Composable
fun MyScreenState(appState: AppState = AppState()) {
    Column {
        Greeting("Android")
        Divider(color = Color.Black)
        Greeting("iOS")
        Divider(color = Color.Transparent, height = 32.dp)
        Counter(appState.counterState)
    }

}

// Simplified version of a typical AppState
class AppState(val counterState: CounterState = CounterState())

@Model
class CounterState(var count: Int = 0)

@Composable
fun Counter(state: CounterState) {
    Button(text = "I've been clicked ${state.count} times",
        onClick = {
            state.count++
        }
    )
}

@Preview("Text Preview")
@Composable
fun DefaultPreviewMyApp() {
    myApp {
        myScreenContent()
    }
}

@Preview("Kotlin Preview")
@Composable
fun DefaultPreviewKotlin() {
    myApp {
        MyExampleFunction()
    }
}

@Preview("Button Preview")
@Composable
fun DefaultPreviewButton() {
    myApp {
        EnableButton(text = "Button", enable = true)
    }
}
