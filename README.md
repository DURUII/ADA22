# ADA22
## Divide, Conquer & Combine
- partition the problem into subproblems considered <mark>**independent or disjoint**</mark>
- repeatedly solving the common subproblems

| Desc. |  Prob.   |  Ref. Code  | 
|:--:|:---:|:---:|
| 递归 |  [斐波那契](https://www.acwing.com/problem/content/19/)   |  [Fibonacci.java](https://github.com/DURUII/ADA22/blob/4f9bfc71e734f5d590f7eb8f4397396af14b1c46/Code/DCC/Fibonacci.java)   | 
| [首部曲](https://mathsisfun.com/games/towerofhanoi.html)|  [汉诺塔](https://www.lanqiao.cn/problems/1512/learning/)   |  [Hanoi.java](https://github.com/DURUII/ADA22/blob/4f9bfc71e734f5d590f7eb8f4397396af14b1c46/Code/DCC/Hanoi.java)   | 
|🥕 |[双盘汉诺塔](https://www.luogu.com.cn/problem/P1096)|[Hanoi2.java](https://github.com/DURUII/ADA22/blob/762b096198902b226fec3edf3df6e425b26ba0cc/Code/DCC/Hanoi2.java)| 
| 👼 |  [汉诺四塔](https://www.acwing.com/problem/content/98/)   |  [Hanoi4.java](https://github.com/DURUII/ADA22/blob/4f9bfc71e734f5d590f7eb8f4397396af14b1c46/Code/DCC/Hanoi4.java)  |  
| 🧑‍🦲 |  [直线划分平面](https://www.luogu.com.cn/problem/T291123)   |  [Plane.java](https://github.com/DURUII/ADA22/blob/cc7f90592931a41438e0ceea8ba477cc9e28e3aa/Code/DCC/Plane.java)   |   
| 🧑‍🦲 |  [约瑟夫环](https://www.luogu.com.cn/problem/T291920)   |  [Josephus.java](https://github.com/DURUII/ADA22/blob/a4300880a9e381aae3ad372186b140fe62db1001/Code/DCC/Josephus.java)   |  
| 首部曲 |  [归并排序](https://www.acwing.com/problem/content/789/)  |   [MergeSort.java](https://github.com/DURUII/ADA22/blob/4f9bfc71e734f5d590f7eb8f4397396af14b1c46/Code/DCC/MergeSort.java)  | 
| 首部曲 |  [双调数组峰值](https://leetcode.cn/problems/peak-index-in-a-mountain-array/)  |  [BitonicChampion.java](https://github.com/DURUII/ADA22/blob/4f9bfc71e734f5d590f7eb8f4397396af14b1c46/Code/DCC/BitonicChampion.java)  |  
| 首部曲 |  [最大子数组和](https://leetcode.cn/problems/maximum-subarray/)  |  [MaxSubArray.java](https://github.com/DURUII/ADA22/blob/4f9bfc71e734f5d590f7eb8f4397396af14b1c46/Code/DCC/MaxSubArray.java)   |  
| 神乎其技 |  矩阵乘法   | [matrix.ipynb](https://github.com/DURUII/ADA22/blob/4f9bfc71e734f5d590f7eb8f4397396af14b1c46/Code/DCC/matrix.ipynb)    |  
| 神乎其技 |  [TOP-K*](https://leetcode.cn/problems/kth-largest-element-in-an-array/)   |  [K_Selection.java](https://github.com/DURUII/ADA22/blob/4f9bfc71e734f5d590f7eb8f4397396af14b1c46/Code/DCC/K_Selection.java)   |  
| 神乎其技 |  [平面最近邻点*](https://www.luogu.com.cn/problem/P1429)   |  [ClosestPair.java](https://github.com/DURUII/ADA22/blob/b6a92dfd278fd5a04a47586ae8f1aba2ee6f6d6a/Code/DCC/ClosestPair.java)   | 

## Dynamic Programming
- partition the problem into dependent
or <mark>**overlapping subproblems**</mark>(top-down with memoization, *bottom-up with tabulation*)
- an optimal solution can be constructed from <mark>**optimal solutions**</mark> to subproblems (ignore non-optimal solutions)

| Desc. |  Prob.   |  Ref. Code  | 
|:--:|:---:|:---:|
| [DP](https://www.sohu.com/a/619813907_453160)| [斐波那契](https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/)|  [Fibonacci2.java](https://github.com/DURUII/ADA22/blob/199105e3efe3d7dccd164c0314fec00be6f47320/Code/DP/Fibonacci2.java)   | 
|[首部曲](https://www.geeksforgeeks.org/cutting-a-rod-dp-13/)|  [板条切割](https://vjudge.net/problem/Gym-270304F)   | [RodCutting.java](https://github.com/DURUII/ADA22/blob/e8d1a290d248348cceff620e54cf15643d685835/Code/DP/RodCutting.java)    | 
|首部曲| [最少邮票数](https://leetcode.cn/problems/coin-change/)| [Stamp.java](https://github.com/DURUII/ADA22/blob/a5dda449db1a1b9086346726dd971ea12628298c/Code/DP/Stamp.java) | 
|[✌️](http://pe-cn.github.io/31/)|[欧拉的硬币兑换](https://leetcode.cn/problems/coin-change-ii)|[Coin.java](https://github.com/DURUII/ADA22/blob/main/Code/DP/Coin.java) |
|[首部曲]((https://vjudge.net/problem/ZOJ-1094))|  [结合律](https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1/)   | [MatrixChain.java](https://github.com/DURUII/ADA22/blob/4b59257bbac06a16c09b9c55f996d0a51bc2c654/Code/DP/MatrixChain.java)    | 
|首部曲|  [兼职规划](https://leetcode.cn/problems/maximum-profit-in-job-scheduling/)   | [WeightedIntervalScheduling.java](https://github.com/DURUII/ADA22/blob/a4bd294e37d9055425b1a7b73609a365425c7d15/Code/DP/WeightedIntervalScheduling.java) |
| 变化多端0 |  最长公共子序列   |     | 
| 变化多端0 |     |     | 
| 变化多端0 |  维特比算法   |     | 
| 变化多端1 |     |     | 
| 变化多端1 |     |     | 
| 变化多端1 |     |     | 

## Greedy

## Graph


## Non-deterministic Polynomial Complete

## Random