import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] ch;
    static int[] parent;
    static class Node implements Comparable<Node>{
        int n1;
        int n2;
        int d;
        public Node(int n1,int n2,int d){
            this.n1=n1;
            this.n2=n2;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder answer=new StringBuilder();
        int t=1;
        while(true){
            int ans=0;
            HashSet<Integer> tmp=new HashSet<>();
            st=new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            if(N==0 && M==0){
                break;
            }
            ch=new int[N+1];
            parent=new int[N+1];
            PriorityQueue<Node> pq=new PriorityQueue<>();
            for(int i=1;i<N+1;i++){
                parent[i]=i;
            }
            for(int i=0;i<M;i++){
                st=new StringTokenizer(bf.readLine());
                int n1=Integer.parseInt(st.nextToken());
                int n2=Integer.parseInt(st.nextToken());
                pq.add(new Node(n1,n2,1));
            }
            while(!pq.isEmpty()){
                Node now=pq.poll();
                int n1=now.n1;
                int n2=now.n2;
                if(findParent(n1)!=findParent(n2)){
                    union(n1,n2);
                }
                else{
                    int parent=findParent(n1);
                    ch[parent]=1;
                }
            }
            for(int i=1;i<N+1;i++){
                int parent=findParent(i);
                tmp.add(parent);
            }
            for(int val:tmp){
                if(ch[val]==0){
                    ans++;
                }
            }
            if(ans==1){
                answer.append("Case "+t+": There is one tree.\n");
            }
            else if(ans==0){
                answer.append("Case "+t+": No trees.\n");
            }
            else{
                answer.append("Case "+t+": A forest of "+ans+" trees.\n");
            }
            t++;
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
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
        if(parentA==parentB){
            return ;
        }
        if(parentA<parentB){
            parent[parentB]=findParent(parentA);
        }
        else{
            parent[parentA]=findParent(parentB);
        }
    }

}
/*
6 3
1 2
2 3
3 4
---
6 5
1 2
2 3
3 4
4 5
5 6
---
6 6
1 2
2 3
1 3
4 5
5 6
6 4
* */