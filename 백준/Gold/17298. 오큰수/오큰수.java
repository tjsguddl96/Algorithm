import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] num;
    static int[] answer;
    static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans=new StringBuilder();
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        num=new int[N];
        answer=new int[N];
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            int now=num[i];
            if(stack.isEmpty()){
                stack.add(i);
            }
            else{
                if(num[stack.peek()]>now){
                    stack.add(i);
                }
                else{
                    while(!stack.isEmpty() && num[stack.peek()]<now){
                        answer[stack.pop()]=now;
                    }
                    stack.add(i);
                }
            }


        }
        while(!stack.isEmpty()){
            answer[stack.pop()]=-1;
        }
        for(int i=0;i<N;i++){
            ans.append(answer[i]+" ");
        }
        System.out.println(ans.toString());



    }
}