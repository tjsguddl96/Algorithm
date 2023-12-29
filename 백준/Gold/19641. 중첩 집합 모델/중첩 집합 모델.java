import java.util.*;
import java.io.*;

public class Main {
    class Node implements Comparable<Node>{
        int left;
        int node;
        int right;
        public Node(int left,int node,int right){
            this.left=left;
            this.node=node;
            this.right=right;
        }
        @Override
        public int compareTo(Node o){
            return this.node-o.node;
        }
    }
    static int N,root;
    static ArrayList<Integer>[] nodes;
    static int parent[];
    static int cnt=1;
    static int[][] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        nodes=new ArrayList[N+1];
        parent=new int[N+1];
        answer=new int[N+1][2]; //0이 left, 1이 right
        for(int i=1;i<N+1;i++){
            nodes[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int node=Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int n=Integer.parseInt(st.nextToken());
                if(n==-1){
                    break;
                }
                nodes[node].add(n);
            }
            Collections.sort(nodes[node]);
        }
        root=Integer.parseInt(bf.readLine());
        dfs(root);
        for(int i=1;i<N+1;i++){
            System.out.println(i+" "+answer[i][0]+" "+answer[i][1]);
        }

    }
    public static void dfs(int now){
        answer[now][0]=cnt;
        cnt++;
        for(int i=0;i<nodes[now].size();i++){
            int next=nodes[now].get(i);
            if(answer[next][0]==0) {
                dfs(next);
            }

        }
        answer[now][1]=cnt;
        cnt++;

    }
}
/*
5
2 1 3 -1
1 2 4 5 -1
3 2 -1
4 1 -1
5 1 -1
2


7
2 1 3 -1
1 2 4 5 -1
3 2 6 7 -1
4 1 -1
5 1 -1
6 3 -1
7 3 -1
2



* */