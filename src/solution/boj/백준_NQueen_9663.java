package solution.boj;

import java.util.*;
import java.io.*;

public class 백준_NQueen_9663 {

    static int n;
    static int[] col; //어차피 1번말은 1번행에 놓이는거니까 col[1]에 1번말이 놓일 열 위치만 저장하면 돼.
    static int ans; //방법의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n];
        setQueen(0); //1번부터 하나 암데나 놓고 그 상태에서 2번 놓을 곳 정하고 이런 방식으로 4번 말까지 백트래킹
        System.out.println(ans);
    }
    
    static void setQueen(int cdx){
        if(cdx == n) {
            ans++;
            return;
        }
        for(int i = 0; i < n; i++){ //모든 열에 하나씩 놔볼 수 있으니까 이건 전체 순회
            col[cdx] = i; //cdx번째 행의 i번째 열에 queen 놓기
            if(promising(cdx)){
                setQueen(cdx+1); //cdx번 말까지는 놨으니 그 다음 말을 놓기.
            }
        }
    }

    static boolean promising(int cdx){
        //지금까지 놓은 cdx개의 말 중에서 같은 열인게 있으면 안되고, 대각선에 있어도 안돼
        for(int i = 0; i < cdx; i++){
            if(col[cdx] == col[i] || cdx - i == Math.abs(col[cdx] - col[i])) return false;
        }
        return true;
    }
}