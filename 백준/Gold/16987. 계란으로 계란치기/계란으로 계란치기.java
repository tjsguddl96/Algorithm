import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] strength;
    static int[] weight;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        strength=new int[N];
        weight=new int[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            strength[i]=Integer.parseInt(st.nextToken());
            weight[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(ans);
    }
    public static void dfs(int now,int answer){
        ans=Math.max(ans,answer);
        if(now==N){
            return ;
        }
        if(strength[now]<=0){
            dfs(now+1,answer);
        }
        else {
            for (int i = 0; i < N; i++) {
                if (now != i && strength[i] > 0) {
                    strength[now] -= weight[i];
                    strength[i] -= weight[now];
                    if (strength[now] <= 0 && strength[i]<=0) {
                        answer+=2;
                    }
                    else if (strength[i] <= 0 && strength[now] > 0) {
                        answer+=1;
                    }
                    else if (strength[now] <= 0 && strength[i] > 0) {
                        answer+=1;
                    }
                    dfs(now + 1,answer);
                    if (strength[now] <= 0 && strength[i]<=0) {
                        answer-=2;
                    }
                    else if (strength[i] <= 0 && strength[now] > 0) {
                        answer-=1;
                    }
                    else if (strength[now] <= 0 && strength[i] > 0) {
                        answer-=1;
                    }
                    strength[now] += weight[i];
                    strength[i] += weight[now];
                }
            }
        }

    }
}