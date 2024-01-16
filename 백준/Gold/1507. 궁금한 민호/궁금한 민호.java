import java.util.*;
import java.io.*;

public class Main {
    static int INF=999999999;
    static class Node implements Comparable<Node>{
        int n1;
        int n2;
        int d;
        public Node(int n1,int n2,int d){
            this.n1=n1;
            this.n2=n2;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(bf.readLine());
        int[][] dist=new int[n][n];
        int[][] tmp=new int[n][n];
        int[] parent=new int[n];
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            parent[i]=i;
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.parseInt(st.nextToken());
                tmp[i][j]=INF;
                if(j>i){
                    pq.add(new Node(i,j,dist[i][j]));
                }
            }
        }
        int answer=0;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int d=now.d;
            int flag=0;
            for(int k=0;k<n;k++){
                if(tmp[n1][k]!=INF && tmp[k][n2]!=INF && dist[n1][n2]==tmp[n1][k]+tmp[k][n2]){
                    tmp[n1][n2]=dist[n1][n2];
                    tmp[n2][n1]=dist[n2][n1];
                    flag=1;
                    break;
                }

                else if(tmp[n1][k]!=INF && tmp[k][n2]!=INF && dist[n1][n2]>tmp[n1][k]+tmp[k][n2]){
                    answer=-1;
                    break;
                }
            }
            if(answer==-1){
                break;

            }
            if(flag==0){
                tmp[n1][n2]=dist[n1][n2];
                tmp[n2][n1]=dist[n2][n1];
//                System.out.println((n1+1)+" "+(n2+1));
                answer+=dist[n1][n2];
            }
        }





        System.out.println(answer);
//        print(dist);

    }
    public static int findParent(int x,int[] parent){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x],parent);
    }
    public static void union(int a,int b,int[] parent){
        int parentA=findParent(a,parent);
        int parentB=findParent(b,parent);
        if(parentA==parentB){
            return ;
        }
        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }

    public static void print(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}