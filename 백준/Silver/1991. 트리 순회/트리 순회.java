import java.util.*;
import java.io.*;
//root=1, 부모 *2 => 왼, 부모 *2+1=> 오
//Z=90
public class Main {
    static int N;

    static class Node{
        char now;
        char left;
        char right;
        public Node(char now,char left,char right){
            this.now=now;
            this.left=left;
            this.right=right;
        }
    }

    static Node[] nodes=new Node[100];
    static StringBuilder answer1=new StringBuilder();
    static StringBuilder answer2=new StringBuilder();
    static StringBuilder answer3=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            char now=st.nextToken().charAt(0);
            char left=st.nextToken().charAt(0);
            char right=st.nextToken().charAt(0);
            nodes[(int)now]=new Node(now,left,right);
        }

        pre('A');
        middle('A');
        post('A');
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }


    public static void pre(char now){
        if(now=='.'){
            return ;
        }
        answer1.append(now);
        pre(nodes[(int)now].left);
        pre(nodes[(int)now].right);

    }

    public static void middle(char now){
        if(now=='.'){
            return ;
        }
        middle(nodes[(int)now].left);
        answer2.append(now);

        middle(nodes[(int)now].right);
    }

    public static void post(char now){
        if(now=='.'){
            return ;
        }
        post(nodes[(int)now].left);

        post(nodes[(int)now].right);

        answer3.append(now);
    }

    public static boolean isAlpha(char c){
        if(c!='.'){
            return true;
        }
        return false;
    }
}
