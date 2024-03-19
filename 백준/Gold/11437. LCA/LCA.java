import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static ArrayList<Integer>[] arr;
    static int[] parent;
    static int[] ch;
    static String ans;
    static StringBuilder answer=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new ArrayList[N+1];
        parent=new int[N+1];
        ch=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()){
            int now=q.poll();
            for(int i=0;i<arr[now].size();i++){
                int child=arr[now].get(i);
                if(child==parent[now]){
                    continue;
                }
                parent[child]=now;
                q.add(child);
            }
        }
        M=Integer.parseInt(bf.readLine());
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            ch=new int[N+1];
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            findParent(n1);
            findParent(n2);
            answer.append(ans);
        }
        System.out.println(answer.toString());
    }
    public static void findParent(int n){
        if(ch[n]==1){
            ans=n+"\n";
            return ;
        }
        if(n==0){
            return ;
        }
        ch[n]=1;
        findParent(parent[n]);
    }
}

/*
15
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
1 2
1 3
* */