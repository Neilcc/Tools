package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class Multiply {

    public static void main (String [] args){
        Multiply m = new Multiply();
        m.multiply("123","456");
    }

    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null|| num1.isEmpty() || num2.isEmpty()){
            return "";
        }
        if(num1.equals("0")||num2.equals("0")) {
            return "0";
        }
        List<Integer> last = new ArrayList<>();
        for(int i = num1.length() -1 ; i >=0; i --){
            int pI = 0 ;
            int delta = 0;
            int ans = num1.length() -1 - i;
            pI += ans;
            for(int j = num2.length() -1 ; j >=0 ; j --){
                char c1 = num1.charAt(i);
                int a1 = c1 - '0';
                char c2 = num2.charAt(j);
                int a2 = c2 - '0';
                if(pI < last.size()){
                    int r = a1 * a2  + last.get(last.size() - 1 - pI) + delta;
                    last.set(last.size() - 1 - pI, r%10);
                    delta = r / 10;
                    pI ++;
                }else {
                    int r = a1 * a2 + delta;
                    last.add(0, r%10);
                    delta = r /10;
                    pI++;
                }
            }
            while(delta != 0 ){
                last.add(0, delta % 10 );
                delta = delta /10;
            }
        }
        StringBuilder sb = new StringBuilder ();
        for(int i : last){
            sb.append(i);
        }
        return sb.toString();
    }
}
