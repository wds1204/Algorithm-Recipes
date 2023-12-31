## 归并排序

归并算法（Merge Sort）是一种分治算法，它的基本思想是将原始数据分成若干个子序列，
分别对子序列进行排序，然后再将已排序的子序列合并成更大的有序序列，直到整个序列都被排序。

归并算法的步骤可以概括为一下几个阶段：
1. 分解(Divide):将原始序列划分为若干个子序列，直到每个子序列只有一个元素
2. 排序(Conquer):对每个子序进行排序。可以使用递归来处理这个阶段，直到所有子序列都被排序。
3. 合并(Combine):将已排序的子序合并成一个大的有序的序列。这一步是归并排序的关键，它将两个有序的子序合并成一个有序序列。

* [归并排序](MergeSort.kt)
* [求数组小和](SmallSum.kt)