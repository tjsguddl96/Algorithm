import java.util.*;

class Solution {
    static int dp[];
    static int single[];
    static int fire[];
    static int tmp[];
    public int[] solution(int target) {
        int[] answer = {};
        tmp=new int[22];
        for(int i=1;i<22;i++){
            if(i==21){
                tmp[i]=50;
            }
            else{
                tmp[i]=i;
            }
        }
        dp=new int[100001];
        single=new int[100001];
        fire=new int[100001];
        for(int i=0;i<=target;i++){
            dp[i]=999999999;
        }
        for(int i=1;i<=20;i++){
            dp[i]=1;
            single[i]=1;
            fire[i]=0;
            dp[i*2]=1;
            single[i*2]=0;
            fire[i*2]=0;
            dp[i*3]=1;
            single[i*3]=0;
            fire[i*3]=0;
        }
        dp[50]=1;
        single[50]=0;
        fire[50]=1;
        
        
        for(int i=1;i<=target;i++){
            for(int j=21;j>=1;j--){
                int t=tmp[j];
                int t2=t*2;
                int t3=t*3;
                if(t>i){
                    continue;
                }
                if(dp[t]+dp[i-t]<dp[i]){
                    single[i]=single[t]+single[i-t];
                    fire[i]=fire[t]+fire[i-t];
                    dp[i]=dp[t]+dp[i-t];
                }else if(dp[t]+dp[i-t]<dp[i]){
                    if(single[i]+fire[i]<single[t]+single[i-t]+fire[t]+single[i-t]){
                        single[i]=single[t]+single[i-t];
                        fire[i]=fire[t]+fire[i-t];
                    }
                }
                if(t2>i){
                    continue;
                }
                if(dp[t2]+dp[i-t2]<dp[i]){
                    single[i]=single[t2]+single[i-t2];
                    fire[i]=fire[t2]+fire[i-t2];
                    dp[i]=dp[t2]+dp[i-t2];
                }else if(dp[t2]+dp[i-t2]<dp[i]){
                    if(single[i]+fire[i]<single[t2]+single[i-t2]+fire[t2]+single[i-t2]){
                        single[i]=single[t2]+single[i-t2];
                        fire[i]=fire[t2]+fire[i-t2];
                    }
                }
                if(t3>i){
                    continue;
                }
                if(dp[t3]+dp[i-t3]<dp[i]){
                    single[i]=single[t3]+single[i-t3];
                    fire[i]=fire[t3]+fire[i-t3];
                    dp[i]=dp[t3]+dp[i-t3];
                }else if(dp[t3]+dp[i-t3]<dp[i]){
                    if(single[i]+fire[i]<single[t3]+single[i-t3]+fire[t3]+single[i-t3]){
                        single[i]=single[t3]+single[i-t3];
                        fire[i]=fire[t3]+fire[i-t3];
                    }
                }
            }
        }
        answer=new int[2];
        answer[0]=dp[target];
        answer[1]=single[target]+fire[target];
        
        
        return answer;
    }
}