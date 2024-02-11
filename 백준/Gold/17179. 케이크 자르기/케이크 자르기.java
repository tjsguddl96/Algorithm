import java.io.*;
import java.util.*;

public class Main {
    static int n,m,l;
    static int[] cut;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        cut=new int[m+1];

        for(int i=0;i<m;i++){
            cut[i]=Integer.parseInt(bf.readLine());
        }
        cut[m]=l;
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<n;i++){
            int q=Integer.parseInt(bf.readLine()); //자르는 횟수 -> 잘린 케잌의 수는 q+1 이 되어야함
            int left=0;
            int right=l;
            int mid=0; //mid 값이 케잌의 최소 길이
            while(left<=right){
                mid=(left+right)/2;
                int prev=0;
                int cakes=0;
                for(int j=0;j<=m;j++){
                    if(cut[j]-prev>=mid){ //잘린 케잌 +1
                        cakes++;
                        prev=cut[j];
                    }
                }
                if(cakes<q+1){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            answer.append(right+"\n");
        }
        System.out.print(answer);
    }
}
/*
4 4 70
5
10
50
60
1
2
3
4
-> 20 10 10 5

3 10 56
10
19
27
34
40
45
49
52
54
55
2
3
4
-> 16 11 9
* */