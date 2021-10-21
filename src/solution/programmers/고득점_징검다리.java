package solution.programmers;
import java.util.*;
public class 고득점_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int l = 1;
        int r = distance;
        while(l <= r) {
            int mid = (l+r)/2;
            int pre_rock = 0;
            int cnt = 0;
            for(int i = 0; i < rocks.length; i++){
                if(rocks[i] - pre_rock < mid) { //제거해야 함
                    cnt++;
                }else{//제거 안해도 돼
                    pre_rock = rocks[i];
                }
            }
            if(cnt <= n){ //이미 최솟값은 맞아졌거나 n보다 조금 줄였는데도 최솟값이 맞은거야. 여기서 더 제거해봤자 거리는 더 커지니까
                //최솟값은 계속 유지될거야. 최솟값 중에 큰 걸 찾는거니까 mid를 더 키워보자.
                answer = Math.max(answer, mid);
                l = mid+1;
            }else{ //n보다 더 많이 줄여야만 최솟값이 맞춰지는 거라면 최솟값이 지금 너무 큰거야.
                r = mid -1;
            }
        }
        return answer;
    }
}
