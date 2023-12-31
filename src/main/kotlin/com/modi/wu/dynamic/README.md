## 动态规划
动态规划（Dynamic Programming，简称DP）是一种求解优化问题的方法， 它通常用于解决具有重叠子问题和最优子结构性质的问题。
动态规划的核心思想是将原问题分解为一系列子问题，通过求解子问题的最优解来得到原问题的最优解。

动态规划的基本步骤包括：

1. 定义状态： 将原问题划分为若干子问题，并定义问题的状态。这些状态可以是原问题的某个阶段的解，也可以是某个阶段的某个属性（比如位置、剩余容量等）。

2. 找到状态转移方程： 确定各个状态之间的关系，即找到状态转移方程。状态转移方程描述了如何通过子问题的解来求解原问题。这是动态规划问题的核心。

3. 初始化： 确定问题的边界状态，并进行初始化。通常，这些边界状态对应于问题的最小规模。

4. 计算最优解： 采用自底向上或自顶向下的方式，通过状态转移方程逐步计算各个阶段的最优解，最终得到原问题的最优解。

5. 根据需要保存结果： 在计算的过程中，可以选择保存一些中间结果，以避免重复计算，提高效率。

动态规划常被用于解决一些最优化问题，如最短路径问题、背包问题、编辑距离等。经典的动态规划算法有很多，
如Floyd-Warshall算法、Dijkstra算法、背包问题的0/1背包和多重背包等。

总的来说，动态规划是一种非常强大且广泛应用的算法思想，可以在时间复杂度和空间复杂度之间寻找平衡，求解一些复杂问题。



暴力递归
记忆化搜索
经典动态规划


*[机器人走路问题](RobotWalk.kt)
*[数组中选面值问题](C.kt)
*[中国象棋](ChineseChess.kt)