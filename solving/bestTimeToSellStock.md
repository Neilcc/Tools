思路是这样，决定的最终的情况是每天和次日的差值，因此我们将数组转化为delta 组来判断。 然后仿照窗口函数的思想。从左边开始 往右来算合。，在过程中记录最大值。一旦合小于0，那么它对于右边的增益必然是负的，因此直接丢弃到左边，从右边的开始计算。

这个算法其实是对于穷举法的改善，降低了循环次数，勉强达到值

另一个是官方给出的，也就是我们找到最低点， 然后遍历找出最低点后面的 与他差值最大的点
比如 

[2, 16,1,4,5,6,7,8 ]

这里需要注意的一个思想是，最值我们是一直在更新的，因此不会有遗漏，这里需要像计算机一样，渐进的思考。

```
public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
```

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.

mine: (taks to much time)
```
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int[] delta = new int [prices.length - 1];
        int max = 0;
        for(int i = 1 ; i < prices.length; i ++){
            delta[i-1] = prices[i] - prices[i-1];
        }
        int sum = 0 ;
        for(int i =0 ; i<delta.length; i ++){
            sum = 0;
            for(int j = i; j < delta.length ; j ++){
                sum += delta[j];
                if(sum > max){
                    max = sum;
                }
                if(sum < 0){
		    i =j ;
                    break;
                }
            }
        }
        return max;
    }
}
```
