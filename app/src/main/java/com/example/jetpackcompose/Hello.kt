package com.example.jetpackcompose

fun main(args: Array<String>) {
    println("Hello")
}

fun add(x: Int, y: Int): Int {
    return x + y
}

// 大括号{ }
// 小括号( )
// lambda 有参数的情况
// val/var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }
var add: (Int, Int) -> Int = { x, y -> x + y }

// lambda 可等价于
// 此种写法：即表达式的返回值类型会根据操作的代码自推导出来。
// val/var 变量名 = { 参数1:类型，参数2:类型, ... -> 操作参数的代码 }
var test2 = { x: Int, y: Int -> x + y }

// 函数式编程
// var test3 = (x, y) -> x+y
