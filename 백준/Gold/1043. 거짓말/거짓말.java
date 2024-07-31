import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int K;
    static boolean[] knows;
    static ArrayList<Integer>[] party;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parent=new int[N+1];
        for(int i=1;i<N+1;i++){
            parent[i]=i;
        }
        st=new StringTokenizer(bf.readLine());
        K=Integer.parseInt(st.nextToken());
        knows=new boolean[N+1];
        for(int i=0;i<K;i++){
            knows[Integer.parseInt(st.nextToken())]=true;
        }
        party=new ArrayList[M];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int k=Integer.parseInt(st.nextToken());
            party[i]=new ArrayList<>();
            for(int j=0;j<k;j++){
                int b=Integer.parseInt(st.nextToken());
                party[i].add(b);
            }
            Collections.sort(party[i]);
            int a=party[i].get(0);
            for(int j=1;j<k;j++){
                int b=party[i].get(j);
                if(getParent(a)!=getParent(b)){
                    union(a,b);
                }
            }

        }
        int answer=0;
        for(int i=0;i<M;i++){
            boolean flag=false;
            for(int j=0;j<party[i].size();j++){
                if(knows[getParent(party[i].get(j))]){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static int getParent(int x){
        if(x==parent[x]){
            return x;
        }
        return getParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=getParent(a);
        int parentB=getParent(b);
        if(knows[parentA]==true){
            parent[parentB]=parentA;
        }
        else if(knows[parentB]==true){
            parent[parentA]=parentB;
        }
        else{
            if(parentA<parentB){
                parent[parentB]=parentA;
            }
            else{
                parent[parentA]=parentB;
            }

        }
    }
}