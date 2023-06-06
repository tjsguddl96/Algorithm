import java.sql.Array;
import java.util.*;
import java.io.*;
public class Main {
    static int[] parent;
    static ArrayList<String> ans=new ArrayList<>();
    static class node implements Comparable<node>{
        int n1;
        int n2;
        public node (int n1,int n2){
            this.n1=n1;
            this.n2=n2;
        }

        @Override
        public int compareTo(node o){
            int x=this.n1-o.n1;
            if(x==0){
                x=this.n2-o.n2;
            }
            return x;
        }

    }
    public static void main(String[] args) throws Exception {
        int t=1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, Integer> nomap = new HashMap<>();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            parent = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }
            ArrayList<node> list=new ArrayList<>();
            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine());
                int n1=Integer.parseInt(st.nextToken());
                int n2=Integer.parseInt(st.nextToken());
                if(n1>n2){
                    list.add(new node(n2,n1));
                }else{
                    list.add(new node(n1,n2));
                }
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                if(!union(list.get(i).n1,list.get(i).n2)){
                    nomap.put(getParent(list.get(i).n1),1);
                }

            }
            for(int i=1;i<n+1;i++){
                map.put(getParent(i),1);
            }
//            for(Integer key:map.keySet()){
//                System.out.println(key);
//            }
            for(Integer key:nomap.keySet()){
                map.remove(key);
            }
            if(map.size()==0){
                ans.add("Case "+t+": No trees.");
            }else if(map.size()==1){
                ans.add("Case "+t+": There is one tree.");
            }else{
                ans.add("Case "+t+": A forest of "+map.size()+" trees.");
            }
            t++;
        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
    public static int getParent(int x){
        if(parent[x]!=x){
            return getParent(parent[x]);
        }
        return x;
    }
    public static boolean union(int a,int b){
        int parentA=getParent(a);
        int parentB=getParent(b);
        if(parentA!=parentB){
            if(parentA>parentB){
                parent[parentA]=parentB;

            }else{
                parent[parentB]=parentA;
            }
            return true;
        }else{
            return false;
        }
    }


}

/*
3 3
1 2
3 1
3 2
0 0
-> no

7 7
1 2
2 3
3 1
4 5
5 6
6 4
1 6
-> one

4 4
2 3
3 4
4 2
1 2
0 0
-> no

6 7
1 2
1 3
1 4
2 3
2 4
3 4
5 6
0 0
-> one

6 4
5 6
3 4
6 3
5 4
-> 2

6 5
5 6
3 4
6 3
6 1
5 4
-> 1

6 5
5 6
3 4
6 3
1 3
6 2
->1

9 9
1 2
2 3
3 4
4 5
3 5
6 7
7 8
6 8
8 9
정답 : Case 1: No trees.

6 6
5 6
3 4
6 3
1 3
6 2
1 6
* */