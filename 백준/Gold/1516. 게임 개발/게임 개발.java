import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] time;
    static int[] incoming;
    static ArrayList<Integer>[] buildings;
    static PriorityQueue<Node> q=new PriorityQueue<>();
    static class Node implements Comparable<Node>{
        int n;
        int t;
        public Node(int n,int t){
            this.n=n;
            this.t=t;
        }
        @Override
        public int compareTo(Node o){
            return this.t-o.t;
        }
    }
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        time=new int[N+1];
        answer=new int[N+1];
        incoming=new int[N+1];
        buildings=new ArrayList[N+1];
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            buildings[i]=new ArrayList<>();
        }
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int n=Integer.parseInt(st.nextToken());
            time[i]=n;
            while(true){
                n=Integer.parseInt(st.nextToken());
                if(n==-1){
                    break;
                }
                buildings[n].add(i);
                incoming[i]++;
            }
            if(incoming[i]==0){
                q.add(new Node(i,time[i]));
            }
        }
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowNode=now.n;
            int nowTime=now.t;
            answer[nowNode]=nowTime;
            for(int i=0;i<buildings[nowNode].size();i++){
                int next=buildings[nowNode].get(i);
                incoming[next]--;
                if(incoming[next]==0){
                    q.add(new Node(next,nowTime+time[next]));
                }
            }
        }

        for(int i=1;i<N+1;i++){
            System.out.println(answer[i]);
        }


    }
}
/*
4
1 4 3 2 -1
2 4 -1
1 4 -1
1 -1
* */