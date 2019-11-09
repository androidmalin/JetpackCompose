package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.tooling.preview.Preview

/**
 * 可组合函数是用@Composable注释标记的Kotlin函数
 *
 * 要创建可组合函数，只需将@Composable注释添加到函数定义中。
 * 这将使你的函数能够在使用其他@Composable函数中调用。
 * 该示例将生成一个UI层次结构，其中的可组合的文件组件显示给定的输入字符串。
 *
 * 在底层，Compose使用一个自定义的Kotlin编译器插件，
 * 当底层数据发生更改时，可以重新调用可组合函数来更新UI层次结构
 *
 * Activity仍然是Android应用程序的入口点。
 *
 * 我们使用setContent来定义我们的布局，但是我们并没有像往常那样使用XML文件，而是在其中调用可组合函数
 */
@Composable
fun Greeting_CodLab(name: String) {
    Text(text = "Hello $name!")
}

@Preview("Text Preview")
@Composable
fun preview_() {
    Greeting_CodLab("Android")
}
