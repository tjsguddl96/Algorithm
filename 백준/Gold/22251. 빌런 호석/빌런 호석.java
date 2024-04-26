import java.io.*;
import java.util.*;

public class Main {
    static int N,K,P,X;
    static String[] digit={"1110111","0010010","1011101","1011011","0111010","1101011","1101111","1010010","1111111","1111011"};
//    static HashMap<Integer,HashSet<Integer>>[] map=new HashMap[10];
    static ArrayList<Integer> input=new ArrayList<>();
    static int[][] diff=new int[10][10];
    static HashSet<Integer> answer=new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        P=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken()); //현재 층
        String tmp=X+"";
        String x="";
        for(int i=0;i<K-tmp.length();i++){
            x+='0';
        }
        x+=tmp;
        for(int i=0;i<x.length();i++){
            input.add(x.charAt(i)-'0');
        }
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                diff[i][j]=compare(i,j); //i와 j의 led 차이 수
            }
        }

        dfs(0,"",0);
        answer.remove(X);
//        for(int val:answer){
//            System.out.println(val);
//        }
        System.out.println(answer.size());

//        for(int i=0;i<10;i++){
//            map[i]=new HashMap<>();
//            for(int j=0;j<10;j++){
//                if(i==j){
//                    continue;
//                }
//                int cnt=compare(i,j);
//                if(map[i].containsKey(cnt)){
//                    HashSet<Integer> set=map[i].get(cnt);
//                    set.add(j);
//                    map[i].put(cnt,set);
//                }
//                else{
//                    HashSet<Integer> set=new HashSet<>();
//                    set.add(j);
//                    map[i].put(cnt,set);
//
//                }
//            }
//        }
//        for(int i=0;i<10;i++){
//            System.out.println(i);
//            for(int key:map[i].keySet()){
//                System.out.print(key+" : ");
//                for(int val:map[i].get(key)){
//                    System.out.print(val+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("------------");
//            System.out.println();
//        }




    }
    public static void dfs(int inputIdx,String num,int tmpP){
        if(inputIdx==input.size()){
            int floor=Integer.parseInt(num);
            if(floor<=N && floor>=1) {
                answer.add(Integer.parseInt(num));
            }
            return ;
        }
        for(int i=0;i<10;i++){
            if(diff[input.get(inputIdx)][i]+tmpP<=P){
                dfs(inputIdx+1,num+i,diff[input.get(inputIdx)][i]+tmpP);
            }
        }
    }
    public static int compare(int n1,int n2){
        String N1=digit[n1];
        String N2=digit[n2];
        int num=0;
        for(int i=0;i<N1.length();i++){
            if(N1.charAt(i)!=N2.charAt(i)){
                num++;
            }
        }
        return num;
    }
}
/*
200 3 2 5

* */