import java.util.*;
import java.io.*;
public class Main {
    static int N,C;
    static int[] w;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        w=new int[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            w[i]=Integer.parseInt(st.nextToken());
            if(w[i]==C){
                answer=1;
            }
        }
        if(answer!=1) {
            Arrays.sort(w);
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    int sum=w[i]+w[j];
                    int left=0;
                    int right=N-1;
                    if(sum>C){
                        break;
                    }
                    if(sum==C){
                        answer=1;
                        break;
                    }
                    while(left<right){
                        int mid=(left+right)/2;
                        int tmp=C-sum;
                        if(tmp<w[mid]){
                            right=mid-1;
                        }
                        else if(tmp==w[mid] && i!=mid && j!=mid){
                            answer=1;
                            break;
                        }
                        else{
                            left=mid+1;
                        }
                    }
                }
                if(answer==1){
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}