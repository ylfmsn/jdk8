## Stream概念
* 提高操作集合效率，Collection提供了新的stream()方法
* 流不存储值，通过管道的方式获取值
* 本质是函数式的，对流的操作会生成一个结果，不过并不会修改底层的数据源，集合可以作为流的底层数据源
* 延迟查找，很多流操作（过滤、映射、排序等）都可以延迟实现
* 流由3部分构成
    * 源
    * 零个或多个中间操作
    * 终止操作
* 流操作的分类
    * 惰性求值，只有终止操作被初始化时中间若干个操作才会执行
    * 及早求值
* 跟迭代器不同的是，Stream可以进行并行操作，迭代器只能命令式地、串行化操作
* 当使用串行方式去遍历时，每个item读完后再读下一个item
* 使用并行去遍历时，数据会被分成多个段，其中每一个都在**不同的线程**中处理，然后将结果一起输出
* Stream的并行操作依赖于Java7中引入的Fork/Join框架
## Stream操作类型
* Intermediate： 一个流可以后面跟随零个或者多个intermediate操作。其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用，这类操作都是延迟的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
* Terminal： 一个流只有一个terminal操作，当这个操作执行后，流就被使用“光”了，无法再被操作。所一这必定是流的最后一个操作。Terminal操作的执行，才会真正开始流的遍历，并且会生成一个结果。
## 内部迭代 和 外部迭代
![binaryTree](./image/01.png "binaryTree")
* 内部迭代
```
(伪代码)
students.stream().filter(student -> student.getAge() > 20).filter(student -> student.getAddress().equals("beijing")).
    sorted(...).forEach(student -> System.out.println(student.getName()));
```
* 外部迭代
```
(伪代码)
List<Student> list = new ArrayList<>();

for(int i = 0; i < list.size(); i++) {
    Student student = students.get(i);

    if(student.getAge() > 20 && student.getAddress().equals("beijing")) {
        list.add(student);
    }
}

Collections.sort(list, Comparator() ...);

for (Student student : list) {
    System.out.println(student.getName());
}
```
* 集合关注的是数据与数据存储本身
* 流关注的则是对数据的计算
* 流与迭代器类似的一点是：流是无法重复使用或消费的
## collect: 收集器
* Collector作为collect方法的参数
* Collector本身是一个接口，它是一个可变的汇聚操作，将输入元素累积到一个可变的结果容器中；它会在所有元素都处理完毕后，将累积的结果转换为一个最终的表示（这是一个可选的操作）;它支持串行与并行两种方式。
* Collectors本身提供了关于Collector的常见汇聚实现，Collectors本身实际上是一个工厂。
* 为了确保串行和并行操作结果的等价，Collector函数需要满足两个条件：identity（同一性） 和 associativity（结合性）

