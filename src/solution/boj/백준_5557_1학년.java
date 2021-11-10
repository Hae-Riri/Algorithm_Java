package solution.boj;

import java.util.*;
import java.io.*;
public class 백준_5557_1학년 {
    static int n;
    static int[] num;

    public static void main(String [] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(input[i]);
        }

        long[] cnt = new long[21]; //0이상 20이하의 값들에 대해 각각이 나올 수 있는 경우의 수 저장
        for(int i = 0; i < n-2; i++) {
            if(i == 0) {
                cnt[num[0]] = 1;
            }
            cnt = calSum(cnt, i+1);
        }
        System.out.println(cnt[num[n-1]]);//궁극적으로 마지막 숫자 값이 나온 경우의 수를 세는 거니까.
    }
    static long[] calSum(long[] tmp, int idx) {
        long[] cnt = new long[21];
        for(int i = 0; i < 21; i++) {
            if(tmp[i] == 0) continue; //기존에 한번이라도 나온 값에 대해서만 새로 연산할거니까 안나온건 패스
            else{
                if(i - num[idx] >= 0 && i - num[idx] <= 20) {
                    cnt[i-num[idx]] += tmp[i];
                }
                if(i + num[idx] >= 0 && i + num[idx] <= 20) {
                    cnt[i+num[idx]] += tmp[i];
                }
            }
        }
        return cnt;
    }
}
