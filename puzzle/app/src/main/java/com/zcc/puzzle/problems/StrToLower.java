package com.zcc.puzzle.problems;

/**
 * Created by cc on 2019-08-28.
 */
public class StrToLower {
    public String toLowerCase(String str) {
        if(str == null) return str;
        int diff = 'a' - 'A';
        String sb = "";
        for(int i = 0; i < str.length(); i ++){
            sb = sb + ((char)(str.charAt(i) + diff));
        }
        return sb;
    }
    public static void main(String [] args){
        StrToLower strToLower = new StrToLower();
        strToLower.toLowerCase("hello");
        int t = 105;
        char c = (char) t;
        System.out.println(c);
    }
}
