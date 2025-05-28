import java.io.*;
import java.util.*;
public class Main {
    static int T;
    static String function;

    public static void main(String[] args) throws IOException{
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            function=bf.readLine();
            int n=Integer.parseInt(bf.readLine());
            String tmp=bf.readLine();
            String[] arr=tmp.substring(1,tmp.length()-1).split(",");
            ArrayDeque<Integer> q = new ArrayDeque<>();
            if(n!=0) {
                for (int i = 0; i < arr.length; i++) {
                    q.add(Integer.parseInt(arr[i]));
                }
            }
            answer.append(operation(function,q)+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }

    public static StringBuilder operation(String function,ArrayDeque<Integer> q){
        boolean flag=true; //true이면 앞에서 (popleft), false이면 뒤에서 pop
        int now=0;
        while(now<function.length()){
            char op=function.charAt(now);
            if(!q.isEmpty() && op=='D'){
                if(flag){
                    q.poll();
                }
                else{
                    q.pollLast();
                }
            }
            else if(q.isEmpty() && op=='D'){
                return new StringBuilder("error");
            }
            else if(op=='R'){
                flag=!flag;
            }
            now++;
        }
        StringBuilder ans=new StringBuilder();
        ans.append("[");
        if(flag) {
            while (!q.isEmpty()) {
                ans.append(q.poll());
                if(!q.isEmpty()){
                    ans.append(",");
                }
            }
        }
        else{
            while(!q.isEmpty()){
                ans.append(q.pollLast());
                if(!q.isEmpty()){
                    ans.append(",");
                }
            }
        }
        ans.append("]");
        return ans;

    }

}

/*

1
DDDDD
4
[1,2,3,4]
*/
