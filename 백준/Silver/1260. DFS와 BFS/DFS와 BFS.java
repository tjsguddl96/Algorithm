import java.io.*;
import java.util.*;

public class Main {
    static int N,M,V;
    static ArrayList<Integer>[] arr;
    static int ch1[];
    static int ch2[];
    static ArrayList<Integer> answerDFS=new ArrayList<>();
    static ArrayList<Integer> answerBFS=new ArrayList<>();
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        V=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        ch1=new int[N+1];
        ch2=new int[N+1];
        for(int i=0;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        for(int i=0;i<N+1;i++){
            Collections.sort(arr[i]);
        }
        ch1[V]=1;
        q.add(V);
        while(!q.isEmpty()){
            int now=q.poll();
            ch1[now]=1;
            answerBFS.add(now);
            for(int i=0;i<arr[now].size();i++){
                int next=arr[now].get(i);
                if(ch1[next]==0){
                    ch1[next]=1;
                    q.add(next);
                }
            }
        }
        dfs(V);
        for(int i=0;i<answerDFS.size();i++){
            System.out.print(answerDFS.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<answerBFS.size();i++){
            System.out.print(answerBFS.get(i)+" ");
        }
    }
    public static void dfs(int now){
        ch2[now]=1;
        answerDFS.add(now);
        if(answerDFS.size()==N){
            return ;
        }
        for(int i=0;i<arr[now].size();i++){
            int next=arr[now].get(i);
            if(ch2[next]==0){
                ch2[next]=1;
                dfs(next);
            }
        }
    }
}