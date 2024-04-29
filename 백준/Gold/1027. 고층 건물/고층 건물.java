import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static class Building{
        int x;
        int y;
        public Building(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static class Function{
        double a;
        double b;
        public Function(double a,double b){
            this.a=a;
            this.b=b;
        }
    }
    static int max;
    static Building[] building;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        building=new Building[N];
        for(int i=1;i<N+1;i++){
            building[i-1]=new Building(i,Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<N;i++){
            Building now=building[i];
            int cnt=0;
            for(int j=i-1;j>=0;j--){
                Building next=building[j];
                Function f=func(now,next);
                boolean flag=true;
                for(int k=j+1;k<i;k++){
                    if(is(f,building[k])==false){
                        flag=false;
                        break;
                    }
                }
                if(flag==true){
                    cnt++;
                }
            }
            for(int j=i+1;j<N;j++){
                Building next=building[j];
                Function f=func(now,next);
                boolean flag=true;
                for(int k=i+1;k<j;k++){
                    if(is(f,building[k])==false){
                        flag=false;
                        break;
                    }
                }
                if(flag==true){
                    cnt++;
                }
            }
//            System.out.println(building[i].y+" "+cnt);
            max=Math.max(max,cnt);
        }
        System.out.println(max);
    }
    public static Function func(Building A,Building B){
        double a;
        if(A.x==B.x){
            a=0;
        }else {
            a = (double)(A.y - B.y) / (double)(A.x - B.x);
        }
        double b=A.y-(a*A.x);
        return new Function(a,b);
    }
    public static boolean is(Function f,Building a){
        if(f.a*a.x+f.b>a.y){
            return true;
        }
        return false;
    }
}