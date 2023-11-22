import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] w;
    static int[] ch;
    static ArrayList<Integer>[] tree;
    static long answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(bf.readLine());
        w=new int[N+1];
        ch=new int[N+1];
        tree=new ArrayList[N+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            w[i]=Integer.parseInt(st.nextToken());
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        answer+=w[1];
        ch[1]=1;
        dfs(1);
        System.out.println(answer);

    }
    static void dfs(int nowNode){
        ch[nowNode]=1;
        for(int i=0;i<tree[nowNode].size();i++){
            int next=tree[nowNode].get(i);
            if(ch[next]==0){
                if(w[nowNode]<w[next]){
                    answer+=(w[next]-w[nowNode]);
                }
                ch[next]=1;
                dfs(next);
            }
        }

    }
}