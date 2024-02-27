import java.io.*;
import java.util.*;
public class Main {
    static int N,M,K;
    static int[] indegree;
    static int[] built;
    static ArrayList<Integer>[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String answer="King-God-Emperor";
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        indegree=new int[N+1];
        built=new int[N+1];
        input=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            input[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            input[n1].add(n2);
            indegree[n2]++;
        }
        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int op=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            if(answer.equals("Lier!")){
                continue;
            }
            if(op==1){ //n 건설
                //if(indegree[n]>0){ 이렇게 하면 4 4 4
                //1 2
                //1 3
                //2 4
                //3 4
                //1 1
                //1 3
                //1 3
                //1 4 이 반례가 틀림 (lier
                //if(degree[n]!=0){ 이렇게 하면 3 2 5
                //1 2
                //2 3
                //1 1
                //1 2
                //1 2
                //2 2
                //1 3 이 반례가 틀림 (god
                if(indegree[n]!=0){
                    answer="Lier!";
                    continue;
                }
                built[n]++;
                for(int j=0;j<input[n].size();j++){
                    int next=input[n].get(j);
                    if(built[n]>1){
                        continue;
                    }
                    indegree[next]--;
                }

            }
            else{ //n 부셔
                built[n]--;
                if(built[n]<0){
                    answer="Lier!";
                    continue;
                }
                for(int j=0;j<input[n].size();j++){
                    int next=input[n].get(j);
                    if(built[n]==0) {
                        indegree[next]++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
/*
3 2 6
1 2
2 3
1 1
1 2
1 2
2 2
2 2
1 3
-> lier

3 2 7
1 2
2 3
1 1
1 1
1 1
1 1
1 1
1 3
1 2
->lier

3 2 6
1 2
2 3
1 1
1 1
1 2
1 2
1 2
1 3
-> god


3 2 6
1 2
1 3
1 1
1 1
1 2
1 2
1 2
1 3
-> god


3 2 8
1 2
1 3
1 1
1 1
1 2
1 2
1 2
2 1
2 1
1 3
-> lier

3 2 5
1 2
1 3
1 1
1 1
2 1
2 1
2 1
-> lier



4 4 9
1 2
1 3
2 4
3 4
1 1
1 2
1 3
2 1
1 4
2 2
2 2
2 2
2 2
->lier


7 6 6
1 3
2 3
3 4
4 5
4 6
4 7
1 1
1 2
1 3
2 1
2 1
1 4
-> lier


3 2 4
1 2
2 3
1 1
1 2
2 1
2 2
-> god

4 4 3
1 2
1 3
2 4
3 4
1 1
1 3
1 4
-> lier

3 2 4
1 2
2 3
1 1
1 2
2 1
1 2
-> lier (얘도)

4 4 4
1 2
1 3
2 4
3 4
1 1
1 3
1 3
1 4
-> lier (찾은 반례)

4 4 6
1 2
1 3
2 4
3 4
1 1
1 2
1 3
2 1
2 2
1 4
-> lier (애군)
* */