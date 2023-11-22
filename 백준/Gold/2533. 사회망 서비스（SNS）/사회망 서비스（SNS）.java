import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer;
    static int[] ch;
    static int[] color;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        tree=new ArrayList[N+1];
        ch=new int[N+1];
        color=new int[N+1];
        for(int i=1;i<N+1;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
//        System.out.println(answer);
        ch[1]=1;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int now){
        int tmp=0;
        for(int i=0;i<tree[now].size();i++){
            int next=tree[now].get(i);
            if(ch[next]==0){
                ch[next]=1;
                dfs(next);
            }
            if(color[next]==1){
                tmp+=1;
            }
        }
        if(now==1){
            if(tmp!=tree[now].size()){
                color[now]=1;
                answer+=1;
            }
        }
        else if(tmp!=tree[now].size()-1){
            color[now]=1;
            answer+=1;
        }
//        System.out.println(now+", color[now] : "+color[now]+", tmp : "+tmp+", tree[now].size() : "+tree[now].size());

    }
}
/*
10
1 2
1 3
1 4
2 5
2 6
6 9
6 10
4 7
4 8



5
1 2
1 3
1 4
1 5

* */