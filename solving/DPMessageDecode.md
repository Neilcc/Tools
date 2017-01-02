答案是从解析上抄写下来的。自己最初的思路是与解析一致的。就是参考台阶问题，一步两步那个，于是得到了递推式子 fi = fi-1 + fi-2， 这里有个容易绕进去的点，就是 这个递推式子已经表达了 单字拆分的考虑 和双字拆分的考虑， 因此在做 双字拆分的时候，只需要考虑到当前双字拆分解是否合法就好了。防止绕进去。  然后是关于非法情况，不考虑字母什么的，主要是判断0，  显然尾字为0 的话  fi = fi-2 ; 如果 倒数第二字为0的话， fi = fi-1， 然后 检测一下 双字的合法性就好了。

自己的解题问题在于， 思路是对的，于是用的递归， 这个时间上可能会有一定的问题，可以考虑中间解的重复计算，采用DP 来解答。

第二个是，对于异常分析的不够，从头开始分析的话 容易绕进去，其实不论dp 还是 递归 都需要 以来 递推式子来完成，因此异常的分析 最好的模式应该是针对 1 -  2 的案例分析，分析完成之后 再 依据 i 的案例 得到 异常通式， 才是正解。


 message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.


public class Solution {

    
    public int numDecodings(String s) {
       // f[i] = f[i-1] + f[i-2];
       // 
        if(s==null || s.length()==0) {  
            return 0;  
        }  
        if(s.charAt(0)=='0') {  
            return 0;  
        }  
          
        int [] number = new int[s.length() + 1];  
        number[0] = 1;  
        number[1] = 1;  
        int tmp;  
        for(int i=2;i<=s.length();i++) {  
            //检查当前字符是不是'0'  
            tmp = Integer.parseInt(s.substring(i-1,i));  
            if(tmp!=0) {              
                number[i] = number[i-1];  
            }  
            //检查当前字符和前一个字符组合在一起是否在1-26之间  
            if(s.charAt(i-2)!='0') {  
                tmp = Integer.parseInt(s.substring(i-2,i));  
                if(tmp>0&&tmp<=26) {  
                    number[i] += number[i-2];  
                }  
            }  
        }  
        return number[s.length()];  
        
    }
    
    
}
