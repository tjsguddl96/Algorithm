import java.util.*;
import java.io.*;
public class Main {
    static int N,M,A,B,C;
    static int[] d;
    static class Node{
        int n;
        int w;
        public Node(int n,int w){
            this.n=n;
            this.w=w;
        }
    }
    static ArrayList<Node>[] arr;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        d=new int[N+1];
        arr=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            arr[i]=new ArrayList<>();
            d[i]=Integer.MAX_VALUE;
        }
        d[A]=0;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }
        solve(A,0,0);
        if(answer==Integer.MAX_VALUE){
            answer=-1;
        }
        System.out.println(answer);
    }
    public static void solve(int now,int money,int min){
        if(money>C || d[now]<money){
            return ;
        }
        if(now==B){
            answer=Math.min(min,answer);
            return ;
        }
        for(int i=0;i<arr[now].size();i++){
            Node next=arr[now].get(i);
            int nextNode=next.n;
            int nextW=next.w;
            if(money+nextW<d[nextNode]){
                d[nextNode]=money+nextW;
                solve(nextNode,money+nextW,Math.max(min,nextW));
            }
        }

    }
}