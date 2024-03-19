import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] incoming;
    static class Go implements Comparable<Go>{
        int n;
        int cnt;
        public Go(int n,int cnt){
            this.n=n;
            this.cnt=cnt;
        }
        @Override
        public int compareTo(Go o){
            return this.n-o.n;
        }
    }
    static ArrayList<Go>[] goTo;
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    static HashMap<Integer,Integer>[] map;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        M=Integer.parseInt(bf.readLine());
        incoming=new int[N+1];
        goTo=new ArrayList[N+1];
        map=new HashMap[N+1];
        for(int i=1;i<N+1;i++){
            goTo[i]=new ArrayList<>();
            map[i]=new HashMap<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            incoming[x]++;
            goTo[y].add(new Go(x,k)); //y -> x로 k개
        }
        for(int i=1;i<N+1;i++){
//            Collections.sort(goTo[i]);
            if(incoming[i]==0){
                q.add(i);
                map[i].put(i,1);
            }
        }
        while(!q.isEmpty()){
            int now=q.poll();
            for(int i=0;i<goTo[now].size();i++){
                Go next=goTo[now].get(i);
                int nextNode=next.n;
                int nextCnt=next.cnt;
                incoming[nextNode]--;
                if(incoming[nextNode]==0){
                    q.add(nextNode);
                }
                for(int key:map[now].keySet()){
                    int tmpCnt=map[now].get(key);
                    if(map[nextNode].get(key)!=null){
                        map[nextNode].put(key,map[nextNode].get(key)+tmpCnt*nextCnt);
                    }
                    else{
                        map[nextNode].put(key,tmpCnt*nextCnt);
                    }
                }
            }
        }
        PriorityQueue<Go> answer=new PriorityQueue<>();
        for(int key:map[N].keySet()){
            answer.add(new Go(key,map[N].get(key)));
        }
        while(!answer.isEmpty()){
            Go ans=answer.poll();
            System.out.println(ans.n+" "+ans.cnt);
        }

    }
}
/*
7
8
6 5 2
7 6 3
6 3 3
7 4 5
5 2 2
6 4 4
5 1 2
7 5 2
* */