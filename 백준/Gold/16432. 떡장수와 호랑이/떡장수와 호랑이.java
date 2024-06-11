import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static HashSet<Integer>[] ttuk;
    static int[][] visit;
    static StringBuilder answer;
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        answer=new StringBuilder();
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        ttuk=new HashSet[N];
        for(int i=0;i<N;i++){
            ttuk[i]=new HashSet<>();
        }
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int t = Integer.parseInt(st.nextToken());
                ttuk[i].add(t);
            }
        }
        visit=new int[N][10];
        dfs(0,0);

        if(answer.toString().equals("")){
            answer.append(-1);
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void dfs(int cnt,int prev){
        if(!answer.toString().equals("")){
            return ;
        }
        if(cnt==N){
            if(answer.toString().equals("")){
                for(int i=0;i<list.size();i++){
                    answer.append(list.get(i)+"\n");
                }
            }
            return ;
        }
        for(int i=1;i<10;i++){
            if(ttuk[cnt].contains(i) && prev!=i && visit[cnt][i]==0 && answer.toString().equals("")){
                visit[cnt][i]=1;
                list.add(i);
                dfs(cnt+1,i);
                list.remove(list.size()-1);
            }
        }
    }
}