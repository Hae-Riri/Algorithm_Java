package solution.programmers;
import java.util.*;

public class 고득점_가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] res = new String[numbers.length];
        for(int i= 0; i < res.length; i++){
            res[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(res, (a,b) -> {
            return (b+a).compareTo(a+b); //내림차순정렬
            //a,b 순으로 놓여있을 때 a+b.compareTo(b+a)라면 a+b < b+a라는 거임.a,b순인데 a+b가 더 작다면 잘못된거니까, 더 큰 걸로 바꿔야 하니까 반대로!
        });

        if(res[0].equals("0")){
            return "0";
        }

        for(String s : res){
            answer += s;
        }
        return answer;
    }
}