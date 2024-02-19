import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] degree;
    static ArrayList<Integer>[] next;
    static int[] jobs;
    static class Job implements Comparable<Job>{
        int n;
        int time;
        public Job(int n,int time){
            this.n=n;
            this.time=time;
        }
        @Override
        public int compareTo(Job o){
            return this.time-o.time;
        }

    }
    static PriorityQueue<Job> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        degree=new int[N+1];
        next=new ArrayList[N+1];
        jobs=new int[N+1]; //해당 job의 소요 시간
        for(int i=1;i<N+1;i++){
            next[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int time=Integer.parseInt(st.nextToken());
            jobs[i]=time;
            degree[i]=Integer.parseInt(st.nextToken());
            for(int j=0;j<degree[i];j++){
                int p=Integer.parseInt(st.nextToken());
                next[p].add(i);
            }
        }
        for(int i=1;i<N+1;i++){
            if(degree[i]==0){
                pq.add(new Job(i,jobs[i]));
            }
        }
        int ans=0;
        while(!pq.isEmpty()){
            Job now=pq.poll();
            int n=now.n;
            int t=now.time;
            ans=t;
            for(int i=0;i<next[n].size();i++){
                int nextNode=next[n].get(i);
                degree[nextNode]--;
                if(degree[nextNode]==0){
                    pq.add(new Job(nextNode,t+jobs[nextNode]));
                }
            }
        }
        System.out.println(ans);
    }
}
/*
5
1 0
8 0
3 1 1
2 1 1
2 2 3 4

* */