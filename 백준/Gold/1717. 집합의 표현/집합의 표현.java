import java.util.*;
import java.io.*;

/*

* */
public class Main {
    static int N,M;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parent=new int[N+1];
        for(int i=0;i<N+1;i++){
            parent[i]=i;
        }
        StringBuilder answer=new StringBuilder();

        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int op=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(op==0){ //a,b를 합집합
                union(a,b);
            }
            else{ //a,b가 같은 집합인지 유무
                int parentA=findParent(a);
                int parentB=findParent(b);
                if(parentA==parentB){
                    answer.append("YES\n");
                }
                else{
                    answer.append("NO\n");
                }
            }
        }
        System.out.println(answer.toString());



    }

    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=findParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return ;
        }
        if(parentA<=parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }

}

/*

* */