package solution.boj;

import java.io.*;
public class 백준_7682_틱택토 {

    static String input;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            input = br.readLine();
            if(input.charAt(0) == 'e') return;

            int x_line = 0, o_line = 0, x_num = 0, o_num = 0;

            for(int i = 0; i < 3; i++){
                x_line += check(i, 'X'); //이긴 라인 개수 아니고 있는지 없는지만 체크하면 됨. 그래서 고정 대각선은 그냥 겹치게 메소드 안에 넣음.
                o_line += check(i, 'O');
                for(int j = 0; j < 3; j++){
                    if(input.charAt(i*3 + j) == 'X') x_num++;
                    else if(input.charAt(i*3 + j) == 'O') o_num++;
                }
            }

            boolean res = false;

            if(x_line != 0 && o_line != 0) res = false; //둘다 이겨있을 순 없어. 한명이라도 이기면 끝나야 정상.
            else if(x_line != 0 && x_num == o_num + 1) res = true;
            else if(o_line != 0 && o_num == x_num) res = true;
            else if(x_line == 0 && o_line == 0 && x_num == 5 && o_num == 4) res = true; //계쏙 비겨서 둘다 대각선 0이고 끝까지 왔을 때.

            if (res) {
                System.out.print("");
            } else {
                System.out.print("in");
            }
            System.out.println("valid");
        }
    }

    static int check(int i, char c) {
        if(
                (input.charAt(i) == c && input.charAt(i+3) == c && input.charAt(i+6) == c) //세로로 세 줄
            || (input.charAt(i*3) == c && input.charAt(i*3+1) == c && input.charAt(i*3+2) == c) //가로로 세 줄
             || (input.charAt(0) == c && input.charAt(4) == c && input.charAt(8) == c) //대각선 1
                        || (input.charAt(2) == c && input.charAt(4) == c && input.charAt(6) == c) //대각선 2
        ) return 1;

        return 0;
    }
}
