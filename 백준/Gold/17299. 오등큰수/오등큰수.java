import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] arr;
    static int[] parent;
    static HashMap<Integer,Integer> cnt=new HashMap<>();
    static Stack<Integer> stack=new Stack<>();
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        N=Integer.parseInt(bf.readLine());
        arr=new int[N];
        parent=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            parent[i]=i;
            if(cnt.containsKey(arr[i])){
                cnt.put(arr[i],cnt.get(arr[i])+1);
            }
            else{
                cnt.put(arr[i],1);
            }
            max=Math.max(max,cnt.get(arr[i]));
            stack.add(arr[i]);
        }
        parent[N-1]=-1;
        int prevIdx=N-1;
        stack.pop();
        int idx=N-2;
        while(!stack.isEmpty()){
            int nowNum=stack.pop();
            int nowCnt=cnt.get(nowNum);
            prevIdx=idx+1;
            if(nowCnt==max){
                parent[idx]=-1;
                idx--;
                continue;
            }
            if(nowCnt<cnt.get(arr[prevIdx])){
                parent[idx]=prevIdx;
            }
            else{
                while(prevIdx>=0 && prevIdx<N && nowCnt>=cnt.get(arr[prevIdx])){
                    prevIdx=parent[prevIdx];
                }
                parent[idx]=prevIdx;
            }

            idx--;
        }
        for(int i=0;i<N;i++){
            if(parent[i]==-1){
                answer.append(parent[i]+" ");
            }
            else {
                answer.append(arr[parent[i]]+" ");
            }
        }
        answer.append("\n");
        bw.flush();
        bw.write(answer.toString());
        bw.close();


    }
}
/*

3
1000000 2 2

16
1 1 5 2 5 3 5 4 5 2 1 6 6 6 6 6

7
1 2 3 6 4 5 6

8
2 1 1 1 2 3 3 3
* */