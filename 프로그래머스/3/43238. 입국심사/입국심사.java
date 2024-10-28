import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left=0L;
        long right=(long)times[times.length-1]*(long)(n+1);
        long mid=0L;
        while(left<=right){
            mid=(left+right)/2;
            long cnt=0L;
            for(int i=0;i<times.length;i++){
                cnt+=(mid/(long)times[i]);
            }
            if(cnt<n){
                left=mid+1;
            }
            else{
                answer=mid;
                right=mid-1;
            }
        }
        
        return answer;
    }
}