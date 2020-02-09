## 何为lambda表达式
* Lambda: In programming languages such as Lisp, Python and Ruby lambda is an operator used to denote anonymous functions or closures, following the usage of lambda calculus.
## 为何需要Lambda表达式
* 在Java中，我们无法将函数作为参数传递给一个方法，也无法声明返回一个函数额方法
* 在JavaScript中，函数参数是一个函数，返回值是另一个函数的情况是非常常见的；JavaScript是一门非常典型的函数式语言
## lambda表达式的基本结构：
```
(param1, param2, param3, ...) -> {
    code...
}
```
## 关于函数式接口：
* 如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口
* 如果我们在某个接口上声明了`FunctionalInterface`注解，那么编译器就会按照函数式接口的定义来要求该接口
* 如果某一个接口只有一个抽象方法，但我们并没有给该接口声明`FunctionalInterface`注解，那么编译器依旧会将该接口看作是函数式接口