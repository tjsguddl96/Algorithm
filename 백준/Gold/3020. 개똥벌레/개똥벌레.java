import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,h;
    static int[] arr1; //석순
    static int[] arr2; //종유석
    static int[] dp;
    static int[] dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());

        arr1=new int[h+1];
        arr2=new int[h+1];
        dp=new int[h+1];
        dp2=new int[h+1];

        for(int i=1;i<n+1;i++){
            int now=Integer.parseInt(br.readLine());
            if(i%2==0){ //짝수이면, 종유석 -> arr2
                arr2[now]+=1;
            }else{
                arr1[now]+=1;
            }
        }
        for(int i=h;i>=1;i--){
            if(i==h){
                dp[i]=arr1[i];
            }else{
                dp[i]=arr1[i]+dp[i+1];
            }
        }
        for(int i=h;i>=1;i--){
            if(i==h){
                dp2[i]=arr2[i];
            }else{
                dp2[i]=arr2[i]+dp2[i+1];
            }
        }
        int min=999999999;
        for(int i=1;i<=h;i++){
            if(dp[i]+dp2[h-i+1]<min) {
                min = dp[i]+dp2[h-i+1];
            }
        }
        int ans=0;
        for(int i=1;i<=h;i++){
            if(min==dp[i]+dp2[h-i+1]){
                ans+=1;
            }
        }
        System.out.println(min+" "+ans);
    }
}