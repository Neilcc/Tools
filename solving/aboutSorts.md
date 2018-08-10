### 由75想到的排序中快排的总结

```
    先从快排开始看。找到一个关键值，小的扔到左边，大的扔到右边，然后对两边做一样的事情。
    核心是关键值。
    但是从另一个角度来看，这个是一个分段的思想。
    单次排序完成后， start ~ i  是一个值段 i ~ end 是一个值段。当值段以1 为极限的时候，离散的排序就完成了。
     
    回到75题，它的值段是可知的，是三段的阶梯。可见最后排序的结果肯定是三段的值段。因此我们从这个角度来看，肯定是 [0,i) --0  [i, j) ---1  [j, size()-1) --2。于是我们的问题回到了怎么搞定这三个段。

    从头开始，做有标， 一开始 i,j,k 都是0 ， 如果 第一个零 三个都移动 以此类推，最后遍历完整个数组。
    这里注意的是，来到一个新的值之后 ，做的还是插入的操作，就是赋值加平移，由于段内的值是一样的，这个就变成了 修改 头和尾的值了
```