package solution.boj;

import java.io.*;
public class 백준_벌집_2292 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count = 1;
        int compare = 1;

        while(compare < num) {
            count++;
            compare += 6 * (count-1);
        }
        System.out.println(count);
    }
}
