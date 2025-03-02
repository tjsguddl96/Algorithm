import java.util.*;

class Solution {
    static int[] sum;
    static int[] arr;
    static int answer;
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        sum=new int[24];
        arr=new int[24];
        for(int i=0;i<24;i++){
            if(i==0){
                sum[i]=arr[i];
            }
            else{
                sum[i]=sum[i-1]+arr[i];
            }
            if(players[i]/m>sum[i]){
                int tmp=players[i]/m-sum[i];
                arr[i]+=tmp;
                if(i+k<=23){
                    arr[i+k]+=tmp*(-1);        
                }
                // System.out.println(i+" "+tmp);
                if(i==0){
                    sum[i]=arr[i];
                }
                else{
                    sum[i]=sum[i-1]+arr[i];
                }
                answer+=tmp;
                
            }
            
            
        }
        
        
        
        return answer;
    }
}