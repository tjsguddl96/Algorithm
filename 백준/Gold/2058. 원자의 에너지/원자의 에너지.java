import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] input; //상태 배열
    static int[] atomic; //양성자 배열
    static HashMap<Integer,Integer> state=new HashMap<>(); //상태 저장 -> 상태 + 양성자 일때, 만들수 있는 상태인지 확이하기 위해
    static ArrayList<Integer> tree[];
    static int[] ch;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        input=new int[N];
        ch=new int[N];
        dp=new int[N][2];
        atomic=new int[M];
        tree=new ArrayList[N];
        for(int i=0;i<N;i++){
            input[i]=Integer.parseInt(bf.readLine());
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            atomic[i]=Integer.parseInt(bf.readLine());
        }
        Arrays.sort(input);
        for(int i=0;i<N;i++){
            state.put(input[i],i);
            //dp[i][0] : i번째 원소를 포함할 때의 컨테이너 안의 에너지들의 합
            dp[i][0]=input[i];
        }
        for(int i=0;i<N;i++){
            int now=input[i];
            for(int j=0;j<M;j++){
                int atom=atomic[j];
                if(state.get((now+atom))!=null){ //양성자랑 상태랑 더한 것도 상태라면 그래프 연결
                    tree[i].add(state.get((now+atom)));
                }
                if(state.get((now-atom))!=null){//양성자랑 상태랑 뺀 것도 상태라면 그래프 연결
                    tree[i].add(state.get((now-atom)));
                }
            }
        }
        dfs(0);
        System.out.println(Math.max(dp[0][0],dp[0][1]));
    }
    public static void dfs(int nowIdx){
        ch[nowIdx]=1;
        for(int i=0;i<tree[nowIdx].size();i++){
            int next=tree[nowIdx].get(i);
            if(ch[next]==1){
                continue;
            }
            dfs(next);
            //현재 있는 걸 컨테이너에 포함하면 -> 다음거는 무조건 컨테이너에 포함X
            dp[nowIdx][0]+=dp[next][1];
            //현재 있는 걸 컨테이너에 포함X -> 다음거는 컨테이너에 포함하거나 말거나
            dp[nowIdx][1]+=Math.max(dp[next][0],dp[next][1]);
        }
    }
}