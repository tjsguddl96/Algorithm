import java.io.*;
import java.util.*;
public class Main {
    static int K,N,F;
    static int[] ch;
    static ArrayList<Integer>[] arr;
    static ArrayList<Integer> answer=new ArrayList<>();
    static boolean ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        K=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        F=Integer.parseInt(st.nextToken());
        ch=new int[N+1];
        arr=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<F;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        for(int i=1;i<N+1;i++){
            Collections.sort(arr[i]);
        }
        for(int i=1;i<N+1;i++){
            if(arr[i].size()>=K-1) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(i);
                ch=new int[N+1];
                ch[i] = 1;
                solve(0, i, res);
            }
            if(ans){
                break;
            }
        }
        if(answer.size()==0){
            System.out.println(-1);
        }
        else {
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
    }
    public static void solve(int cnt,int now,ArrayList<Integer> res){
        if(ans){
            return ;
        }
        if(res.size()==K){
            for(int i=0;i<K;i++){
                answer.add(res.get(i));
            }
            ans=true;
            return ;
        }
        for(int i=0;i<arr[now].size();i++){
            int next=arr[now].get(i);
            boolean flag=true;
            for(int j=0;j<res.size();j++){
                if(!arr[res.get(j)].contains(Integer.valueOf(next))){
                    flag=false;
                }
            }
            if (ch[next] == 0 && flag) {
                ch[next] = 1;
                res.add(next);
                solve(cnt + 1, next, res);
                res.remove(res.size() - 1);
                ch[next] = 0;
            }
        }
    }

}
/*
2 6 5
1 6
2 3
2 6
4 5
5 6

4 6 7
1 2
1 6
2 3
2 6
4 5
5 6
2 5
->-1
* */