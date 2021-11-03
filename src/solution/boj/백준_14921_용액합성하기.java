package solution.boj;

import java.util.*;
import java.io.*;

public class 백준_14921_용액합성하기 {
    static int ans;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String [] args) throws IOException {
        int n = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(input[i]));
        }
        Collections.sort(list);

        int ans = list.get(0) + list.get(list.size() -1); //특성값 자체의 부호는 유지하고 나중에 비교할 때만 절댓값
        int l = 0, r = list.size() - 1;

        while(l < r){
            int now = list.get(l) + list.get(r);
            if(now < 0){
                l++;
            }else if(now > 0){
                r--;
            }else{
                System.out.println(now);
                return;
            }

            if(Math.abs(ans) > Math.abs(now)){ //비교할 때만 절댓값 사용하고 실제 답은 부호 그대로 써야지.
                ans = now;
            }
        }
        System.out.println(ans);
    }
}
