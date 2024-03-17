import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] answer;
    static int K,M,P;
    static ArrayList<Integer>[] arr;
    static int[] incoming;
    static class Node implements Comparable<Node>{
        int n;
        public Node(int n){
            this.n=n;
        }
        @Override
        public int compareTo(Node o){
            return o.n-this.n;
        }
    }
    static PriorityQueue<Node>[] pq;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(bf.readLine());
        answer=new int[T+1];
        StringTokenizer st;
        for(int t=1;t<T+1;t++){
            st=new StringTokenizer(bf.readLine());
            K=Integer.parseInt(st.nextToken()); //해당 테스트케이스 번호
            M=Integer.parseInt(st.nextToken()); //노드 수
            P=Integer.parseInt(st.nextToken()); //간선 수
            arr=new ArrayList[M+1];
            pq=new PriorityQueue[M+1];
            incoming=new int[M+1];
            for(int i=1;i<M+1;i++){
                arr[i]=new ArrayList<>();
                pq[i]=new PriorityQueue<>();
            }
            for(int i=0;i<P;i++){
                st=new StringTokenizer(bf.readLine());
                int n1=Integer.parseInt(st.nextToken());
                int n2=Integer.parseInt(st.nextToken());
                incoming[n2]++;
                arr[n1].add(n2);
            }
            ArrayDeque<Integer> q=new ArrayDeque<>();
            for(int i=1;i<M+1;i++){
                if(incoming[i]==0){
                    q.add(i);
                    pq[i].add(new Node(1));
                }
            }
            while(!q.isEmpty()){
                int now=q.poll();
                if(pq[now].size()>=2){
                    Node max=pq[now].poll();
                    if(pq[now].peek().n==max.n){
                        max=new Node(max.n+1);
                    }
                    pq[now].add(max);
                }
                Node nowNode=pq[now].peek();
                for(int i=0;i<arr[now].size();i++){
                    int next=arr[now].get(i);
                    pq[next].add(new Node(nowNode.n));
                    incoming[next]--;
                    if(incoming[next]==0){
                        q.add(next);
                    }
                }
            }
            answer[K]=pq[M].peek().n;
        }
        for(int i=1;i<T+1;i++){
            System.out.println(i+" "+answer[i]);
        }
    }
}
/*
1
1 8 11
1 3
2 3
6 4
3 4
3 5
6 7
5 7
4 7
4 8
5 8
7 8
-> 3
* */