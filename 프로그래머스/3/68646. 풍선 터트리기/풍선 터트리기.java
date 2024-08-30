import java.util.*;
class Solution {
    static int[] left;
    static int[] right;
    public int solution(int[] a) {
        int answer = 0;
        int N=a.length;
        left=new int[N];
        right=new int[N];
        right[0]=a[0];
        for(int i=1;i<N;i++){
            right[i]=Math.min(right[i-1],a[i]);
        }
        left[N-1]=a[N-1];
        for(int i=N-2;i>=0;i--){
            left[i]=Math.min(left[i+1],a[i]);
        }
        for(int i=0;i<N;i++){
            int now=a[i];
            if(i==0){
                if(left[i+1]<now){
                    // System.out.println(now);
                    answer++;
                }
            }
            else if(i==N-1){
                // if(right[i-1]>now){
                //     System.out.println(now);
                    answer++;
            // }
            }
            else{
                int cnt=0;
                if(now>left[i+1]){
                    cnt++;
                }
                if(now>right[i-1]){
                    cnt++;
                }
                if(cnt<=1){
                    // System.out.println(now);
                    answer++;
                }
            }
            
            
            
            
        }
        
        
        return answer;
    }
}