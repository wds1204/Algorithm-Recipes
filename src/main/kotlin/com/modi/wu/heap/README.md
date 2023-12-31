## 堆排序

堆排序是一种基于二叉堆数据结果的排序算法。它通过构建大堆或则小堆，
并逐步将堆顶元素于未排序部分的最后一个元素交换，然后调整整堆，重复这个过程直至整个数组有序。


### 堆结构
当我们谈论二叉堆时，通常有两种类型：最大堆和最小堆。这里我会以最大堆为例进行说明，最小堆的原理类似，只是相对大小的比较相反。

最大堆是一种满足父节点值大于或等于其子节点值的二叉树。在数组中表示最大堆时，父节点的索引为i，其左子节点的索引为2i + 1，右子节点的索引为2i + 2。

下面是一个简单的最大堆示例：

        9
       / \
      7   5
     / \ / \
    4  2 1  3
对应的数组表示：
```
[9, 7, 5, 4, 2, 1, 3]
```

在堆排序中，一开始会将无序数组调整为最大堆，然后交换堆顶元素（数组的第一个元素，这里是9）与未排序部分的最后一个元素（数组的最后一个元素，这里是3），接着重新调整堆，重复这个过程直到整个数组有序。

堆排序的过程中，数组会被看作两个部分，一个是已排序的部分，一个是未排序的部分。随着堆顶元素的交换，已排序部分逐渐增加，未排序部分逐渐减少，直到整个数组有序。


* [堆排序](HeapSort.kt)