import java.util.*;
import java.io.*;

public class Main {
    static int T,N;
    static int[] ch;
    static int[] parent;
    static int root;
    static int A,B;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            N=Integer.parseInt(bf.readLine());
            ch=new int[N+1];
            parent=new int[N+1];
            for(int i=0;i<N-1;i++){
                StringTokenizer st=new StringTokenizer(bf.readLine());
                int n1=Integer.parseInt(st.nextToken());
                int n2=Integer.parseInt(st.nextToken());
                parent[n2]=n1;
            }
            for(int i=1;i<N+1;i++){
                if(parent[i]==0){
                    root=i;
                    break;
                }
            }
            StringTokenizer st=new StringTokenizer(bf.readLine());
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            ch[A]=1;
            goParent(A);
            if(ch[B]==1){
                ans=B;
            }
            else {
                ch[B] = 1;
                goParent(B);
            }
            answer.append(ans+"\n");

        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }
    public static void goParent(int nowNode){
        if(nowNode==root) {
            return;
        }
        if(ch[parent[nowNode]]==1){
            ans=parent[nowNode];
            return ;
        }
        ch[parent[nowNode]]=1;
        goParent(parent[nowNode]);
    }

//    public static void dfs(int nowNode,int depth){
//        for(int i=0;i<arr[nowNode].size();i++){
//            int nextNode=arr[nowNode].get(i);
//            if(ch[nextNode]==0){
//                ch[nextNode]=1;
//                parent[nextNode]=depth+1;
//                dfs(nextNode,depth+1);
//            }
//        }
//    }
}
/*
2
16
1 14
8 5
10 16
5 9
4 6
8 4
4 10
1 13
6 15
10 11
6 7
10 2
16 3
8 1
16 12
16 7
5
2 3
3 4
3 1
1 5
5 3
* */