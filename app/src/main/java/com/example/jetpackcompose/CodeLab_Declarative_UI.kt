package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview

/**
 * Compose遵循单一责任原则。
 * @Composable函数 仅仅用来表示单个功能，该功能完全由该函数封装。
 * 例如，如果要为某些组件设置背景色，则必须使用Surface可组合函数。
 * 你将无法使用任何其他内置组件设置背景色。
 * 回到我们的例子，为了设置文本和屏幕其他部分的背景色，我们需要定义一个Surface覆盖它的表面。
 *
 * 嵌套在Surface内的组件将绘制在该背景颜色的顶部（除非与另一个Surface另有指定）
 */
@Composable
fun Greeting_CodeLab_Basic(name: String) {
    Surface(color = Color.Yellow) {
        Text(text = "Hello $name!")
    }
}


/**
 * Modifiers
 *
 * 修饰符是为UI组件提供额外装饰/上下文的属性列表。
 * 现有的修饰符是：在灵活布局部分中，我们将看到行和列的间距、特征和修饰符。
 */
@Composable
fun Greeting_CodeLab_Modifiers(name: String) {
    Text(text = "Hello $name!", modifier = Spacing(24.dp))
}

/**
 * 组合可重用性
 * 我们向UI添加的组件越多，嵌套的级别就越高，就像代码库中的其他函数一样。
 * 如果函数变得非常大，这会影响可读性。
 * 通过创建可重用的小组件，很容易构建应用程序中使用的UI元素的小库。
 * 每个小组件负责屏幕的一小部分，可以独立编辑。
 * 让我们区分什么是我们应用程序的常见配置，什么是特定于特定视图的配置。
 * 当我们重构UI代码时，我们必须用@Composable注释来标记我们的函数，
 * 该注释告诉编译器这是一个可组合函数。
 * 编译器还执行一些强制操作，例如必须从另一个可组合函数调用该函数。
 *
 * 请注意，@Composable注释仅对UI函数和更改其他可组合函数（例如，Clickable）行为的函数是必需的。
 * 它们可以调用常规和其他复合函数。
 * 如果一个函数不满足这些要求，就不应该用@Composable来注释它。
 *
 * 我们应该在Activity类中放置尽可能少的代码，因为它不能被共享。
 * Activity之外的代码越多，我们可以重用的就越多。
 *
 * 我们希望在不同的活动中重用MyApp Composable函数，因为它定义了可以在多个地方使用的顶级配置。
 * 但是，它的当前状态不允许它，因为它嵌入了Greeting_CodeLab_Modifiers()函数。
 */
@Composable
fun MyApp() {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            Greeting_CodeLab_Modifiers("Android");
        }
    }
}

/**
 * Making container functions
 * 如果我们想要创建一个容器，其中包含我们应用程序的所有公共配置，会怎么样？
 * 为了创建一个泛型容器，我们创建了一个可组合函数，
 * 它将可组合函数（我们称之为子函数）的lambda作为参数并返回Unit。
 * 我们返回Unit是因为，正如你可能已经注意到的，所有可组合函数都返回Unit。
 *
 * 当使用可组合函数作为参数时，请注意@Composable中的额外括号。
 * 因为注释是应用在函数上的，所以它们是必需的！
 * fun MyApp(child: @Composable() () -> Unit) { ... }
 *
 * 在容器的方法中，我们提供了希望其子级拥有的所有共享配置。
 * 在这种情况下，我们希望对所有子类应用MaterialTheme和黄色背景色。
 * 这就是为什么我们将child()作为Surface的参数，Surface是我们调用的最后一个可组合函数。
 * 这个使容器可组合函数成为提高可读性和鼓励重用代码的良好实践。
 */
@Composable
fun MyApp_New(child: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            child()
        }
    }
}

/**
 * 多次调用可组合函数
 * 我们将UI组件提取到可组合函数中，因为我们可以重用它们而不必重复代码。
 * 在下面的例子中，我们可以用不同的参数来展示两个问候语重用同一个可组合函数。
 * 要以垂直顺序放置项，我们使用Column Composable函数。
 * Divider是一个提供的可组合函数，用于创建水平分割线。
 *
 * 当一个可组合函数被调用时，它将被添加到Compose UI层次结构树中，其中包含从其他数据中调用它的位置获得的信息。
 * 这样，你可以从代码的多个部分调用同一个函数（具有可能不同的参数），并且每次都会将组件添加到UI树中。
 * 你可以将其视为创建了函数实例并将其添加到UI树中。
 */
@Composable
fun MyApp_Multiple_Time() {
    Column {
        Greeting_CodeLab_Modifiers("Android");
        Divider(color = Color.Black)
        Greeting_CodeLab_Modifiers("iOS");
    }
}

@Preview("Declarative UI preview")
@Composable
fun Preview_CodeLab_DeclarativeUI() {
    MyApp_New {
        MyApp_Multiple_Time()
    }
}
