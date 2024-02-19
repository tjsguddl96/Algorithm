import java.util.*;
import java.io.*;

public class Main {
    static int N,M; //  가수, 보조 pd 수
    static ArrayList<Integer>[] input;
    static ArrayList<Integer>[] next;
    static int[] degree;
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        input=new ArrayList[M];
        next=new ArrayList[N+1];
        degree=new int[N+1];
        for(int i=1;i<N+1;i++){
            next[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            input[i]=new ArrayList<>();
            st=new StringTokenizer(bf.readLine());
            int n=Integer.parseInt(st.nextToken());
            for(int j=0;j<n;j++){
                int now=Integer.parseInt(st.nextToken());
                input[i].add(now);
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<input[i].size();j++){
                int now=input[i].get(j);
                if(j!=0){
                    degree[now]++;
                }
                if(j!=input[i].size()-1) {
                    next[now].add(input[i].get(j + 1));
                }
            }
        }
        for(int i=1;i<N+1;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int now=q.poll();
            ans.add(now);
            for(int i=0;i<next[now].size();i++){
                int nextNode=next[now].get(i);
                degree[nextNode]--;
                if(degree[nextNode]==0){
                    q.add(nextNode);
                }
            }
        }
        if(ans.size()!=N){
            System.out.println(0);
        }
        else{
            for(int i=0;i<ans.size();i++){
                System.out.println(ans.get(i));
            }
        }
    }
}
/*
3 1
4 1 2 3 1
answer : 0

4 2
3 1 2 3
3 3 4 2
answer : 0

2 2
1 1
1 1
-> 1 2 or 2 1

3 2
1 1
1 1
-> 1 2 3 or 1 3 2
* */