import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int k;
    static int n; //k=특정값,n=각 반의 학생 수
    static int[][] cl;
    static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++) {
            System.out.println(binary());
        }
    }
    public static int binary() throws IOException {
        StringTokenizer st=new StringTokenizer(bf.readLine());
        k=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        cl=new int[4][n];
        ArrayList<Integer> sum1=new ArrayList<>();
        ArrayList<Integer> sum2=new ArrayList<>();
        for(int i=0;i<4;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                cl[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum1.add(cl[0][i]+cl[1][j]);
                sum2.add(cl[2][i]+cl[3][j]);
            }
        }
        sum2.sort(null);
        int ans=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n*n;i++){
            int right=n*n-1;
            int left=0;
            int mid,temp,diff;
            while(left<=right){
                mid=(left+right)/2;
                temp=sum1.get(i)+sum2.get(mid);
                diff=Math.abs(k-temp);
                if(temp==k){
                    ans=temp;
                    return ans;
                }
                if(diff<min){
                    min = diff;
                    ans = temp;
                }else if(diff==min){
                    ans=Math.min(ans,temp);
                }
                if(temp<k){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return ans;
    }
}
/*
1
32 2
5 2
9 4
10 20
4 2


3
300 4
60 52 80 40
75 68 88 63
48 93 48 54
56 73 49 75
8 3
1 2 3
1 2 3
1 2 3
1 2 3
32 2
5 2
9 4
10 20
4 2

1
100 2
10000000 10000000
10000000 10000000
10000000 10000000
10000000 10000001


1
165 9
50 50 50 50 50 50 50 50 50
50 50 50 50 50 50 50 50 50
2 5 4 5 10 10 20 40 60
50 55 60 60 70 70 70 60 60
* */