* Optional的产生主要规避 `NPE NullPointException`
* Optional是一个容器对象，这个容器可能包含也可能不包含一个非空的值，如果这个值存在的话，那么`isPresent()`方法会返回`true`，并且`get()`方法会返回这个值
* Optinal的构造方法是私有的，创建Optional对象需要使用其工厂方法