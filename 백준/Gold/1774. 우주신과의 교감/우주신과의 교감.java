import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static class Node implements Comparable<Node>{
        int n1;
        int n2;
        double dist;
        public Node(int n1,int n2,double dist){
            this.n1=n1;
            this.n2=n2;
            this.dist=dist;
        }
        @Override
        public int compareTo(Node o){
            return Double.compare(this.dist,o.dist);
        }
    }
    static Position[] positions;
    static int[] res=new int[2];
    static int[] parent;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static double answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        positions=new Position[N+1];
        parent=new int[N+1];
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            positions[i]=new Position(y,x);
            parent[i]=i;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            pq.add(new Node(n1,n2,0));
        }
        combination(0,1);
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            if(union(n1,n2)){
//                System.out.println(n1+" "+n2+" "+now.dist);
                answer+=now.dist;
            }
        }
        System.out.printf("%.2f",Math.round(answer*100)*0.01);
    }
    public static boolean union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return false;
        }
        if(parentA<parentB){
            parent[parentB]=parentA;
        }else if(parentB<parentA){
            parent[parentA]=parentB;
        }
        return true;
    }
    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }
    public static void combination(int cnt,int start){
        if(cnt==2){
            pq.add(new Node(res[0],res[1],getDistance(positions[res[0]],positions[res[1]])));
            return ;
        }
        for(int i=start;i<N+1;i++){
            res[cnt]=i;
            combination(cnt+1,i+1);
        }
    }

    public static double getDistance(Position p1,Position p2){
        double Y=Math.pow(Math.abs(p1.y-p2.y),2);
        double X=Math.pow(Math.abs(p1.x-p2.x),2);
        return Math.sqrt(Y+X);
    }

}