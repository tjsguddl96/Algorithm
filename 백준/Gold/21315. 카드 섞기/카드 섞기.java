import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[] res=new int[2];
    static int[] fin;
    static Stack<Integer> card;
    static Queue<Integer> q;
    static Queue<Integer> tmpq;
    static Queue<Integer> tmp;
    static int[] ans=new int[2];
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        fin=new int[n];
        for(int i=0;i<n;i++){
            fin[i]=Integer.parseInt(st.nextToken());
        }
        permutation(0);
        System.out.println(ans[0]+" "+ans[1]);
    }
    public static void permutation(int cnt){
        if(cnt==2){
            if((int)Math.pow(2,res[0])<n && (int)Math.pow(2,res[1])<n) {
                card=new Stack<>();
                for(int i=1;i<=n;i++){
                    card.add(i);
                }
                mix(res[0]);
                tmp = new ArrayDeque<>();
                while (!card.isEmpty()) {
                    int t = card.pop();
                    tmp.add(t);
                }
                while (!tmp.isEmpty()) {
                    card.add(tmp.poll());
                }
                mix(res[1]);
                for (int i = 0; i < n; i++) {
                    if (card.pop() != fin[i]) {
                        return;
                    }
                }
                ans[0] = res[0];
                ans[1] = res[1];
            }
            return ;
        }
        for(int i=1;i<=n;i++){
            res[cnt]=i;
            permutation(cnt+1);
        }
    }
    public static void mix(int k){
        q=new ArrayDeque<>();
        tmpq=new ArrayDeque<>();
        for(int cnt=1;cnt<=k+1;cnt++){
            if(cnt==1) {
                for (int i = 0; i < (int) Math.pow(2, k); i++) {
                    q.add(card.pop());
                }
                while(!card.isEmpty()){
                    tmpq.add(card.pop());
                }
                while(!tmpq.isEmpty()){
                    card.add(tmpq.poll());
                }
            }else{
                for(int i=0;i<(int)Math.pow(2,(k-cnt+1));i++){
                    q.add(q.poll());
                }
                int qsize=q.size();
                for(int i=0;i<(qsize-(int)Math.pow(2,(k-cnt+1)));i++){
                    card.add(q.poll());
                }
            }
        }
        while(!q.isEmpty()){
            card.add(q.poll());
        }
    }
}