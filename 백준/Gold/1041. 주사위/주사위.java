import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static class Couple{
        int a;
        int b;
        public Couple(int a,int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public String toString(){
            return a+" "+b;
        }
    }
    static Couple[] couples={new Couple(0,5),new Couple(1,4),new Couple(2,3)};
    static Couple[] order={new Couple(1,2),new Couple(0,2),new Couple(0,1)};
    static int[] arr=new int[6];
    static long min=Long.MAX_VALUE;
    static long answer;
    static long sum,max;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<6;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i];
            min=Math.min(arr[i],min);
            max=Math.max(arr[i],max);
        }
        if(N==1){
            System.out.println(sum-max);
        }
        else {
            //1번
            long tmp1 = (long) ((long) ((long) (N - 2) * (long) (N - 2)) * 5) * min;
            //5번
            long tmp5 = (long) (4 * (N - 2)) * min;


            //2번
            long tmp2 = solve2() * 4;
            //3번
            long tmp = solve3();

            long tmp3 = 8 * (N - 2) * tmp;
            //4번
            long tmp4 = 4 * tmp;
//        System.out.println(tmp1+" "+tmp2+" "+tmp3+" "+tmp4+" "+tmp5);
            answer = tmp1 + tmp2 + tmp3 + tmp4 + tmp5;
            System.out.println(answer);
        }
    }
    public static long solve3(){
        long min1=Long.MAX_VALUE;
        for(int i=0;i<3;i++){
            Couple nowUD=couples[i];
            //a랑 짝인거 ->a 이면 안되고 , b여도 안됨
            for(int j=0;j<6;j++){
                if(j!= nowUD.a && j!=nowUD.b) {
                    min1 = Math.min(min1, arr[nowUD.a] +arr[j]);
                    min1 = Math.min(min1, arr[nowUD.b] +arr[j]);
                }
            }
        }
        return min1;
    }
    public static long solve2(){
        long minnn=Long.MAX_VALUE;
        for(int i=0;i<3;i++){
            Couple nowUD=couples[i]; //기준이 되는 위 아래
            ArrayList<Integer> side=new ArrayList<>();
            side.add(arr[couples[order[i].a].a]);
            side.add(arr[couples[order[i].b].a]);
            side.add(arr[couples[order[i].a].b]);
            side.add(arr[couples[order[i].b].b]);
            long minn=Long.MAX_VALUE;
            for(int j=0;j<side.size();j++){
                minn=Math.min(minn,side.get(j)+side.get((j+1)%4));
            }
            minnn=Math.min(minnn,minn+arr[nowUD.a]);
            minnn=Math.min(minnn,minn+arr[nowUD.b]);
        }
        return minnn;
    }
}

