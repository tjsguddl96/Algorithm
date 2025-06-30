import java.util.*;
import java.io.*;

public class Main {
    static int N,W,cnt;
    static ArrayList<Integer>[] arr;
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        ch=new int[N+1];
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        ch[1]=1;
        solve(1);
        System.out.println((double)((double)W/(double)cnt));




    }
    public static void solve(int now){
        if(arr[now].size()==1 && ch[arr[now].get(0)]==1){
            cnt++;
            return ;
        }
        for(int i=0;i<arr[now].size();i++){
            int next=arr[now].get(i);
            if(ch[next]==0) {
                ch[next]=1;
                solve(next);
            }
        }
    }

}

/**
 *
 *
4 20
3 4
3 2
1 2
 */









/*

* */