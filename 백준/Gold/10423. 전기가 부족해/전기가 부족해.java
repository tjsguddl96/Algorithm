import java.io.*;
import java.util.*;
public class Main {
    static int N,M,K;
    static class City{
        int n;
        int w;
        public City(int n,int w){
            this.n=n;
            this.w=w;
        }
    }
    static ArrayList<City>[] cities;
    static class Cable implements Comparable<Cable>{
        int n1;
        int n2;
        int w;
        public Cable(int n1,int n2,int w){
            this.n1=n1;
            this.n2=n2;
            this.w=w;
        }
        @Override
        public int compareTo(Cable o){
            return this.w-o.w;
        }
    }
    static int[] parent;
    static HashSet<Integer> power=new HashSet<>();
    static PriorityQueue<Cable> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        cities=new ArrayList[N+1];
        parent=new int[N+1];
        for(int i=1;i<N+1;i++){
            cities[i]=new ArrayList<>();
            parent[i]=i;
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<K;i++){
            int p=Integer.parseInt(st.nextToken());
            power.add(p);
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            if(power.contains(n1) || power.contains(n2)){
                pq.add(new Cable(n1,n2,w));
            }else{
                cities[n1].add(new City(n2,w));
                cities[n2].add(new City(n1,w));
            }
        }
        int answer=0;
        while(!pq.isEmpty()){
            Cable now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int w=now.w;
            if(!power.contains(findParent(n1)) || !power.contains(findParent(n2))){
                if(power.contains(findParent(n1))){
                    for(int i=0;i<cities[n2].size();i++){
                        City next=cities[n2].get(i);
                        pq.add(new Cable(n2,next.n,next.w));
                    }
                }
                else{
                    for(int i=0;i<cities[n1].size();i++){
                        City next=cities[n1].get(i);
                        pq.add(new Cable(n1,next.n,next.w));
                    }
                }
                union(n1,n2);
                answer+=w;
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
        if(power.contains(parentA) && power.contains(parentB)){
            return ;
        }
        if(power.contains(parentA)){
            parent[parentB]=parentA;
        }
        else if(power.contains(parentB)){
            parent[parentA]=parentB;
        }

    }
}