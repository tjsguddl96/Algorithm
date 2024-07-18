import java.util.*;
import java.io.*;
public class Main {
    static int N,M,L;
    static int[] places;
    static ArrayList<Integer> tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        places=new int[N+2];
        tmp=new ArrayList<>();
        st=new StringTokenizer(bf.readLine());
        places[0]=0;
        places[N+1]=L;
        int left=0;
        int right=0;
        int answer=right;
        for(int i=1;i<N+1;i++){
            places[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(places);
        for(int i=1;i<N+2;i++){
            tmp.add(places[i]-places[i-1]);
//            left=Math.min(left,places[i]-places[i-1]);
            right=Math.max(right,places[i]-places[i-1]);
        }
        while(left<=right){
            int mid=(left+right)/2;
            int cnt=0;
            ArrayList<Integer> gap=new ArrayList<>();
            for(int i=0;i<tmp.size();i++){
                gap.add(tmp.get(i));
            }
            Collections.sort(gap);
            int maxTarget=gap.get(gap.size()-1);
            gap.remove(gap.size()-1);
            while(maxTarget>mid) {
                int n1 = mid;
                int n2 = maxTarget - mid;
                gap.add(n1);
                gap.add(n2);
                cnt++;
                if(cnt>M){
                    break;
                }
                Collections.sort(gap);
                maxTarget=gap.get(gap.size()-1);
                gap.remove(gap.size()-1);
            }
            if(cnt>M){
                left=mid+1;
            }
            else{
                answer=mid;
                right=mid-1;
            }

        }
        System.out.println(answer);
    }
}
/*
6 7 1000
622 411 201 555 755 82

0 10 512
* */