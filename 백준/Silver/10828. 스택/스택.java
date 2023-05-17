import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            String op=st.nextToken();
            int num=-1;
            if(st.hasMoreTokens()){
                num=Integer.parseInt(st.nextToken());
            }
            if(op.equals("push")){
                stack.add(num);
            }else if(op.equals("pop")){
                if(!stack.isEmpty()){
                    System.out.println(stack.pop());
                }else{
                    System.out.println(-1);
                }
            }else if(op.equals("size")){
                System.out.println(stack.size());
            }else if(op.equals("empty")){
                if(!stack.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }else{
                if(!stack.isEmpty()){
                    System.out.println(stack.peek());
                }else{
                    System.out.println(-1);
                }
            }
        }


    }
}