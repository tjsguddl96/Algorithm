import java.io.*;
import java.util.*;

public class Main {
    static int T,N,M;
    static int[] input;
    static int[] incoming;
    static HashSet<Integer>[] set;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            N=Integer.parseInt(bf.readLine());
            input=new int[N+1];
            set=new HashSet[N+1];
            incoming=new int[N+1];
            st=new StringTokenizer(bf.readLine());
            for(int i=1;i<N+1;i++){
                int team=Integer.parseInt(st.nextToken());
                input[i]=team;
                set[i]=new HashSet<>();
            }
            for(int i=1;i<N+1;i++){
                for(int j=i+1;j<N+1;j++){
                    set[input[i]].add(input[j]);
                }
            }
            M=Integer.parseInt(bf.readLine());
            for(int i=1;i<N+1;i++){
                incoming[i]=N-set[i].size()-1;
            }
            String ans="";
            for(int i=0;i<M;i++){
                st=new StringTokenizer(bf.readLine());
                int team1=Integer.parseInt(st.nextToken());
                int team2=Integer.parseInt(st.nextToken());
                if(set[team1].contains(team2)){
                    set[team1].remove(team2);
                    set[team2].add(team1);
                }
                else{
                    set[team2].remove(team1);
                    set[team1].add(team2);
                }
            }
            ArrayDeque<Integer> q=new ArrayDeque<>();
            for(int i=1;i<N+1;i++){
                incoming[i]=N-set[i].size()-1;
                if(incoming[i]==0){
                    q.add(i);
                }
            }
            if(ans.equals("IMPOSSIBLE")){
                answer.append(ans+"\n");
                continue;
            }
            while(!q.isEmpty()){
                int now=q.poll();
                ans+=(now+" ");
                for(int next:set[now]){
                    if(incoming[next]==0){
                        ans="IMPOSSIBLE";
                        break;
                    }
                    incoming[next]--;
                    if(incoming[next]==0){
                        q.add(next);
                    }
                }
                if(ans.equals("IMPOSSIBLE")){
                    break;
                }
            }
            for(int i=1;i<N+1;i++){
                if(incoming[i]!=0){
                    ans="";
                }
            }
            if(ans.equals("")){
                ans+="IMPOSSIBLE";
            }
            ans+="\n";
            answer.append(ans);
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}
/*
1
3
1 3 2
1
1 3
->3 1 2

1
5
1 4 3 5 2
2
1 2
1 3
1 4
->impossible


3
4
1 2 3 4
3
1 2
3 4
2 3
5
5 4 3 2 1
2
2 4
3 4
3
2 3 1
0

* */