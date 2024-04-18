import java.io.*;
import java.util.*;

public class Main {
    static int N,T;
    static long maxCnt=0L;
    static long minW=Long.MAX_VALUE;
    static class Node{
        int n;
        int w;
        public Node(int n,int w){
            this.n=n;
            this.w=w;
        }
    }
    static ArrayList<Node>[] arr;
    static int[] ch;
    static int maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        ch=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            arr[n1].add(new Node(n2,w));
            arr[n2].add(new Node(n1,w));
        }
        int startNode=0;
        for(int i=1;i<N+1;i++){
            if(arr[i].size()==1){
                startNode=i;
                break;
            }
        }
        dfs(startNode,0,0);
        ch=new int[N+1];
        dfs(maxNode,0,0);
        long answer=0L;
        if(minW%T==0){
            answer=(long)(minW/T);
        }
        else{
            answer=(long)(minW/T)+1L;
        }
        System.out.println(answer);
    }
    public static void dfs(int nowNode,int nowW,int nowCnt){
        ch[nowNode]=1;
        if(maxCnt<nowCnt){
            maxCnt=nowCnt;
            minW=nowW;
            maxNode=nowNode;
        }
        else if(maxCnt==nowCnt){
            if(nowW<minW){
                minW=nowW;
                maxNode=nowNode;
            }
        }
        for(int i=0;i<arr[nowNode].size();i++){
            Node next=arr[nowNode].get(i);
            int nextNode=next.n;
            int nextW=next.w;
            if(ch[nextNode]==0){
                dfs(nextNode,nowW+nextW,nowCnt+1);
            }
        }
    }
}
/*
10 12
4 2 1
2 1 1
7 3 1
9 6 1
3 8 2
1 5 1
1 3 2
3 6 20
8 10 10
->2

10 12
4 1 1
1 5 1
1 3 2
3 6 20
6 9 1
3 7 1
3 8 2
8 2 10
10 9 5
->3

14 5
1 2 4
2 3 2
4 3 7
3 7 1
7 8 2
8 9 2
3 10 4
10 12 4
12 5 1
5 6 5
10 11 5
11 13 2
13 14 7
-> 4

4 3
1 2 4
2 3 2
3 4 7
->5

4 30
1 2 4
2 3 2
3 4 7
->1

5 3
1 2 4
2 3 2
3 4 7
3 5 1
->3

9 3
1 2 4
2 3 2
3 4 7
3 5 1
5 6 1
6 7 1
7 8 1
5 9 1
->4

9 3
1 2 6
2 3 2
3 4 7
3 5 1
5 6 1
6 7 1
7 8 1
5 9 1
->4

* */