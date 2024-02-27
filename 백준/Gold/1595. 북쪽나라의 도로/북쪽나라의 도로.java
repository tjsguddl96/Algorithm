import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Edge>[] edges;
    static int N=10001;
    static int[] ch;
    static class Edge{
        int n;
        int d;
        public Edge(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    static int size;
    static int answer;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        edges=new ArrayList[N];
        for(int i=1;i<N;i++){
            edges[i]=new ArrayList<>();
        }
        while (true) {
            try {
                String str = sc.nextLine();
                String[] nums=str.split(" ");
                int n1=Integer.parseInt(nums[0]);
                int n2=Integer.parseInt(nums[1]);
                int d=Integer.parseInt(nums[2]);
                edges[n1].add(new Edge(n2,d));
                edges[n2].add(new Edge(n1,d));
                size=Math.max(size,n1);
                size=Math.max(size,n2);
            } catch (Exception e) {
                break;
            }
        }
        for(int i=1;i<size+1;i++){
            ch=new int[N];
            dfs(i,0);
        }
        System.out.println(answer);
    }
    static void dfs(int now,int dist){
        ch[now]=1;
        answer=Math.max(answer,dist);
        for(int i=0;i<edges[now].size();i++){
            Edge next=edges[now].get(i);
            int nextNode=next.n;
            int nextD=next.d;
            if(ch[nextNode]==0){
                dfs(nextNode,dist+nextD);
            }
        }
    }
}
/*
5 1 6
1 4 5
6 3 9
2 6 8
6 1 7
* */