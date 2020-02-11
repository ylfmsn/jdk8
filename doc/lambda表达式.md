## 何为lambda表达式
* Lambda: In programming languages such as Lisp, Python and Ruby lambda is an operator used to denote anonymous functions or closures, following the usage of lambda calculus.
## 为何需要Lambda表达式
* 在Java中，我们无法将函数作为参数传递给一个方法，也无法声明返回一个函数额方法
* 在JavaScript中，函数参数是一个函数，返回值是另一个函数的情况是非常常见的；JavaScript是一门非常典型的函数式语言
## Lambda表达式的基本结构：
```
(param1, param2, param3, ...) -> {
    code...
}
```
* 一个Lambda表达式可以有零个或多个参数
* 参数的类型既可以明确声明，也可以根据上下文来推断。例如：(int a)与(a)小果果相同
* 所有参数需包含在圆括号内，参数之间用逗号相隔。例如：(a, b)与(int a, init b)或(String a, int b, float c)
* 空圆括号代表参数集为空。例如：() -> 42
* 当只有一个参数，且其类型可推导时，圆括号()可省略。例如： a -> return a * a
* Lambda 表达式的主体可包含零条或多条语句
* 如果Lambda表达式的主体只有一条语句，花括号{}可省略。匿名函数的返回类型与该主题表达式一致
* 如果Lambda表达式的主体包含一条以上语句，则表达式便须包含在花括号{}中（形成代码块）。匿名函数的返回类型与代码块的返回类型一致，若没有返回则为空
## Lambda表达式作用
* Lambda表达式为Java添加了缺失的函数式编程特性，使我们能将函数当做一等公民看待
* 在将函数作为一等公民的语言中，Lambda表达式的类型是函数。但在Java中，Lambda表达式是对象，他们必须依附于一类特别的对象类型--函数式接口(functional interface)
## Java Lambda概要
* Java Lambda表达式是一种匿名函数；它是没有声明的方法，即没有访问修饰符、返回值声明和名字
## Lambda表达式作用
* 传递行为，而不仅仅是值
    * 提升抽象层次
    * API重用性更好
    * 更加灵活