import java.io.*;
import java.util.*;

public class Main {
    static int T,n,K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            arr=new int[n];
            st=new StringTokenizer(bf.readLine());
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int min=Integer.MAX_VALUE;
            int ans=0;
            for(int i=0;i<n;i++){
                int now=arr[i];
                int left=i+1;
                int right=n-1;
                int mid=0;
                while(left<=right){
                    mid=(left+right)/2;
                    int tmp=now+arr[mid];
                    if(tmp<K){ //tmp가 K보다 작아 -> K-tmp해야됨
                        left=mid+1;
                        if(min>(K-tmp)){
                            ans=1;
                            min=K-tmp;
                        }
                        else if(min==(K-tmp)){
                            ans++;
                        }
                    }
                    else{ //tmp가 K보다 커 -> tmp-K해야됨
                        right=mid-1;
                        if(min>(tmp-K)){
                            ans=1;
                            min=tmp-K;
                        }
                        else if(min==(tmp-K)){
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);
//            answer.append(ans+"\n");
        }
//        bw.flush();
//        bw.write(answer.toString());
//        bw.close();
    }
}