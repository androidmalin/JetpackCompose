package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

/**
 * https://developer.android.com/jetpack/compose/tutorial
 *
 * 首先，按照JetPack编写安装说明，使用空的编写Activity模板创建一个应用程序。
 * 然后将文本元素添加到空白Activity中
 * 通过定义一个内容块并调用Text()函数来实现。
 * setContent块定义Activity的布局
 * 我们不使用XML文件定义布局内容，而是调用可组合函数。
 * JetPack Compose使用自定义的Kotlin编译器插件将这些可组合函数转换为应用程序的UI元素。
 * 例如，Text()函数由Compose UI库定义;
 * 你可以调用该函数来声明应用程序中的文本元素。
 */
@Composable
fun TextUI() {
    Text("Hello World")
}

/**
 *  定义可组合函数
 *  可组合函数只能在其他可组合函数的范围内调用。
 *  若要定义函数可组合，请添加@Composable注释
 *  若要尝试此操作，请定义一个传递名称的Greeting()函数，
 *  并使用该名称配置文本元素。
 */
@Composable
fun GreetingNew(name: String) {
    Text("Hello $name!")
}

/**
 * 主要限制是，可组合函数不能接受任何参数。因此，不能直接预览Greeting()函数
 * 相反，创建另一个名为PreviewGreeting()的函数，该函数使用适当的参数调用Greeting()。
 * 在@Composable之前添加@Preview注解。
 */
@Preview
@Composable
fun previewBaseFunction() {
    MaterialTheme {
        Column {
            TextUI()
            GreetingNew("Android")
        }
    }
}
