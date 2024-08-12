import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] num;
    static char[] op={'+','-','*','/'};
    static int[] cnt=new int[4];
    static int max=-1000000000;
    static int min=1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        num=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<4;i++){
            cnt[i]=Integer.parseInt(st.nextToken());
        }
        solve(num[0],0);
        System.out.println(max+"\n"+min);
    }
    public static void solve(int cal,int idx){
        if(idx==N-1){
            max=Math.max(cal,max);
            min=Math.min(cal,min);
            return ;
        }
        for(int i=0;i<4;i++){
            int res=cal;
            if(i==0 && cnt[i]>0){
                res=cal+num[idx+1];
                cnt[i]-=1;
                solve(res,idx+1);
                cnt[i]+=1;
            }
            else if(i==1 && cnt[i]>0){
                res=cal-num[idx+1];
                cnt[i]-=1;
                solve(res,idx+1);
                cnt[i]+=1;
            }
            else if(i==2 && cnt[i]>0){
                res=cal*num[idx+1];
                cnt[i]-=1;
                solve(res,idx+1);
                cnt[i]+=1;
            }
            else if(i==3 && cnt[i]>0){
                res=cal/num[idx+1];
                cnt[i]-=1;
                solve(res,idx+1);
                cnt[i]+=1;
            }

        }
    }
}