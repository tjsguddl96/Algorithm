class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long left=0L;
        long right=1000000000000000L;
        long mid=0L;
        long Mid=0L;
        while(left<=right){
            mid=(left+right)/2;
            long gCnt=0L;
            long sCnt=0L;
            long cnt=0L;
            
            for(int i=0;i<s.length;i++){
                long tmp=mid/t[i];
                long tmp2=0L; //   tmp/2=금이든 은이든 마을에 뿌리는 횟수
                if(tmp%2==0){
                    tmp2=tmp/2;
                }
                else{
                    tmp2=(tmp+1)/2;
                }
                gCnt+=Math.min(g[i],tmp2*w[i]);
                sCnt+=Math.min(s[i],tmp2*w[i]);
                cnt+=Math.min(g[i]+s[i],tmp2*w[i]);
                
            }
            if(gCnt>=a && sCnt>=b && cnt>=(a+b)){
                Mid=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        
        
        
        return Mid;
    }
}