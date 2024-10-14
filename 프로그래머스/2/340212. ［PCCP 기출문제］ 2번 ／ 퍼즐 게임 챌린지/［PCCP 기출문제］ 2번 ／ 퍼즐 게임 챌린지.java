class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int N=diffs.length;
        int left=1;
        int right=100001;
        int mid=0;
        
        
        while(left<=right){
            mid=(left+right)/2;
            long time=0L;
            for(int i=0;i<N;i++){
                if(diffs[i]<=mid || i==0){ //퍼즐을 틀리지 않음 -> time_cur만 사용
                    time+=times[i];
                }
                else{ //퍼즐 틀림 -> 이전 타임도 사용
                    int cnt=diffs[i]-mid;
                    time+=(long)((long)((times[i]+times[i-1])*cnt)+times[i]);
                }
                
            }
            if(time>limit){
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