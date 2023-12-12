import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }
    }

    static int N,R; //N:노드 갯수, R:루트 노드 번호
    static int[] ch;
    static long answerBranch;
    static ArrayList<Node> arr[];
    static ArrayDeque<Node> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        ch=new int[N+1];
        for(int i=0;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            arr[n1].add(new Node(n2,d));
            arr[n2].add(new Node(n1,d));
        }
        //findGiga
        long answerTree = 0L;
        int gigaNode = 0;
        if(arr[R].size()==1) {
            q.add(new Node(R, 0));
            ch[R] = 1;
            gigaNode = 0;
            while (!q.isEmpty()) {
                Node now = q.poll();
                int nowNode = now.n;
                int nowDist = now.d;
                answerTree += nowDist;
                if (arr[nowNode].size() >= 3) {
                    gigaNode = nowNode;
                    break;
                }
                ch[nowNode] = 1;
                for (int i = 0; i < arr[nowNode].size(); i++) {
                    Node next = arr[nowNode].get(i);
                    int nextNode = next.n;
                    int nextDist = next.d;
                    if (ch[nextNode] == 0) {
                        ch[nextNode] = 1;
                        q.add(new Node(nextNode, nextDist));
                    }
                }
            }
        }else{
            gigaNode=R;
        }
        dfs(gigaNode,0);


        System.out.println(answerTree+" "+answerBranch);
    }
    static public void dfs(int now,long dist){
        if(arr[now].size()==1){
            answerBranch=Math.max(answerBranch,dist);
            return ;
        }
        ch[now]=1;
        for(int i=0;i<arr[now].size();i++){
            Node next=arr[now].get(i);
            int nextNode=next.n;
            int nextDist=next.d;
            if(ch[nextNode]==0){
                ch[nextNode]=1;
                dfs(nextNode,dist+nextDist);
            }
        }
    }



}