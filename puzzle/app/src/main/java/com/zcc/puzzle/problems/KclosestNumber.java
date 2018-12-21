package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class KclosestNumber {

    public static void main(String[] arg){
        KclosestNumber jj = new KclosestNumber();
        int [] in = new int[10];
        in[0]=0;
        in[1]=1;
        in[2]=2;
        in[3]=2;
        in[4]=2;
        in[5]=3;
        in[6]=6;
        in[7]=8;
        in[8]=8;
        in[9]=9;
        jj.findClosestElements(in,5,9);



    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length ==0) return new ArrayList<>();
        List<Integer> ret= new ArrayList<>();
        if(arr[0]>=x){
            for(int i =0 ; i < k ; i++){
                ret.add(arr[i]);
            }
        }else if (arr[arr.length-1]<=x){
            for(int i =arr.length -k ; i < arr.length ; i++){
                ret.add(arr[i]);
            }
        }else{
            int ki = binarySearch(arr,x, 0, arr.length-1);
            if(ki >= arr.length){
                ki--;
            }else if(ki <0){
                ki++;
            }
            extendArr(arr,ki,ret,k,x);
        }
        return ret;
    }

    private int binarySearch(int [] arr , int val, int s, int e){
        if(e==s) return s;
        int k = (e-s)/2;
        if(arr[k+s] == val) return k+s;
        else if(arr[k+s] > val) return binarySearch(arr, val, s,k+s-1);
        else return binarySearch(arr,val, s+k+1, e);
    }

    private void extendArr(int[] arr , int ki, List<Integer> ret, int n, int val){
        int i =0;
        int l = ki - 1;
        int r = ki;
        while(i< n){
            if(l < 0){
                ret.add(arr[r]);
                r++;
                i++;
                continue;
            }else if(r >= arr.length){
                ret.add(0, arr[l]);
                l--;
                i++;
                continue;
            }
            if((val - arr[l]) == (arr[r] - val) ){
                ret.add(0, arr[l]);
                l --;
                i++;
            }else if((val - arr[l]) < (arr[r] - val)){
                ret.add(0, arr[l]);
                l --;
                i++;
            }else{
                ret.add(arr[r]);
                r++;
                i++;
            }
        }
    }
}
