package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.tooling.preview.Preview

// 布局方面是一个纵向的列表，第一项是我们之前写的那个错误框，通过给它包装一层 Clickable 将它变成可点击的 View，
// onClick 就是我们点击时执行的方法，错误框下面是纵向排列的 Text，有多少条数据就有多少条 Text。
// 数据方面 DataList 是我们创建的一个维护数据的类，你可以看到它被 @Model 注解所标识，
// 那么就意味着，我们 DataList 中的 users 是一个可监听对象，
// 当我们执行点击事件插入数据的时候，位于 @Composable 方法中的 DataList.users 会自动收到更新，然后执行循环体，更新 UI。
@Composable
fun newView() {
    Column(Spacing(10.dp)) {
        Clickable(onClick = DataList::addUser) {
            Text("Click")
        }
        DataList.users.forEach {
            Text(it.name)
        }
    }
}

data class User(val name: String)

// Jetpack Compose 中引入了一个 @Model 注解，我们只需要在对应的数据类上面标示该注解，
// 那么数据类中的所有属性，就会变成一个可观察对象。当我们有了一个可监听变化数据类，那么该如何监听数据的变化呢？
// 答案是：不需要监听，直接用就好了！
@Model
object DataList {
    var users = emptyList<User>()
    fun addUser() {
        users = users + User("Jake")
    }
}

@Preview
@Composable
fun DefaultPreview3() {
    newView()
}
