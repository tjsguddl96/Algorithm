import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] edgeCnt;
    static ArrayList<Integer>[] edges;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static class Node implements Comparable<Node>{
        int node;
        int cnt;
        public Node(int node,int cnt){
            this.node=node;
            this.cnt=cnt;
        }
        @Override
        public int compareTo(Node o){
            return this.cnt-o.cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        edgeCnt=new int[N];
        edges=new ArrayList[N];
        for(int i=0;i<N;i++){
            edges[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            edges[n1].add(n2);
            edges[n2].add(n1);
            edgeCnt[n1]++;
            edgeCnt[n2]++;
        }
        for(int i=0;i<N;i++){
            if(edgeCnt[i]==1){
                pq.add(new Node(i,0));
            }
        }
        int prev=-1;
        int count=1;
        ArrayList<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            if(prev!=pq.peek().cnt){
                if(count>2) {
                    ans = new ArrayList<>();
                }
                count=1;
                prev=pq.peek().cnt;

            }
            else{
                count++;
            }
            Node now=pq.poll();
            int nowNode=now.node;
            int nowCnt=now.cnt;
            ans.add(nowNode);
            for(int i=0;i<edges[nowNode].size();i++){
                int next=edges[nowNode].get(i);
                edgeCnt[next]--;
                if(edgeCnt[next]==1){
                    pq.add(new Node(next,nowCnt+1));
                }
            }
        }
        Collections.sort(ans);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}