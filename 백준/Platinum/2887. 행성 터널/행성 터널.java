import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static class Node implements Comparable<Node>{
        int position;
        int idx;
        public Node(int position,int idx){
            this.position=position;
            this.idx=idx;
        }
        @Override
        public int compareTo(Node o){
            return this.position-o.position;
        }
    }
    static class Planet implements Comparable<Planet>{
        int p1;
        int p2;
        long d;
        public Planet(int p1,int p2,long d){
            this.p1=p1;
            this.p2=p2;
            this.d=d;
        }
        @Override
        public int compareTo(Planet o){
            long x=this.d-o.d;
            if(x>0){
                return 1;
            }
            return -1;
        }


    }
    static PriorityQueue<Planet> pq=new PriorityQueue<>();
    static ArrayList<Node> arrX=new ArrayList<>();
    static ArrayList<Node> arrY=new ArrayList<>();
    static ArrayList<Node> arrZ=new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        parent=new int[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            parent[i]=i;
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());
            arrX.add(new Node(x,i));
            arrY.add(new Node(y,i));
            arrZ.add(new Node(z,i));
        }
        Collections.sort(arrX);
        Collections.sort(arrY);
        Collections.sort(arrZ);
        for(int i=0;i<N-1;i++){
            int xP1=arrX.get(i).idx;
            int xP2=arrX.get(i+1).idx;
            int yP1=arrY.get(i).idx;
            int yP2=arrY.get(i+1).idx;
            int zP1=arrZ.get(i).idx;
            int zP2=arrZ.get(i+1).idx;
            int diffX=Math.abs(arrX.get(i).position-arrX.get(i+1).position);
            int diffY=Math.abs(arrY.get(i).position-arrY.get(i+1).position);
            int diffZ=Math.abs(arrZ.get(i).position-arrZ.get(i+1).position);
            pq.add(new Planet(xP1,xP2,diffX));
            pq.add(new Planet(yP1,yP2,diffY));
            pq.add(new Planet(zP1,zP2,diffZ));
        }
        long answer=0;
        while(!pq.isEmpty()){
            Planet now=pq.poll();
            int p1=now.p1;
            int p2=now.p2;
            long d=now.d;
            if(findParent(p1)!=findParent(p2)){
                union(p1,p2);
                answer+=d;
            }
        }
        System.out.println(answer);
    }
    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return ;
        }
        else if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }

    }
}
/*
3
1 1 1
2 3 9
-1 9 5
* */