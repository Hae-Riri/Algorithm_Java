package solution.programmers;
import java.util.*;
public class 고득점_모의고사 {
    static int[] ans1 = {1, 2, 3, 4, 5};
    static int[] ans2 = {2,1,2,3,2,4,2,5};
    static int[] ans3 = {3,3,1,1,2,2,4,4,5,5};
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int idx1 = 0, idx2 = 0, idx3=0;
        int score1 = 0, score2 = 0, score3 = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == ans1[idx1]) score1++;
            if(answers[i] == ans2[idx2]) score2++;
            if(answers[i] == ans3[idx3]) score3++;
            idx1++; idx2++; idx3++;
            if(idx1 == ans1.length) idx1 = 0;
            if(idx2 == ans2.length) idx2 = 0;
            if(idx3 == ans3.length) idx3 = 0;
        }
        int maxScore = Math.max(score1, score2);
        maxScore = Math.max(maxScore, score3);

        if(score1 == maxScore) answer.add(1);
        if(score2 == maxScore) answer.add(2);
        if(score3 == maxScore) answer.add(3);
        return answer;
    }
}
