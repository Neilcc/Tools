[url](https://www.careercup.com/question?id=5722807649435648)

关于动态规划。
   动态规划的核心还是递推
   这个问题里面，能够拿到的最大的硬币数量等于 当前位置的硬币加上剩下可达点里面能拿到的数量的最大值 
  f(x,y) =  max (f(x+dx, y +dy))
  是一个递归式子。
  这里的第一个问题，缩减递归的层次，空间换时间，类似于introduction to algorithm 的方式，通过记录走过的点，下次再找到这个点，我们就直接拿过来用。因此这里用到了一个很方便的数据结构，哈希表，来存储已经找到的点 。

  另一个是执行转化。这也是我之前特别不习惯的地方。怎么转化等式右边。
  于是很简单的事情，遍历。
  显然右边的元素集合大小是 接下来可行位置的阶乘。那么就从1 开始，一个一个遍历 然后 通过递归的return 值来判断大小 ，获得其中的最大值。

  由此引申的。如果我么的右侧 还有别的内容，我们也直接递归遍历。这里不用担心复杂度。因为我们有缓存的存在，复杂度能大大的减少。

   这个算法最终的复杂度是 x 方向 和y 方向能达到的可能性 就是 xy 。。。
   吧。。。？

```
private static int maxCoins(boolean[][] board) {
        return maxCoinsHelper(board, 0, 0, new HashMap<>());
    }

    private static int maxCoinsHelper(boolean[][] board, int row, int col, HashMap<Point, Integer> cache) {
        if (row == board.length || col == board[0].length)
            return 0;
        Point p = new Point(row, col);
        if (cache.containsKey(p))
            return cache.get(p);
        int coinsCount = 0;
        for (int dx = 1; dx + row < board.length; dx++) {
            for (int dy = 1; dy + col < board[0].length; dy++) {
                coinsCount = Math.max(coinsCount, maxCoinsHelper(board, row + dx, col + dy, cache));
            }
        }
        coinsCount += board[row][col] ? 1 : 0;
        cache.put(p, coinsCount);
        return coinsCount;
    }
```
