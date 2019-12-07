package com.zcc.puzzle.problems;

public class Posibility {
    public double new21Game(int N, int K, int W) {
        if(K == 0 || N >= K+W -1){
            return 1;
        }
        // f(17) = f(16) * 1/W + f(15) * W1 /W + ...
        // q + w = i   i - w =q   :  10  1~ 7 9 ~ 3
        // f(18) = f(16) * 1/W + .... f (K - W) *
        double [] dp = new double [K+W];
        dp[0] = 1;
        double p = 1.0 / W;
        dp[1] = p;
        for(int i = 2 ; i <K+W ; i ++){
            double pos = 0.0;
            for(int j = 1; j <=W && i - j >= 0 ; j++){
                if(i-j >=K){
                    continue;
                }
                pos += dp[i-j];
            }
            dp[i] = pos * p;
        }
        // for(int i = K+1; i <= N ; i++){
        //   double pos = 0.0;
        //  //  k = 10  k+1 == 11  W == 3  i == 12  dif = 2  j =2  i- j = 10;
        // int dif = i -K;
        //for(int j = dif ; j <=W && i - j >0; j++){
        //  pos += dp[i-j] * p;
        // }
        //dp[i] = pos;
        //}
        double sum = 0 ;
        for(int i = K ; i< K+W ; i++ ){
            sum += dp[i];
        }
        System.out.println(sum);
        double ret =0.0;
        for(int i =K ; i <=N && i<K+W; i ++){
            ret += dp[i];
        }
        System.out.println(ret);
        return ret;
    }

    public static void main(String[] args) {
        Posibility p = new Posibility();
        p.new21Game(21, 17, 10);
    }
}
