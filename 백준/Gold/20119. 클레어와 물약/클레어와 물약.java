import java.util.*;
import java.io.*;

public class Main {
    static int N,M,L;
    static int[] made;
    static int[] incoming;
    static ArrayList<Integer>[] canMake;
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    static HashSet<Integer> ans=new HashSet<>();
    static ArrayList<Integer> answer=new ArrayList<>();
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        made=new int[M];
        incoming=new int[M];
        canMake=new ArrayList[N+1];
        ch=new int[N+1];
        for(int i=0;i<N+1;i++){
            canMake[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int k=Integer.parseInt(st.nextToken());
            int[] n=new int[k];
            for(int j=0;j<k;j++){
                n[j]=Integer.parseInt(st.nextToken());
            }
            int r=Integer.parseInt(st.nextToken());
            made[i]=r;
            incoming[i]=k;
            for(int j=0;j<k;j++){
                canMake[n[j]].add(i);
            }
        }
        L=Integer.parseInt(bf.readLine());
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<L;i++){
            q.add(Integer.parseInt(st.nextToken()));
        }
        while(!q.isEmpty()){
            int now=q.poll();
            if(ch[now]==1){
                continue;
            }
            ch[now]=1;
            answer.add(now);
            for(int i=0;i<canMake[now].size();i++){
                int canMakeNode=canMake[now].get(i);
                incoming[canMakeNode]--;
                if(incoming[canMakeNode]==0){
                    q.add(made[canMakeNode]);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i)+" ");
        }
    }
}