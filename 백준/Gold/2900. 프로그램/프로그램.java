import java.util.*;
import java.io.*;

public class Main {
    static int N,K,Q;
    static long[] sum;
    static long[] a;
    static HashMap<Integer,Long> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        a=new long[N];
        sum=new long[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<K;i++){
            int n=Integer.parseInt(st.nextToken());
            if(map.containsKey(n)){
                long cnt=map.get(n)+1L;
                map.put(n,cnt);
            }
            else{
                map.put(n,1L);
            }
        }
        for(int key:map.keySet()){
            something(key,map.get(key));
        }
        for(int i=0;i<N;i++){
            if(i==0){
                sum[i]=a[i];
                continue;
            }
            sum[i]=sum[i-1]+a[i];
        }
        Q=Integer.parseInt(bf.readLine());
        for(int i=0;i<Q;i++){
            st=new StringTokenizer(bf.readLine());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            if(l==0){
                answer.append(sum[r]+"\n");
            }
            else {
                answer.append((sum[r] - sum[l - 1]) + "\n");
            }
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }
    public static void something(int jump,long cnt){
        int i=0;
        while(i<N){
            a[i]=a[i]+cnt;
            i=i+jump;
        }
    }
}
/*
10 4
1 1 2 1
3
0 9
1 9
0 0
* */