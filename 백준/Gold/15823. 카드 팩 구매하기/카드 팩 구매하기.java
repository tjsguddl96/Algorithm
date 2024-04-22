import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        input=new int[N];
        for(int i=0;i<N;i++){
            input[i]=Integer.parseInt(st.nextToken());
        }
        int left=1;
        int right=N;
        int mid=0;
        int answer=0;
        int tmp=0;
        while(left<=right){
            mid=(left+right)/2; //한 카드팩을 이루는 카드의 수
            int pointer1=0;
            int pointer2=0;
            int cnt=0;
            HashSet<Integer> card=new HashSet<>();
//            System.out.println(mid+"!");
            while(pointer2<N){
//                System.out.println(card);
                if(card.size()==mid){
                    cnt++;
                    pointer1=pointer2;
                    pointer2=pointer1;
                    card=new HashSet<>();
                }
                else if(!card.contains(input[pointer2])){
                    card.add(input[pointer2]);
                    pointer2++;
                }
                else{
                    card.remove(input[pointer1]);
                    pointer1++;
                }

            }
            if(card.size()==mid){
                cnt++;
            }
//            System.out.println("cnt : "+cnt);
//            System.out.println("________");
            if(cnt>=M){
                answer=mid;
                tmp=cnt;
                left=mid+1;
            }
            else{
                right=mid-1;
            }

        }
        System.out.println(answer);
    }
}
/*
10 1
1 2 3 4 5 6 7 8 9 10
* */