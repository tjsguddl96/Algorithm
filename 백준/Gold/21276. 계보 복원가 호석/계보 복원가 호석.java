import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<String> names=new ArrayList<>();
    static HashMap<String,Integer> people=new HashMap<>();
    static HashMap<Integer,String> peopleIdx=new HashMap<>();
    static ArrayList<Integer>[] children;
    static int[] outgoing;
    static ArrayList<String> root=new ArrayList<>();
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    static ArrayList<Integer>[] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        children=new ArrayList[N];
        ans=new ArrayList[N];
        outgoing=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            String name=st.nextToken();
            names.add(name);
        }
        Collections.sort(names);
        for(int i=0;i<N;i++){
            String name=names.get(i);
            people.put(name,i);
            peopleIdx.put(i,name);
            children[i]=new ArrayList<>();
            ans[i]=new ArrayList<>();
        }
        M=Integer.parseInt(bf.readLine());
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            String child=st.nextToken();
            String parent=st.nextToken();
            int childIdx=people.get(child);
            int parentIdx=people.get(parent);
            children[parentIdx].add(childIdx);
            outgoing[childIdx]++;
        }
        for(String name:people.keySet()){
            int nowIdx=people.get(name);
            if(outgoing[nowIdx]==0){
                root.add(name);
                q.add(nowIdx);
            }
        }
        Collections.sort(root);
        while(!q.isEmpty()){
            int parentIdx=q.poll();
            for(int i=0;i<children[parentIdx].size();i++){
                int child=children[parentIdx].get(i);
                outgoing[child]--;
                if(outgoing[child]==0){
                    q.add(child);
                    ans[parentIdx].add(child);
                }
            }
        }

        System.out.println(root.size());
        for(int i=0;i<root.size();i++){
            System.out.print(root.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<N;i++){
            System.out.print(peopleIdx.get(i)+" "+ans[i].size()+" ");
            Collections.sort(ans[i]);
            for(int j=0;j<ans[i].size();j++){
                System.out.print(peopleIdx.get(ans[i].get(j))+" ");
            }
            System.out.println();
        }



    }
}