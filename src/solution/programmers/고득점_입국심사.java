package solution.programmers;

import java.util.Arrays;
class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = (long) n* (long)times[times.length-1];
        long l = 0;
        long r = answer;
        while(l <= r) {
            long mid = (l+r)/2;
            long cnt = 0;
            for(int t: times){
                cnt += mid/t; //심사 가능 인원 체크
            }
            if(cnt < n){//시간을 늘려야 해
                l = mid+1;
            }else{//시간을 줄이자, n이상만 가능하면 n만큼도 심사 가능인거임.
                r = mid -1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}
