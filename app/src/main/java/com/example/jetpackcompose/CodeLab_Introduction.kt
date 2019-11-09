package com.example.jetpackcompose

import androidx.compose.Composable

/**
 * https://codelabs.developers.google.com/codelabs/jetpack-compose-basics/index.html?index=..%2F..index#0
 *
 * JetPack Compose是一个现代化的工具包，旨在简化UI开发。
 * 它结合了响应式编程模型和Kotlin语言的简洁性和易用性。
 * 它是完全声明性的，允许通过调用可组合函数来描述用户界面
 * 然后，框架在背后处理UI优化，当底层状态改变时，会自动更新视图层次结构。
 * 组合应用程序由可组合函数组成，这些可组合函数将应用程序数据转换为UI层次结构。
 * 函数是创建新的可组合项所需的全部。
 * Compose允许我们将代码构造成称为composables的小块composable只是一个用@composable标记的函数，它可以调用其他composable。
 * 通过创建可重用的小组件-很容易构建应用程序中使用的UI元素的小库。
 * 每个人负责屏幕的一小部分，可以独立编辑。
 */
@Composable
fun baseUI() {
}
