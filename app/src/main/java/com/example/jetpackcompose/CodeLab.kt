package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.Checkbox
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
// import androidx.ui.material.Button
// import androidx.ui.material.Checkbox
// import androidx.ui.material.ContainedButtonStyle
// import androidx.ui.material.Divider
// import androidx.ui.material.MaterialTheme
// import androidx.ui.material.surface.Surface

/**
 * https://codelabs.developers.google.com/codelabs/jetpack-compose-basics/index.html?index=..%2F..index#0
 */
@Composable
fun myScreenContent() {
    Column {
        Greeting_CodeLab(name = "Android")
        Divider(color = Color.Blue)
        Greeting_CodeLab(name = "iOS")
    }
}

@Composable
fun myButtonContent() {
    Column {
        EnableButton(text = "Button1", enable = true)
        EnableButton(text = "Button2", enable = true)
        EnableButton(text = "Button3", enable = true)
    }
}

// 当使用可组合函数作为参数时，请注意@composable中的额外括号。
// 因为注释是应用在函数上的，所以它们是必需的！
@Composable
fun myApp(child: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            child()
        }
    }
}

@Composable
fun Greeting_CodeLab(name: String) {
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

@Preview("Model CheckBox Preview")
@Composable
fun DefaultPreviewModelCheckBox() {
    MyScreenModelCheckBox()
}

@Composable
fun MyScreenModelCheckBox(appState: AppFormState = AppFormState()) {
    Column {
        Greeting_CodeLab("Android")
        Divider(color = Color.Black)
        Form(appState.formState)
    }
}

// Simplified version of a typical AppState
class AppFormState(val formState: FormState = FormState(true))

@Model
class FormState(var optionChecked: Boolean)

@Composable
fun Form(formState: FormState) {
    Checkbox(
        checked = formState.optionChecked,
        onCheckedChange = { newState -> formState.optionChecked = newState })
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
