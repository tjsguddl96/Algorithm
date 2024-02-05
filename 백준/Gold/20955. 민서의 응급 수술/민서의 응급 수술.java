import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        parent=new int[n+1];
        int answer=0;
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            if(findParent(n1)!=findParent(n2)){
                union(n1,n2);
            }
            else{
                answer++;
            }
        }
        for(int i=2;i<n+1;i++){
            if(findParent(1)!=findParent(i)){
                union(1,i);
                answer++;
            }
        }
        System.out.println(answer);
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
        else if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
}

/*
9 6
1 2
1 3
3 4
2 4
5 8
8 9
->4

9 5
2 3
3 4
4 2
5 8
8 9
->5
* */