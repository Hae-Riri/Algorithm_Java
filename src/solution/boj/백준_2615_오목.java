package solution.boj;

import java.io.*;

public class 백준_2615_오목 {
    //아래, 오른쪽대각선아래, 오른쪽, 오른쪽대각선위
    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};
    static int[][] map = new int[19][19];
    static int[][][] memo = new int[19][19][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 19; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.print(countFive());
    }

    static String countFive() {
        //항상 왼쪽의 좌표를 가져오라 했으니 항상 왼쪽 값이 오른쪽값보다 먼저 나오게 반대료 출력하기.
        for(int j = 0; j < 19; j++){
            for(int i = 0; i < 19; i++) {
                if(map[i][j]!= 0){
                    for(int d = 0; d < 4; d++){
                        //memo를 통해 기존에 세어졌던 바둑알은 패스
                        if(memo[i][j][d] == 0 && dfs(i, j, d, map[i][j]) == 5){
                            return map[i][j] +"\n" +(i+1)+" "+(j+1)+"\n";
                        }
                    }
                }
            }
        }
        return "0";
    }

    static int dfs(int x, int y, int dir, int color) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) return 1;
        if(map[nx][ny] == color){
            //이 방향으로의 nx, ny좌표까지의 개수를 memo에 저장
            //그래서 나중에 이미 다른 애를 시작으로 이 좌표가 세어졌던 좌표면 패스할거야
            return memo[nx][ny][dir] = dfs(nx, ny, dir, color) + 1; 
        }
        return 1; //자기자신의 다음인 nx가 color가 아니라면 지금 x까지만 이 x 하나만 세어지니까 1 리턴
    }
}
