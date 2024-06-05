import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static class Edge{
        int n1;
        int n2;
        long w;
        public Edge(int n1,int n2,long w){
            this.n1=n1;
            this.n2=n2;
            this.w=w;
        }
    }
    static class Node{
        int n;
        long w;
        public Node(int n,long w){
            this.n=n;
            this.w=w;
        }
    }
    static int[] ch;
    static long answer;
    static ArrayList<Node>[] arr;
    static Edge[] edge;
    static int maxIdx;
    static long maxVal;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        arr=new ArrayList[N];
        for(int i=0;i<N;i++){
            arr[i]=new ArrayList<>();
        }
        edge=new Edge[N-1];
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            edge[i]=new Edge(n1,n2,w);
            arr[n1].add(new Node(n2,w));
            arr[n2].add(new Node(n1,w));
        }
        for(int i=0;i<N-1;i++){
            Edge now=edge[i];
            int n1=now.n1;
            int n2=now.n2;
            long w=now.w;
            ch=new int[N];
            maxVal=0;
            maxIdx=-1;
            dfs(n1,0L,n1,n2);
            ch=new int[N];
            if(maxVal!=0){
                maxVal=0;
                dfs(maxIdx,0L,n1,n2);
            }
            long tmp=maxVal;
            ch=new int[N];
            maxVal=0;
            maxIdx=-1;
            dfs(n2,0L,n1,n2);
            ch=new int[N];
            if(maxVal!=0){
                maxVal=0;
                dfs(maxIdx,0L,n1,n2);
            }
            answer=Math.max(answer,maxVal+tmp+w);
        }

        System.out.println(answer);
    }
    public static void dfs(int nowNode,long nowW,int n1,int n2){
        ch[nowNode]=1;
        if(nowW>maxVal){
            maxVal=nowW;
            maxIdx=nowNode;
        }
        for(int i=0;i<arr[nowNode].size();i++){
            Node next=arr[nowNode].get(i);
            int nextNode=next.n;
            if((nowNode==n1 && nextNode==n2)||(nowNode==n2&&nextNode==n1)){
                continue;
            }
            long nextW=next.w;
            if(ch[nextNode]==0){
                ch[nextNode]=1;
                dfs(nextNode,nowW+nextW,n1,n2);
            }

        }
    }
}