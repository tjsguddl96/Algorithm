import java.util.*;
import java.io.*;

public class Main {
    static int V,E,M,S,x,y;
    static ArrayList<Dist>[] arr;
    static class Dist implements Comparable<Dist>{
        int n;
        int w;
        public Dist(int n,int w){
            this.n=n;
            this.w=w;
        }
        @Override
        public int compareTo(Dist o){
            return this.w-o.w;
        }
    }
    static int[] mc;
    static int[] star;
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        arr=new ArrayList[V+1];
        for(int i=1;i<V+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            arr[n1].add(new Dist(n2,w));
            arr[n2].add(new Dist(n1,w));
        }
        st=new StringTokenizer(bf.readLine());
        M=Integer.parseInt(st.nextToken());
        mc=new int[M];
        x=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        int[] dist1=new int[V+1];
        int[] dist2=new int[V+1];
        for(int i=1;i<V+1;i++){
            dist1[i]=INF;
            dist2[i]=INF;
        }
        for(int i=0;i<M;i++){
            mc[i]=Integer.parseInt(st.nextToken());
            dist1[mc[i]]=0;
        }
        st=new StringTokenizer(bf.readLine());
        S=Integer.parseInt(st.nextToken());
        star=new int[S];
        y=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<S;i++){
            star[i]=Integer.parseInt(st.nextToken());
            dist2[star[i]]=0;
        }
        PriorityQueue<Dist> pq=new PriorityQueue<>();
        for(int i=0;i<M;i++){
            pq.add(new Dist(mc[i],0));
        }
        while(!pq.isEmpty()){
            Dist now=pq.poll();
            int nowNode=now.n;
            int nowDist=now.w;
            for(int i=0;i<arr[nowNode].size();i++){
                Dist next=arr[nowNode].get(i);
                int nextNode=next.n;
//                if(dist1[nextNode]==0 || dist2[nextNode]==0){
//                    continue;
//                }
                if(dist1[nextNode]>nowDist+next.w){
                    dist1[nextNode]=nowDist+next.w;
                    pq.add(new Dist(nextNode,dist1[nextNode]));
                }
            }
        }
        for(int i=0;i<S;i++){
            pq.add(new Dist(star[i],0));
        }
        while(!pq.isEmpty()){
            Dist now=pq.poll();
            int nowNode=now.n;
            int nowDist=now.w;
            for(int i=0;i<arr[nowNode].size();i++){
                Dist next=arr[nowNode].get(i);
                int nextNode=next.n;
//                if(dist1[nextNode]==0 || dist2[nextNode]==0){
//                    continue;
//                }
                if(dist2[nextNode]>nowDist+next.w ){
                    dist2[nextNode]=nowDist+next.w;
                    pq.add(new Dist(nextNode,dist2[nextNode]));
                }
            }
        }
        int Min=INF;
        for(int i=1;i<V+1;i++){
            if(dist1[i]==0 || dist2[i]==0){
                continue;
            }
//            System.out.println(i+" "+min1+" "+min2);
            if(dist1[i]<=x && dist2[i]<=y && Min>dist1[i]+dist2[i]){
                Min=dist1[i]+dist2[i];
            }
        }
        if(Min==INF){
            Min=-1;
        }
        ans.append(Min);
        bw.flush();
        bw.write(ans.toString());
        bw.close();
    }
}
/*
8 11
1 2 20
1 4 10
2 4 20
2 3 10
2 7 80
3 7 30
4 5 20
4 6 10
6 7 60
6 8 40
7 8 20
2 6
1 5
1 4
8

8 11
1 2 2
1 4 1
2 4 2
2 3 1
2 7 8
3 7 3
4 5 2
4 6 1
6 7 6
6 8 4
7 8 2
2 6
1 5
1 4
1
* */