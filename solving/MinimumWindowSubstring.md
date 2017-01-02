这个问题需要注意的是，其中t 串的字母的个数也在考虑的范围之内，也就是说，如果字母的个数不满足的话 也不算包含。
这个也是采用窗口函数的做法， 在保证满足条件的前提下 做先右移动边界，再左移动边界的操作。

由于对复杂度有较高的要求，所以只能够通过char 的ASCII code 来通过 bit map 在扫的同时来记录信息。


problem :
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

mine solution:

this algorithm is out of time limit.

```java
public class Solution {
    private HashMap<Character ,Integer>  ts = new HashMap<>();
    
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 ){
            return "";
        }
        
        for(int i = 0 ; i < t.length(); i ++){
            Integer tt = ts.get(t.charAt(i));
            if(tt == null){
                tt =1 ;
            }else {
                tt += 1;
            }
            ts.put(t.charAt(i), tt);
        }

        String min = "";
        int j = 0;
        for(int i = 0 ; i < s.length(); i ++){
            if(!t.contains(s.charAt(i)+"")){
                continue;
            }
            for( ; j < s.length() ; j ++ ){
                if(j < i){
                    j = i;
                }
                if(contains(s.substring(i,j+1), t)){
                    if(min.length() == 0){
                        min = s.substring(i,j +1);
                        break;
                    }
                    if(min.length() > s.substring(i,j +1).length()){
                        min = s.substring(i,j+1);
                        break;
                    }
                    break;
                }
            }
        }
        
        return min;
    
    }
    
    public boolean contains(String sub, String t){
         if (sub.length() < t.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            
            if (!sub.contains(t.charAt(i) + "")) {
                return false;
            }else if(ts.get(t.charAt(i))> 1){
                Integer tt = ts.get(t.charAt(i));
                if(sub.length() - sub.replace(t.charAt(i)+"", "").length() < tt){
                    return false;
                }
            }
        }
        return true;
    }
}
```
