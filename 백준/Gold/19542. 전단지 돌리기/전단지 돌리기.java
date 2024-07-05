import java.util.*;
import java.io.*;
public class Main {
    static int N,S,D;
    static ArrayList<Integer>[] arr;
    static int[] depth;
    static int[] ch;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        depth=new int[N+1];
        ch=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        ch[S]=1;
        dfs(S);
        ch=new int[N+1];
        ch[S]=1;
        cal(S);
        System.out.println(cnt*2);

    }
    public static void cal(int now){
        for(int i=0;i<arr[now].size();i++){
            int next=arr[now].get(i);
            if(ch[next]==0 && depth[next]>=D){
                ch[next]=1;
                cnt++;
                cal(next);
            }
        }
    }
    public static void dfs(int now){
        for(int i=0;i<arr[now].size();i++){
            int next=arr[now].get(i);
            if(ch[next]==0){
                ch[next]=1;
                dfs(next);
                depth[now]=Math.max(depth[now],depth[next]+1);
            }
        }
    }


}
/*
18 4 2
4 3
4 11
4 10
3 14
11 12
12 13
10 5
5 9
2 10
2 6
6 8
8 15
8 7
2 1
18 1
16 1
16 17
*
* */