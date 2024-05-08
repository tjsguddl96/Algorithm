import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static int[] ch;
    static int answer;
    static int[] light;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new ArrayList[N+1];
        ch=new int[N+1];
        light=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        DFS(1);
//        System.out.println("최종 : "+Arrays.toString(light));
        for(int i=1;i<N+1;i++){
            if(light[i]==1){
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void DFS(int nowNode){
//        System.out.println(nowNode);
//        System.out.println(Arrays.toString(light));
        ch[nowNode]=1;
        for(int i=0;i<arr[nowNode].size();i++){
            int next=arr[nowNode].get(i);
            if(ch[next]==0){
                ch[next]=1;
                DFS(next);
            }else{
                continue;
            }
            if(light[next]==0 && ch[next]==1){
                light[nowNode]=1;
//                System.out.println("불 키는 node : "+nowNode+", next : "+next);
            }
        }
    }

}
/*
13
1 2
1 6
1 7
2 3
2 4
7 8
7 9
7 10
4 5
5 13
5 11
12 11



5
1 2
2 3
2 4
2 5
* */