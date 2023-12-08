import java.io.*;
import java.util.*;

//A:65,Z:90 -> 26개 --> 대문자면 64를 빼서 배열에 저장 => 1부터 A가 들어가겟지, Z는 idx는 26
//a:97,z:122 -> 26개 --> 소문자면 70을 빼서 배열에 저장 => 27부터 a가 들어가고,z의 idx는 52
//총 52개
public class Main {
    static int N;
    static ArrayList<Integer> arr[];
    static int[] ch;
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    static class Answer implements Comparable<Answer>{
        int n1;
        int n2;
        public Answer(int n1,int n2){
            this.n1=n1;
            this.n2=n2;
        }

        @Override
        public int compareTo(Answer o){
            int x=this.n1-o.n1;
            if(x==0){
                x=this.n2-o.n2;
            }
            return x;
        }
    }
    static PriorityQueue<Answer> answer=new PriorityQueue<>();
    static PriorityQueue<Answer> answer2=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new ArrayList[53];

        for(int i=0;i<53;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            String st=bf.readLine();
            int n1=getIdx(st.charAt(0));
            int n2=getIdx(st.charAt(5));
            arr[n1].add(n2);
        }

        for(int i=1;i<53;i++){
            ch=new int[53];
            q.add(i);
            int parent=i;
            while(!q.isEmpty()){
                int now=q.poll();
                ch[now]=1;
                for(int j=0;j<arr[now].size();j++){
                    int next=arr[now].get(j);
                    if(ch[next]==0){
                        ch[next]=1;
                        q.add(next);
                        answer.add(new Answer(parent,next));
                    }
                }
            }
        }
        int answerN=0;
        while(!answer.isEmpty()){
            Answer now=answer.poll();
            answerN+=1;
            int n1=now.n1;
            int n2=now.n2;
            if(!answer.isEmpty()) {
                Answer peek=answer.peek();
                while(n1==peek.n1 && n2==peek.n2){
                    answer.poll();
                    peek=answer.peek();
                }
            }
            char c1=' ';
            char c2=' ';
            if(n1<=26){
                c1=(char)(n1+64);
            }else {
                c1=(char)(n1+70);
            }
            if(n2<=26){
                c2=(char)(n2+64);
            }else {
                c2=(char)(n2+70);
            }
            answer2.add(new Answer(n1,n2));
        }
        System.out.println(answerN);
        while(!answer2.isEmpty()){
            Answer now=answer2.poll();
            int n1=now.n1;
            int n2=now.n2;
            char c1=' ';
            char c2=' ';
            if(n1<=26){
                c1=(char)(n1+64);
            }else {
                c1=(char)(n1+70);
            }
            if(n2<=26){
                c2=(char)(n2+64);
            }else {
                c2=(char)(n2+70);
            }
            System.out.println(c1+" => "+c2);
        }



    }

    public static int getIdx(char c){
        int n=(int) c;
        if(n<=90){ //대문자
            return n-64;
        }
        return n-70;
    }
}