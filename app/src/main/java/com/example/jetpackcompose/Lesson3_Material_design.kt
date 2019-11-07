package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
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
// import androidx.ui.layout.Container
// import androidx.ui.layout.HeightSpacer
// import androidx.ui.layout.LayoutSize
// import androidx.ui.layout.Column
// import androidx.ui.layout.Spacing

/**
 * Material design Apply a shape
 *
 *Compose是为支持材料设计原则而构建的。
 *它的许多UI元素实现了开箱即用的材料设计。
 *在本课中，您将使用材质小部件设置应用程序的样式。
 *
 * 使用Clip（）函数使图像的角变圆。
 * Shape是不可见的，但是图形被裁剪以适合形状，因此现在它有一些圆角。
 */
@Composable
fun MaterialDesignFunction() {
    Column(
        crossAxisSize = LayoutSize.Expand,
        modifier = Spacing(10.dp)
    ) {
        val image = +imageResource(R.drawable.header)
        Container(expanded = true, height = 180.dp) {
            Clip(shape = RoundedCornerShape(8.dp)) {
                DrawImage(image)
            }
        }
        HeightSpacer(16.dp)
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

/**
 * Style the text
 *
 * 这些更改很微妙，但文本现在使用MaterialTheme的默认文本样式。
 * 接下来，对每个文本元素应用特定的段落样式。
 *
 * 材质调色板使用一些基本颜色。
 * 若要强调部分文本，请调整文本不透明度。
 */
@Composable
fun MaterialDesignFunction_add_style_text() {
    MaterialTheme {
        Column(
            crossAxisSize = LayoutSize.Expand,
            modifier = Spacing(10.dp)
        ) {
            val image = +imageResource(R.drawable.header)
            Container(expanded = true, height = 180.dp) {
                Clip(shape = RoundedCornerShape(8.dp)) {
                    DrawImage(image)
                }
            }
            HeightSpacer(16.dp)
            Text(
                "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
                maxLines = 2, overflow = TextOverflow.Ellipsis,
                style = (+themeTextStyle { h6 }).withOpacity(0.87f)
            )
            Text("Davenport, California", style = (+themeTextStyle { body1 }).withOpacity(0.87f))
            Text("December 2018", style = (+themeTextStyle { body2 }).withOpacity(0.6f))
        }
    }
}

@Preview
@Composable
fun PreviewMaterialDesign() {
    MaterialDesignFunction_add_style_text()
}
