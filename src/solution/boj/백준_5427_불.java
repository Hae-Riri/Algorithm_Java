package solution.boj;

import java.util.*;
import java.io.*;
public class 백준_5427_불 {
    static int w, h, ans = -1; //w는 열의 수, h는 행의 수
    static boolean[][] visit;
    static char[][] map;
    static Queue<Point> fire;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]); //열
            h = Integer.parseInt(input[1]); //행

            visit = new boolean[h][w];
            map = new char[h][w];
            fire = new LinkedList<>();

            int x = 0, y= 0;

            for(int i = 0; i < h; i++){
                String input2 = br.readLine();
                for(int j = 0; j < w; j++) {
                    map[i][j] = input2.charAt(j);
                    if(map[i][j] == '@'){
                        x = i;
                        y = j;
                    }else if(map[i][j] == '*'){
                        fire.offer(new Point(i, j));
                    }
                }
            }
            escape(x, y);
        }
    }
    static void escape(int sx, int sy) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point (-1 ,-1));
        q.offer(new Point(sx, sy));
        visit[sx][sy] = true;
        int time = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.x == -1 && now.y == -1) {
                burn();
                if (!q.isEmpty()) {
                    q.offer(now);
                }
                time++; // 1초동안 불 먼저 퍼뜨리고 아래 for문에서 상근이 이동시키기,
                continue;
            }
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    System.out.println(time);
                    return;
                }
                if (!visit[nx][ny] && map[nx][ny] == '.') {//한번도 안갔으면서 빈캄인 곳. (불이거나 벽이면 안되고 갔던곳 안돼)
                    visit[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    static void burn(){
        while(!fire.isEmpty()){
            Point now = fire.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < h && ny < w && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                    map[nx][ny] = '*';
                    fire.offer(new Point(nx, ny));
                }
            }
        }
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
