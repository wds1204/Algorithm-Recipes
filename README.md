# Algorithm-Recipes
基本数据结构与算法训练


### 二叉树
        二叉树
          1
      2        3
    4   5    6   7
二叉数的打印可以分为先序(头->左->右)、中序(左->头->右)、后序(左->右->头)
分别用不同的方式展开上述二叉树：
* 先序的结果:1、2、4、5、3、6、7
* 中序的结果:4、2、5、1、6、3、7
* 先序的结果:4、5、2、6、7、3、1

通过[递归遍历]("src/main/kotlin/com/modi/wu/binarytree/RecursiveTraversalBT.kt")的方式打印二叉树



