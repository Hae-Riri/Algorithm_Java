package solution.boj;

import java.util.*;
import java.io.*;

public class 백준_3980_선발명단 {
    static int ans;
    static LinkedList<Integer> res; //각각의 포지션 별 선수의 능력치를 저장
    static boolean[] visit; //i번 선수를 이미 포지션에 배치했는지 파악
    static int[][] score;
    static ArrayList<Integer>[] players = new ArrayList[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            ans = 0;
            res = new LinkedList<>();
            visit = new boolean[11];
            score = new int[11][11];
            for(int i = 0; i < 11; i++)
                players[i] = new ArrayList<>();

            for(int i = 0; i < 11; i++){
                String[] input = br.readLine().split(" ");
                for(int j = 0; j < 11; j++) {
                    score[i][j] = Integer.parseInt(input[j]);
                    if(score[i][j] > 0) {
                        players[j].add(i); //j번 위치에 i번 선수가 배치될 수 있음.
                    }
                }
            }

            permutation();
            System.out.println(ans);
        }
    }
    public static void permutation() {
        if(res.size() == 11) {
            int sum = 0;
            for(Integer i : res){
                sum += i;
            }
            ans = Math.max(ans, sum);
            return;
        }
        //이번에 새로 배치할 포지션 번호
        int now_pos = res.size();
        for(int i = 0; i < players[now_pos].size(); i++){ //now_pos에 배치될 수 있는 선수들을 순회
            int player = players[now_pos].get(i);
            if(!visit[player] ) {
                visit[player] = true;
                res.add(score[player][now_pos]);
                permutation();
                visit[player] = false;
                res.removeLast();
            }
        }
    }

}
