### 二叉树
        二叉树
          1
      2        3
    4   5    6   7
二叉树的打印可以分为先序(头->左->右)、中序(左->头->右)、后序(左->右->头)
分别用不同的方式展开上述二叉树：
* 先序的结果:1、2、4、5、3、6、7
* 中序的结果:4、2、5、1、6、3、7
* 先序的结果:4、5、2、6、7、3、1

```kotlin
class Node<T>(var value:T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}
```
如何打印二叉树：
* 通过[递归遍历](RecursiveTraversalBT.kt)
* 借助[堆栈容器](NoRecursiveTraversalBT.kt)

二叉树递归套路实践
* [纸条折痕问题](PaperFolding.kt)
* [判断是否是平衡二叉树](PaperFolding.kt)
* [二叉树最大距离](MaxDistance.kt)



