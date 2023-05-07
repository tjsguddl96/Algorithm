import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static String target;
    static int[] button;
    static int init=100;
    static int ans;
    //0은 맨 앞에 잇을 수 없음 하지만, 0을 누르고 싶을 때만 가능

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        target=Integer.toString(N);
        M=Integer.parseInt(bf.readLine());
        ans=Math.abs(N-init);
        button=new int[10]; //1이면 고장

        if(M>0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0;i<M;i++){
                int broken=Integer.parseInt(st.nextToken());
                button[broken]=1;
            }
        }

        made("",0);
        System.out.println(ans);

    }
    public static void made(String now,int cnt){
        String temp=now;

        if(now.length()>target.length()+1 || now.length()>6){
            return ;
        }
        for(int i=0;i<10;i++){

            if(button[i]==0){
                if(now.length()>=1 && now.charAt(0)=='0' && i==0) continue;
                now+=Integer.toString(i);
                int s=0;
                if(!now.equals("")){
                    s=now.length()+Math.abs(Integer.parseInt(now)-N);

                }
                if(ans>s){
                    ans=s;
                }
                made(now,s);
                now=temp;
            }
        }
    }

}

/*
4000
1
4
-> 5
3999+1

500000
8
0 2 3 4 6 7 8 9
=>511111 + 11111 =>6+11111=11117

1
9
1 2 3 4 5 6 7 8 9
=> 0 +1 =>2

500000
10^6

10
9
1 2 3 4 5 6 7 8 9
* */