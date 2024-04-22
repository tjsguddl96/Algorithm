import java.io.*;
import java.util.*;

public class Main {
    static int n,m,start,destination;
    static class Node{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    static class Bus implements Comparable<Bus>{
        int n;
        long d;
        ArrayList<Integer> r;
        public Bus(int n,long d,ArrayList<Integer> r){
            this.n=n;
            this.d=d;
            this.r=r;
        }
        @Override
        public int compareTo(Bus o){
            long x=this.d-o.d;
            if(x<0){
                return -1;
            }
            return 1;
        }
    }
    static long[] dist;
    static ArrayList<Node>[] arr;
    static long INF=Long.MAX_VALUE;
    static ArrayList<Integer> route=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer=new StringBuilder();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(bf.readLine());
        m=Integer.parseInt(bf.readLine());
        dist=new long[n+1];
        arr=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=new ArrayList<>();
            dist[i]=INF;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            arr[n1].add(new Node(n2,d));
        }
        st=new StringTokenizer(bf.readLine());
        start=Integer.parseInt(st.nextToken());
        destination=Integer.parseInt(st.nextToken());
        dist[start]=0L;
        PriorityQueue<Bus> pq=new PriorityQueue<>();
        route.add(start);
        pq.add(new Bus(start,0L,route));
        while(!pq.isEmpty()){
            Bus now=pq.poll();
            int nowNode=now.n;
            long nowD=now.d;
            if(nowD>dist[destination]){
                continue;
            }
            if(nowD<=dist[destination] && nowNode==destination){
                route=new ArrayList<>();
                for(int i=0;i<now.r.size();i++){
                    route.add(now.r.get(i));
                }
                nowD=dist[destination];
                continue;
            }
            ArrayList<Integer> nowR=now.r;
            for(int i=0;i<arr[nowNode].size();i++){
                Node next=arr[nowNode].get(i);
                int nextNode=next.n;
                int nextD=next.d;
                ArrayList<Integer> nextR=new ArrayList<>();
                for(int j=0;j<nowR.size();j++){
                    nextR.add(nowR.get(j));
                }
                nextR.add(nextNode);
                if(dist[nextNode]>nowD+nextD){
                    dist[nextNode]=nowD+nextD;
                    pq.add(new Bus(nextNode,dist[nextNode],nextR));
                    route=nextR;
                }
            }
        }
        answer.append(dist[destination]+"\n"+route.size()+"\n");
        for(int i=0;i<route.size();i++){
            answer.append(route.get(i)+" ");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }
}
/*
5
9
1 2 2
1 3 3
1 4 1
3 5 10
1 5 10
2 4 2
1 3 1
3 5 1
4 5 3
1 5


//입력1
1
1
1 1 1
1 1

//출력
0
1
1

//입력2
5
10
1 2 0
1 3 15
1 4 10
1 5 10
2 4 2
3 4 8
4 3 1
3 5 3
4 3 1
4 5 9
1 5

//출력
6
5
1 2 4 3 5
* */