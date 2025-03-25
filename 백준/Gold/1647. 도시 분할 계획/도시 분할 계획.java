import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static class Road implements Comparable<Road>{
        int a;
        int b;
        int c;
        public Road(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
        @Override
        public int compareTo(Road o){
            return this.c-o.c;
        }
    }
    static PriorityQueue<Road> roads=new PriorityQueue<>();
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parents=new int[N+1];
        for(int i=1;i<N+1;i++){
            parents[i]=i;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            roads.add(new Road(a,b,c));
        }
        long answer=0L;
        int max=0;
        while(!roads.isEmpty()){
            Road now=roads.poll();
            int nowA=now.a;
            int nowB=now.b;
            int nowC=now.c;
            if(findParent(nowA)!=findParent(nowB)){
                union(nowA,nowB);
                answer+=nowC;
                max=Math.max(max,nowC);
            }
        }
//        System.out.println(answer+" "+max);
        System.out.println(answer-max);
    }
    public static int findParent(int x){
        if(x==parents[x]){
            return x;
        }
        return parents[x]=findParent(parents[x]);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return ;
        }
        else if(parentA<parentB){
            parents[parentB]=parentA;
        }
        else{
            parents[parentA]=parentB;
        }

    }
}
