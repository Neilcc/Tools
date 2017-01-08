八皇后问题，看起来很蠢的穷举法问题，今天终于搞完了。问题是什么？ 
1. 如何建立深度优先搜索的模型：
2. 如何建立递归的模型：
3. 如何建立回溯的模型：

1. 如何建立深度优先搜索的模型？
   与全排列的穷举类似的是，需要建立一颗树的模型，才能够开始深度优先。这里有个问题是，不一定要建立二叉树啊亲。。。我就陷入了这个死循环中。因为对于把皇后问题，二叉树建模是不可取的。变成了方 a 子， 放 b 子 等等等等。。如果用循环来穷举，那么无法处理好回溯的事情。这就是最开始我解这个算法的时候遇见的问题。
   事实上，我们只要建立一个多叉树就好了，八皇后，每一行八个可能，那么就八叉树，同理衍伸下去，那么就是8^8 可能性，接下来对这个树进行裁剪和过滤 得到想要的结果就好了。这里有个问题是，伴随着我们的搜索，我们需要实时记录结果，这样必然有个 member 块，记录我们搜索的结果，一旦发现符合，那么立刻输出。因为这个member 块是易失的，它会随着我们的搜索过程而变化。

2. 如何建立递归的模型？
   这个是个恶心的问题，恶心的地方在于我一开始建模就建错了，现在回到八叉树的模型。递归就是，放完第一个子，开始放0号树，1号树。。。 7号树，循环，一致到了没有可放的，或者到了叶子。那么递归就显而易见了，就是 一颗一颗子放下去，区别在于 递归过程中，我们记录的已有的变量，会使得我们递归的check 每次都不同，直到最后。

3. 如何建立回溯的模型？
   这是个好问题，因为我们每次往下递归的时候，怎么记录上次的状态然后往回走呢？
   这里需要建立一个理解，对递归栈的理解。递归栈其实就是我们 n 叉树上面的一个路径， 决定它是哪一条路径的是什么呢？ 是我们mem 记录的路径变量。因此，只需要“重置” 这个路径变量，对应的节点，那么就相当于我们抹去了上一次递归的值，回到了之前的状态。。。（状态机的切换。。？ 说起来好像有点玄乎。。不扰了）

以上是深度优先回溯的整体思路



```java

public class Solution {
    
    private List<List<String>> results = new ArrayList<>();
    /*八皇后问题，深度优先搜索*/
    public List<List<String>> solveNQueens(int n) {
        results = new ArrayList<>();
        if (n <= 0) {
            return new ArrayList<>();
        }
        int[] record = new int[n];
        for (int i = 0; i < n; i++) {
            record[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            record[0] = i;
            placeCheeses(record, 1);
            record[0] = -1;
        }
        return results;

    }

    private static void placeCheeses(int[] recorded, int n) {
//        第 n 个子 从 0 开始
        if (n == recorded.length) {
//          no  remain
            results.add(coutResult(recorded));
            return;
        }
        for (int i = 0; i < recorded.length; i++) {
//            每个位置都尝试
            if (isPlaceable(n, i, recorded)) {
                recorded[n] = i;
                placeCheeses(recorded, n + 1);
//                回复初值，找下一个。
                recorded[n] = -1;
            }
        }

    }

    private static List<String> coutResult(int[] recorded) {
        List<String> solution = new ArrayList<>();
        for (int x = 0; x < recorded.length; x++) {
            int y = recorded[x];
            String line = "";
            for (int i = 0; i < recorded.length; i++) {
                if (i != y) {
                    line += ".";
                } else {
                    line += "Q";
                }
            }
            solution.add(line);
        }
        return solution;
    }

    private static boolean isPlaceable(int i, int j, int[] recorded) {
        for (int p = 0; p < recorded.length; p++) {
            if (recorded[p] == -1) {
                break;
            }
            if (i == p) {
                return false;
            }
            if (j == recorded[p]) {
                return false;
            }
            if (j - recorded[p] == i - p) {
                return false;
            }

            if (j - recorded[p] == p - i) {
                return false;
            }

        }
        return true;
    }
}

```
