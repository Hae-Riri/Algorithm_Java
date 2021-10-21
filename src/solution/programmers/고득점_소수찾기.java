package solution.programmers;
import java.util.*;
public class 고득점_소수찾기 {
    static LinkedList<Character> res = new LinkedList<>();
    static HashSet<Integer> s = new HashSet<>();
    static boolean[] visit;
    static String num;
    public int solution(String numbers) {
        int answer = 0;
        num = numbers;
        visit = new boolean[numbers.length()];

        //visit, res 초기화
        for(int i = 1; i <= numbers.length(); i++){
            Arrays.fill(visit, false);
            res.clear();
            dfs(i);
        }

        // s.forEach(e -> System.out.print(e + " "));

        answer = s.size();
        return answer;
    }
    static void dfs(int targetSize){
        if(res.size() == targetSize) {
            String str = "";
            for(Character c : res){
                str += Character.toString(c);
            }
            int result = Integer.parseInt(str);
            if(check(result)){
                s.add(result);
            }
        }
        for(int i = 0; i < num.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                res.add(num.charAt(i));
                dfs(targetSize);
                res.removeLast();
                visit[i] = false;
            }
        }
    }
    static boolean check(int n){
        if(n == 0 || n == 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    //1개부터 전체개수까지 순열놓기
//이후 해당 값들 set에 넣었다가 이걸 ArrayList(s)로 초기화해서 COllectios로 정렬하기
}
