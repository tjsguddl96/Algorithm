import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] incoming;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        incoming=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a].add(b);
            incoming[b]++;
        }
        ArrayDeque<Integer>q=new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            if(incoming[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int now=q.poll();
            answer.append(now+" ");
            for(int i=0;i<arr[now].size();i++){
                incoming[arr[now].get(i)]--;
                if(incoming[arr[now].get(i)]==0){
                    q.add(arr[now].get(i));
                }
            }
        }
        System.out.println(answer.toString());
    }
}