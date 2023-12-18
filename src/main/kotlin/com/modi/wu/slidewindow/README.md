## 滑动窗口

1. 设置一个固定大小的窗口，依次划过array数组, 返回每一次滑出状况的最大值。
[固定滑动](SlidingWindowMaxArray.kt)
2. 给定一个整型数组arr,和一个整数num,某个arr中的子数组sub,如果想达标，必须满足：\n sub中最大值-sub中最小值<=num,返回arr中达标子数组的数量
[sub中最大值-sub中最小值<=num](AllLessNumSubArray.kt)
3. 给定一个有序数组arr,从左到右依次表示X轴上从左往右点的位置，给定一个正整数K，返回如果有一根长度为K的绳子，<br />最多能盖住几个点绳子的边缘点碰到X轴伤的点也算盖住。