package com.example.jetpackcompose

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Spacing
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
// import androidx.ui.layout.Container
// import androidx.ui.layout.HeightSpacer
// import androidx.ui.layout.LayoutSize
// import androidx.ui.layout.Column
// import androidx.ui.layout.Spacing

/**
 * Start with some Text
 *
 * UI元素是分层的，元素包含在其他元素中。
 * 在Compose中，通过从可组合函数调用其他的可组合函数来构建UI层次结构。
 * 以下的代码在内容视图中创建三个文本元素。
 * 但是，由于我们没有提供任何关于如何排列的信息，
 * 这三个文本元素相互重叠，使文本不可读。
 */
@Composable
fun NewsStory_Add_Text() {
    Text("A day in Shark Fin Cove")
    Text("Davenport, California")
    Text("December 2018")
}

/**
 * Using a Column
 *
 * Column()函数的作用是垂直堆叠元素。
 * 默认设置直接堆叠所有子项，一个接一个，没有间距。
 * 列本身放在内容视图的左上角。
 */
@Composable
fun NewsStory_Use_Column() {
    Column {
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

/**
 * Add style settings to the column
 * crossAxisSize==>横轴尺寸：指定列沿其十字（水平）轴的大小。
 * LayoutSize.Expand==>指定列应尽其父级所允许的宽度。
 *
 * modifier: 修饰符: 允许您进行其他格式更改。
 * Spacing: 间距修饰符，将列设置为与周围视图无关。
 */
@Composable
fun NewsStory_Add_Style_To_Column() {
    Column(
        crossAxisSize = LayoutSize.Expand,
        modifier = Spacing(16.dp)
    ) {
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

/**
 * Add a picture
 * 您需要应用程序的上下文从资源中获取图像，然后调用DrawImage（）将图形添加到应用程序中。
 * 图像的比例会不正确，但没关系-你会在下一步解决这个问题。
 */
@Composable
fun NewsStory_add_picture() {
    val image = +imageResource(R.drawable.header)
    Column(
        crossAxisSize = LayoutSize.Expand,
        modifier = Spacing(16.dp)
    ) {
        //ImageView.ScaleType.CENTER_CROP
        DrawImage(image)
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

/**
 * add Container
 * 图形将添加到布局中，但它将展开以填充整个视图，并在其上显示文本。
 * 要设置图形的样式，请将其放在容器(一个用于保存和排列其他UI元素的通用内容对象)中
 * 然后可以将大小和位置设置应用于容器。
 *
 * Container中 expanded：指定容器的大小，默认值为false（使容器成为其子容器的大小）
 * Container 通过将expanded设置为true，可以指定容器的大小应与其父容器所允许的大小相同。
 *
 * Container中height：指定容器的高度。高度设置优先于展开设置；
 * 结果是，容器的尺寸为180dp的高度，但是宽度是其父允许的最大值。
 */
@Composable
fun NewsStory_add_a_container_wrapper_image() {
    val image = +imageResource(R.drawable.header)
    Column(
        crossAxisSize = LayoutSize.Expand,
        modifier = Spacing(16.dp)
    ) {
        Container(expanded = true, height = 180.dp) {
            //ImageView.ScaleType.CENTER_CROP
            DrawImage(image)
        }

        // Add a spacer to separate the graphic from the headings.
        HeightSpacer(16.dp)

        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

/**
 * 拥有专用的预览功能可以提高性能，并使以后设置多个预览更加容易。
 * 因此，创建一个默认的预览函数，它只调用NewsStory2()函数。
 */
@Preview
@Composable
fun PreviewNews() {
    NewsStory_add_a_container_wrapper_image()
}
