import java.util.*;
import java.io.*;

public class Main {
    static int[] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ans=new int[n+1];
        ArrayList<Integer>[] pre=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            pre[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int prev=Integer.parseInt(st.nextToken());
            int now=Integer.parseInt(st.nextToken());
            pre[now].add(prev);
        }
        for(int i=1;i<n+1;i++){
            if(pre[i].size()==0){
                ans[i]=1;
                answer.append(ans[i]+" ");
                continue;
            }
            int max=0;
            for(int j=0;j<pre[i].size();j++){
                max=Math.max(max,ans[pre[i].get(j)]);
            }
            ans[i]=max+1;
            answer.append(ans[i]+" ");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();


    }
}