package solution.boj;

import java.io.*;
import java.util.*;
public class 백준_2624_동전바꿔주기 {
    
    static int t, k;
    static int[][] coin; //동전의 종류, 개수
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        coin = new int[k][2];

        for(int i = 0; i < k ; i++){
            String[] input = br.readLine().split(" ");
            coin[i][0] = Integer.parseInt(input[0]);
            coin[i][1] = Integer.parseInt(input[1]);
        }

        dp = new int[k][t+1]; //종류수, 1원부터 t원까지
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < t; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(comb(0,0));
    }

    static int comb(int money, int coinType) {
        if(money == t){
            return 1;
        }
        if(dp[coinType][money] != -1) {
            return dp[coinType][money];
        }

        int res = 0;
        for(int i = 0; i < coin[coinType][1] + 1; i++) { //해당 타입 0개부터 가진 개수까지
            int cost = coin[coinType][0] * i;
            res += comb(money + cost, coinType + 1);
        }

        return dp[coinType][money] = res;
    }
}
