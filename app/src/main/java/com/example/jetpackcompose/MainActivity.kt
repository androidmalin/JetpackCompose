package com.example.jetpackcompose

// import androidx.ui.layout.Column
// import androidx.ui.layout.Container
// import androidx.ui.layout.HeightSpacer
// import androidx.ui.layout.LayoutSize
// import androidx.ui.layout.Spacing
// import androidx.ui.layout.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // The setContent block defines the activity's layout
        setContent {
            NewsStory()
        }
    }
}

// Instead of defining the layout contents with an XML file, we call composable functions.
// Jetpack Compose uses a custom Kotlin compiler plugin to transform these composable functions into the app's UI elements
// To make a function composable, add the @Composable annotation
@Composable
fun NewsStory() {
    val image = +imageResource(R.drawable.header)
    MaterialTheme {
        // Column:The default settings stack all the children directly, one after another, with no spacing. The column itself is put in the content view's top left corner.
        // Column:内部的元素垂直排列,内部的元素彼此之间没有空隙;内部元素排列在左上方;
        Column(
            // crossAxisSize:
            crossAxisSize = LayoutSize.Expand,
            // modifier:修饰符;Spacing等价于xml中的padding,距离上下左右的间距
            modifier = Spacing(16.dp)
        ) {
            // 用于保存和排列其他ui元素的通用内容对象
            // 通过将expanded设置为true，可以指定容器的大小应与其父容器所允许的大小相同。
            Container(expanded = true, height = 180.dp) {
                // 剪载四个边角,将图形圆角化
                Clip(
                    shape = RoundedCornerShape(
                        topLeft = 2.dp,
                        bottomLeft = 2.dp,
                        topRight = 20.dp,
                        bottomRight = 20.dp
                    )
                ) {
                    DrawImage(image)
                }
            }

            // 分隔符
            HeightSpacer(30.dp)

            Text(
                "A day wandering through the sandhills in Shark " +
                        "Fin Cove, and a few of the sights I saw",
                // 最大两行,超出的部分使用...代替
                maxLines = 2, overflow = TextOverflow.Ellipsis,
                // withOpacity:设置透明度
                style = (+themeTextStyle { h6 }).withOpacity(0.87f)
            )
            Text(
                "Davenport, California",
                style = (+themeTextStyle { body2 }).withOpacity(0.87f)
            )
            Text(
                "December 2018",
                style = (+themeTextStyle { body2 }).withOpacity(0.6f)
            )
        }
    }
}

// Add the @Preview annotation before @Composable.
// It's a best practice to create separate preview functions that aren't called by the app;
//  having dedicated preview functions improves performance,
//  and also makes it easier to set up multiple previews later on.
// So, create a default preview function that does nothing but call the NewsStory() function.
@Preview
@Composable
fun DefaultPreview() {
    NewsStory()
}
