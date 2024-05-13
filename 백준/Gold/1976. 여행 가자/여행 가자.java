import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static ArrayList<Integer> plan=new ArrayList<>();
    static int[] parent;
    static class Road{
        int n1;
        int n2;
        public Road(int n1,int n2){
            this.n1=n1;
            this.n2=n2;
        }
    }
    static ArrayDeque<Road> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        M=Integer.parseInt(bf.readLine());
        parent=new int[N+1];
        for(int i=1;i<N+1;i++){
            parent[i]=i;
        }
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<N+1;j++){
                if(Integer.parseInt(st.nextToken())==1) {
                    q.add(new Road(i,j));
                }
            }
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){
            plan.add(Integer.parseInt(st.nextToken()));
        }
        while(!q.isEmpty()){
            Road now=q.poll();
            int n1=now.n1;
            int n2=now.n2;
            if(findParent(n1)!=findParent(n2)){
                union(n1,n2);
            }
        }
        String answer="YES";
        for(int i=0;i<plan.size()-1;i++){
            int now=plan.get(i);
            int next=plan.get(i+1);
            if(findParent(now)!=findParent(next)){
                answer="NO";
                break;
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
5
5
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
5 3 2 3 4

5
5
0 1 0 1 1
1 0 1 0 0
0 1 0 0 0
1 0 0 0 0
1 0 0 0 0
5 3 2 3 4
* */