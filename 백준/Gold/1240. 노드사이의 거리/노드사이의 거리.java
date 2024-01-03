import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static class Node{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    static ArrayList<Node>[] arr;
    static int[] ch;
    static ArrayList<Integer> answer=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        ch=new int[N+1];
        arr=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            arr[n1].add(new Node(n2,d));
            arr[n2].add(new Node(n1,d));
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            ch=new int[N+1];
            dfs(n1,n2,0);
        }
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }

    }
    public static void dfs(int now,int destination,int nowDist){
        ch[now]=1;
        if(now==destination){
            answer.add(nowDist);
            return ;
        }
        for(int i=0;i<arr[now].size();i++){
            int next=arr[now].get(i).n;
            int nextD=arr[now].get(i).d;
            if(ch[next]==0){
                ch[next]=1;
                dfs(next,destination,nowDist+nextD);
            }
        }

    }
}