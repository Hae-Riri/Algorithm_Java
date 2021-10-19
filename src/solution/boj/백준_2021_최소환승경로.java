package solution.boj;

import java.io.*;
import java.util.*;

public class 백준_2021_최소환승경로 {

    static int N, L;
    static boolean[] visitStation;
    static boolean[] visitLine;
    static ArrayList<Integer>[] station;
    static ArrayList<Integer>[] line;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);

        visitStation = new boolean[N+1];
        visitLine = new boolean[L+1];
        station = new ArrayList[N+1];
        line = new ArrayList[L+1];

        for(int i = 1; i < N+1; i++){
            station[i] = new ArrayList<>();
        }
        for(int i = 1; i < L+1; i++){
            line[i] = new ArrayList<>();
        }

        for(int i = 1; i < L+1; i++){
            String [] stations = br.readLine().split(" ");
            for(String s: stations){
                int statNum = Integer.parseInt(s);
                if(statNum == -1) break;
                station[statNum].add(i);
                line[i].add(statNum);
            }
        }

        String[] input2 = br.readLine().split(" ");
        int start = Integer.parseInt(input2[0]);
        int end = Integer.parseInt(input2[1]);
        int ans = go(start, end);
        System.out.println(ans);
    }

    static int go(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.transCount - b.transCount);
        visitStation[start] = true;
        for(int i = 0; i < station[start].size(); i++){
            pq.add(new Node(station[start].get(i), start, 0));
            visitLine[station[start].get(i)] = true;
        }

        while(!pq.isEmpty()) {
            Node front = pq.poll();

            if(front.curStation == end){
                return front.transCount;
            }

            for(int nextStation: line[front.curLine]) {
                if(!visitStation[nextStation]) {
                    visitStation[nextStation] = true;
                    pq.add(new Node(front.curLine, nextStation, front.transCount)); //환승안하는경우

                    for(int nextLine : station[nextStation]) {
                        if(!visitLine[nextLine]) {
                            visitLine[nextLine] = true;
                            pq.add(new Node(nextLine, nextStation, front.transCount+1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int curLine;
        int curStation;
        int transCount;
        Node(int curLine, int curStation, int transCount){
            this.curLine = curLine;
            this.curStation = curStation;
            this.transCount = transCount;
        }
    }
}
