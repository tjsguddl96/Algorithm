import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static int[] people;
    static int[] incoming;
    static int[][] w;
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        people=new int[N+1];
        incoming=new int[N+1];
        arr=new ArrayList[N+1];
        w=new int[N+1][2];
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            people[i]=Integer.parseInt(st.nextToken());
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
            incoming[n1]++;
            incoming[n2]++;
        }
        for(int i=1;i<N+1;i++){
            if(incoming[i]==1){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int now=q.poll();
            incoming[now]=0;
            w[now][0]=people[now];
            int pickMe=people[now];
            int pickNotMe=0;
            for(int i=0;i<arr[now].size();i++){
                int next=arr[now].get(i);
                if(incoming[next]==0){ //w[now][0] -> now를 선택한 경우 => next는 절대 선택하면 안되는 경우
                                        //w[now][1] -> now를 선택하지 않는 경우 => next는 선택하든 말든 상관 없음
                    pickMe+=w[next][1];
                    pickNotMe+=Math.max(w[next][0],w[next][1]);
                }
                else {
                    incoming[next]--;
                    if(incoming[next]==1){
                        q.add(next);
                    }
                }

            }
            w[now][0]=pickMe;
            w[now][1]=pickNotMe;
            answer=Math.max(answer,w[now][0]);
            answer=Math.max(answer,w[now][1]);
        }

        System.out.println(answer);

    }
}

/*
8
1 3 4 1 2 20 10 12
1 2
2 3
4 3
4 5
6 2
6 7
6 8
->29

9
1 3 4 1 2 20 10 12 10
1 2
2 3
4 3
4 5
6 2
6 7
6 8
8 9
->37
* */