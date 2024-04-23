import java.io.*;
import java.sql.Array;
import java.util.*;
public class Main {
    static int N;
    static int[] point;
    static ArrayList<Integer>[] arr;
    static int[][] dist;
    static int INF=Integer.MAX_VALUE;
    static class Node{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        arr=new ArrayList[N+1];
        point=new int[N+1];
        dist=new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
            for(int j=1;j<N+1;j++){
                if(i==j){
                    continue;
                }
                dist[i][j]=INF;
            }
        }
        while(true){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            if(n1==-1 && n2==-1){
                break;
            }
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        for(int i=1;i<N+1;i++){
            djkstra(i);
        }
        ArrayList<Integer> answer=new ArrayList<>();
        int minPoint=Integer.MAX_VALUE;
        for(int i=1;i<N+1;i++){
            if(point[i]<minPoint){
                answer=new ArrayList<>();
                minPoint=point[i];
                answer.add(i);
            }
            else if(point[i]==minPoint){
                answer.add(i);
            }
        }
        System.out.println(minPoint+" "+answer.size());
        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i)+" ");
        }
    }
    public static void djkstra(int node){
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(new Node(node,0));
        dist[node][node]=0;
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowNode=now.n;
            int nowD=now.d;
            for(int i=0;i<arr[nowNode].size();i++){
                int nextNode=arr[nowNode].get(i);
                if(dist[node][nextNode]>nowD+1){
                    dist[node][nextNode]=nowD+1;
                    q.add(new Node(nextNode,dist[node][nextNode]));
                }
            }
        }
        int max=0;
        for(int i=1;i<N+1;i++){
            max=Math.max(max,dist[node][i]);
        }
        point[node]=max;
    }
}