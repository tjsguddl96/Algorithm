import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static Stack<String> stack=new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> pq=new PriorityQueue<>(Collections.reverseOrder());
        N=Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            int n=Integer.parseInt(st.nextToken());
            String str="";
            String dash="";
            for(int j=0;j<n;j++){
                String input=st.nextToken();
                input=dash+input;
                str+=(input+" ");
                dash+="--";
            }
            pq.add(str);
        }
        while(!pq.isEmpty()){
            String str=pq.poll();
            StringTokenizer st=new StringTokenizer(str);
            ArrayDeque<String> q=new ArrayDeque<>();
            Stack<String> tmp=new Stack<>();
            while(st.hasMoreTokens()){
                q.add(st.nextToken());
            }
            if(stack.isEmpty()){
                while(!q.isEmpty()){
                    stack.add(q.pollLast());
                }
            }
            else{
                while(!stack.isEmpty() && stack.peek().equals(q.peek())){
                    tmp.add(stack.pop());
                    q.poll();
                }
                while(!q.isEmpty()){
                    stack.add(q.pollLast());
                }
                while(!tmp.isEmpty()){
                    stack.add(tmp.pop());
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
/*
5
3 B A C
3 A D C
4 A B C C
3 B D F
4 B D E F
* */