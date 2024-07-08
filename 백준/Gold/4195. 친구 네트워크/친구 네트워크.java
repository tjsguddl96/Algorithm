import java.util.*;
import java.io.*;
public class Main {
    static int T,F;
    static ArrayList<Integer>[] arr;
    static int[] parent;
    static int[] child;
    static HashMap<String,Integer> map;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            F=Integer.parseInt(bf.readLine());
            int tmpN=2*F+1;
            arr=new ArrayList[tmpN];
            parent=new int[tmpN];
            child=new int[tmpN];
            for(int i=0;i<tmpN;i++){
                arr[i]=new ArrayList<>();
                parent[i]=i;
                child[i]=1;
            }
            map=new HashMap<>();
            cnt=1;
            for(int i=0;i<F;i++){
                st=new StringTokenizer(bf.readLine());
                String name1=st.nextToken();
                String name2=st.nextToken();
                int n1=getIdx(name1);
                int n2=getIdx(name2);
                arr[n1].add(n2);
                arr[n2].add(n1);
                int parent1=getParent(n1);
                int parent2=getParent(n2);
                int minParent=Math.min(parent1,parent2);
                if(parent1!=parent2){
                    union(n1,n2);
                }
                answer.append(child[minParent]+"\n");

            }




        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }
    public static void union(int a,int b){
        int parentA=getParent(a);
        int parentB=getParent(b);
        if(parentA==parentB){
            return ;
        }
        else if(parentA<parentB){
            parent[parentB]=parentA;
            child[parentA]+=child[parentB];
        }
        else{
            parent[parentA]=parentB;
            child[parentB]+=child[parentA];
        }
    }
    public static int getParent(int x){
        if(x==parent[x]){
            return x;
        }
        return getParent(parent[x]);
    }
    public static int getIdx(String name){
        int idx=0;
        if(!map.containsKey(name)){
            map.put(name,cnt);
            idx=cnt;
            cnt++;
        }
        else{
            idx=map.get(name);
        }
        return idx;
    }
}
/*
1
5
Fred Barney
Betty Wilma
A B
Barney Betty
B Betty
* */