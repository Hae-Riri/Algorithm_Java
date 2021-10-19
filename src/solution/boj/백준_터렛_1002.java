package solution.boj;

import java.io.*;

public class 백준_터렛_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t > 0){
            t--;
            String [] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int r1 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);
            int y2 = Integer.parseInt(input[4]);
            int r2 = Integer.parseInt(input[5]);

            int dist = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,2));

            if(dist > Math.pow(r1 + r2, 2) || dist < Math.pow(r2-r1,2))
                System.out.println(0);
            else if(dist == Math.pow(r1 + r2, 2) || dist == Math.pow(r2-r1,2))
                System.out.println(1);
            else if(x1 == x2 && y1 == y2 && r1 == r2)
                System.out.println(-1);
            else
                System.out.println(2);
        }
    }
}
// pow : 제곱, double을 리턴
// sqrt :제곱근 double리턴
// abs : 절댓값 int 리턴