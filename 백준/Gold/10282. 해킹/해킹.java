import java.util.*;
import java.io.*;
public class Main {
    static int T;
    static int n,d,c; //n:컴퓨터갯수,d:의존성 갯수, c:해킹당한 컴퓨터 번호
    static ArrayList<Node>[] arr;
    static class Node implements Comparable<Node>{
        int n;
        int s;
        public Node(int n,int s){
            this.n=n;
            this.s=s;
        }
        @Override
        public int compareTo(Node o){
            return this.s-o.s;
        }
    }
    static int[] infected;
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            HashSet<Integer> ansC=new HashSet<>();
            int ansS=0;
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            arr=new ArrayList[n+1];
            infected=new int[n+1];
            for(int i=1;i<n+1;i++){
                arr[i]=new ArrayList<>();
                infected[i]=INF;
            }
            for(int i=0;i<d;i++){
                st=new StringTokenizer(bf.readLine());
                //n1이 n2에 의존, n2가 감염되면 s초 후 n1도 감염 n2->n1
                int n1=Integer.parseInt(st.nextToken());
                int n2=Integer.parseInt(st.nextToken());
                int s=Integer.parseInt(st.nextToken());
                arr[n2].add(new Node(n1,s));
            }
            PriorityQueue<Node> pq=new PriorityQueue<>();
            pq.add(new Node(c,0));
            infected[c]=0;
            while(!pq.isEmpty()){
                Node now=pq.poll();
                int nowNode=now.n;
                int nowS=now.s;
                if(ansS<infected[nowNode]){
                    ansS=infected[nowNode];
                }
                for(int i=0;i<arr[nowNode].size();i++){
                    Node next=arr[nowNode].get(i);
                    int nextNode=next.n;
                    int nextS=next.s;
                    if(infected[nextNode]>(nowS+nextS)){
                        ansC.add(nextNode);
                        infected[nextNode]=nowS+nextS;
                        pq.add(new Node(nextNode,infected[nextNode]));
                    }
                }
            }
            int ansCnt=ansC.size()+1;
            answer.append(ansCnt+" "+ansS+"\n");

        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}