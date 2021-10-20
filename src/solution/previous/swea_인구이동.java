package solution.previous;

import java.util.*;
import java.io.*;

public class swea_인구이동 {

    static int N, L, R, ans;
    static int[][] map;
    static boolean[][] visit;
    static int sum;
    static ArrayList<Info> union;
    static class Info{
        int x;
        int y;
        Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        union = new ArrayList<>();
        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String[] input2 = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        while(true) {
            boolean moved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        sum = 0;
                        union.clear();
                        dfs(i, j, -1);

                        if (union.size() >= 2) {
                            int newNum = sum / union.size();
                            for (Info info : union) {
                                map[info.x][info.y] = newNum;
                            }
                            moved = true;
                        }
                    }
                }
            }
            for(int i = 0; i < N; i++)
                Arrays.fill(visit[i], false);
            if(!moved){ //맵 전부 다 돌았는데도 연합이 없었다면
                break;
            }else{
                ans++; //인구 이동이 있었다면 날짜더하기
            }
        }
        System.out.println(ans);
    }

    static void dfs(int x, int y, int prev) {
        if(x < 0 || x >= N || y < 0 || y >= N || visit[x][y])
            return;
        if(prev != -1){
            int diff = Math.abs(map[x][y] - prev);
            if(L > diff || diff > R) return;
        }
        visit[x][y] = true;
        union.add(new Info(x, y));
        sum += map[x][y];
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, map[x][y]);
        }
    }

}
