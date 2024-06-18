import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] parent;
    static HashSet<Integer>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        int robotIdx=1;
        parent=new int[1000002];
        arr=new HashSet[1000002];
        for(int i=1;i<1000002;i++){
            arr[i]=new HashSet<>();
            parent[i]=i;
        }
        HashMap<Integer,Integer> map=new HashMap<>(); // key= 재료 번호, val = 로봇 번호
        N=Integer.parseInt(bf.readLine());
        for(int i=1;i<=N;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            char op=st.nextToken().charAt(0);
            if(op=='I'){
                int n1=Integer.parseInt(st.nextToken());
                int n2=Integer.parseInt(st.nextToken());
                if(map.containsKey(n1) && !map.containsKey(n2)){
                    int robot=findParent(map.get(n1));
                    map.put(n2,robot);
                    arr[robot].add(n2);
                }
                else if(map.containsKey(n2) && !map.containsKey(n1)){
                    int robot=findParent(map.get(n2));
                    map.put(n1,robot);
                    arr[robot].add(n1);
                }
                else if(!map.containsKey(n1)&&!map.containsKey(n2)){
                    map.put(n1,robotIdx);
                    map.put(n2,robotIdx);
                    arr[robotIdx].add(n1);
                    arr[robotIdx].add(n2);
                    robotIdx++;
                }
                else{
                    int robot1=map.get(n1);
                    int robot2=map.get(n2);
                    if(findParent(robot1)!=findParent(robot2)){
                        union(robot1,robot2);
                    }
                }
            }
            else{
                int n=Integer.parseInt(st.nextToken());
                if(!map.containsKey(n)){
                    map.put(n,robotIdx);
                    arr[robotIdx].add(n);
                    robotIdx++;
                }
                int robot=findParent(map.get(n));
                answer.append(arr[robot].size()+"\n");
            }

        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
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
            for(int key:arr[parentB]){
                arr[parentA].add(key);
            }
            parent[parentB]=parentA;
        }
        else{
            for(int key:arr[parentA]){
                arr[parentB].add(key);
            }
            parent[parentA]=parentB;
        }
    }
}
/*
5
Q 1
I 4 5
I 1 2
I 2 4
Q 1
* */