
#### 总体原理简述

总的来说，`QueryPro`的运作流程分为两部分。
即：
1. 调用`run`, `runAsMap`等方法之前
2. 调用`run`, `runAsMap`等方法之后

一句话: 在调用`QueryPro`的第一个静态方法后，`QueryStructure`这个对象就生成了，
一直到调用`run`之前的所有代码都是合理的修改`QueryStructure`这个结构，
调用`run`之后，`QueryStructure`就转换为了目标对象并返回。

```
QueryStructure的设计哲学: 易于序列化, 以便多端生成，并传输
```

调用`run`之后: 会使用`IQueryStructureResolver`接口将上述结构`QueryStructure`转换为目标对象list。
`IQueryStructureResolver`默认的实现有`JdbcQueryStructureResolver`

`JdbcQueryStructureResolver`简述:
```
             QueryStructureToSql        prepareStatement     mapRow(with BeanProxy)
QueryStructure ------------> sql & params ----------> ResultSet -----------> List<T>
```


#### 后续规划
update delete
分页
支持sql直接查询
日志
count
更多的测试用例
生成的java文件 委托模拟