import java.io.*;
import java.util.*;

public class Main {
    static int N,R,Q;
    static ArrayList<Integer>[] arr;
    static int[] children;
    static int[] incoming;
    static int[] roots;
    static class Node{
        int n;
        int parent;
        public Node(int n,int parent){
            this.n=n;
            this.parent=parent;
        }
    }
    static ArrayDeque<Integer> q=new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        roots=new int[Q+1];
        children=new int[N+1];
        incoming=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
            incoming[n1]++;
            incoming[n2]++;
        }
        children[R]++;
        for(int i=1;i<N+1;i++){
            if(incoming[i]==1 && i!=R){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int nowNode=q.poll();
            incoming[nowNode]=0;
            children[nowNode]++;
            for(int i=0;i<arr[nowNode].size();i++){
                int nextNode=arr[nowNode].get(i);
                if(incoming[nextNode]==0){
                    continue;
                }
                incoming[nextNode]--;
                children[nextNode]+=children[nowNode];
                if(incoming[nextNode]==1 && nextNode!=R){
                    q.add(nextNode);
                }
            }
        }
        for(int i=0;i<Q;i++){
            int r=Integer.parseInt(bf.readLine());
            answer.append(children[r]+"\n");
        }
//        for(int i=1;i<N+1;i++){
//            System.out.println(i+" : "+children[i]);
//        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();


    }
}
/*
14 11 3
10 13
13 14
1 3
4 3
5 4
5 6
11 5
1 12
6 7
2 3
9 6
6 8
6 10
5
4
8

* */