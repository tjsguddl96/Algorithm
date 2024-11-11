import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static class CCTV{
        int y;
        int x;
        int n;
        public CCTV(int y,int x,int n){
            this.y=y;
            this.x=x;
            this.n=n;
        }
    }
    static ArrayList<CCTV> cctv=new ArrayList<>();
    static int[][] map; //-1이면 cctv 감시
    static int answer=Integer.MAX_VALUE;
    static int[] direct;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken()); //세로
        M=Integer.parseInt(st.nextToken()); //가로
        direct=new int[6];
        direct[1]=4;
        direct[2]=2;
        direct[3]=4;
        direct[4]=4;
        direct[5]=1;
        map=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]>0 && map[i][j]<6){
                    cctv.add(new CCTV(i,j,map[i][j]));
                }
            }
        }
        solve(0,0);
        System.out.println(answer);

    }
    public static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    public static void solve(int idx,int dir){
        if(idx==cctv.size()){
            int cnt=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==0){
                        cnt++;
                    }
                }
            }
            answer=Math.min(answer,cnt);
            return ;
        }
        int startY=cctv.get(idx).y;
        int startX=cctv.get(idx).x;
        int n=cctv.get(idx).n;
        for(int i=0;i<direct[n];i++){
            see(n,i,startY,startX);
            solve(idx+1,0);
            unsee(n,i,startY,startX);
        }
    }

    public static void see(int idx,int dir,int startY,int startX){
        if(idx==1){
            if(dir==0){
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0) {
                        map[startY][i] -= 1;
                    }
                }
            }
            else if(dir==1){
                for(int i=startY+1;i<N;i++){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]-=1;
                    }
                }
            }
            else if(dir==2){
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0) {
                        map[startY][i] -= 1;
                    }
                }
            }
            else{
                for(int i=startY-1;i>=0;i--) {
                    if (map[i][startX] == 6) {
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]-=1;
                    }
                }
            }
        }
        else if(idx==2){
            if(dir==0){
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]-=1;
                    }
                }
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]-=1;
                    }
                }
            }
            else{
                for(int i=startY+1;i<N;i++){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]-=1;
                    }
                }
                for(int i=startY-1;i>=0;i--){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]-=1;
                    }
                }
            }
        }
        else if(idx==3){
            if(dir==0 || dir==1){
                if(dir==0) {
                    for (int i = startY - 1; i >= 0; i--) {
                        if (map[i][startX] == 6) {
                            break;
                        } else if (map[i][startX] <= 0) {
                            map[i][startX] -=1;
                        }
                    }
                }
                else{
                    for(int i=startY+1;i<N;i++){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]-=1;
                        }
                    }
                }
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]-=1;
                    }
                }
            }
            else if(dir==2 || dir==3){
                if(dir==2){
                    for(int i=startY+1;i<N;i++){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]-=1;
                        }
                    }
                }
                else{
                    for(int i=startY-1;i>=0;i--){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]-=1;
                        }
                    }
                }
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]-=1;
                    }
                }
            }
        }
        else if(idx==4){
            if(dir==0 || dir==1){
                if(dir==0){
                    for(int i=startY-1;i>=0;i--){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]-=1;
                        }
                    }
                }
                else{
                    for(int i=startY+1;i<N;i++){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]-=1;
                        }
                    }
                }
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]-=1;
                    }
                }
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]-=1;
                    }
                }
            }
            else if(dir==2 || dir==3){
                if(dir==2){
                    for(int i=startX-1;i>=0;i--){
                        if(map[startY][i]==6){
                            break;
                        }
                        else if(map[startY][i]<=0){
                            map[startY][i]-=1;
                        }
                    }
                }
                else{
                    for(int i=startX+1;i<M;i++){
                        if(map[startY][i]==6){
                            break;
                        }
                        else if(map[startY][i]<=0){
                            map[startY][i]-=1;
                        }
                    }
                }
                for(int i=startY+1;i<N;i++){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]-=1;
                    }
                }
                for(int i=startY-1;i>=0;i--){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]-=1;
                    }
                }
            }
        }
        else{
            if(dir==0){
                for(int i=startY+1;i<N;i++){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]-=1;
                    }
                }
                for(int i=startY-1;i>=0;i--){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]-=1;
                    }
                }
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]-=1;
                    }
                }
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]-=1;
                    }
                }
            }
        }
    }
    public static void unsee(int idx,int dir,int startY,int startX){
        if(idx==1){
            if(dir==0){
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0) {
                        map[startY][i] += 1;
                    }
                }
            }
            else if(dir==1){
                for(int i=startY+1;i<N;i++){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]+=1;
                    }
                }
            }
            else if(dir==2){
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0) {
                        map[startY][i] += 1;
                    }
                }
            }
            else{
                for(int i=startY-1;i>=0;i--) {
                    if (map[i][startX] == 6) {
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]+=1;
                    }
                }
            }
        }
        else if(idx==2){
            if(dir==0){
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]+=1;
                    }
                }
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]+=1;
                    }
                }
            }
            else{
                for(int i=startY+1;i<N;i++){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]+=1;
                    }
                }
                for(int i=startY-1;i>=0;i--){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]+=1;
                    }
                }
            }
        }
        else if(idx==3){
            if(dir==0 || dir==1){
                if(dir==0) {
                    for (int i = startY - 1; i >= 0; i--) {
                        if (map[i][startX] == 6) {
                            break;
                        } else if (map[i][startX] <= 0) {
                            map[i][startX] +=1;
                        }
                    }
                }
                else{
                    for(int i=startY+1;i<N;i++){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]+=1;
                        }
                    }
                }
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]+=1;
                    }
                }
            }
            else if(dir==2 || dir==3){
                if(dir==2){
                    for(int i=startY+1;i<N;i++){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]+=1;
                        }
                    }
                }
                else{
                    for(int i=startY-1;i>=0;i--){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]+=1;
                        }
                    }
                }
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]+=1;
                    }
                }
            }
        }
        else if(idx==4){
            if(dir==0 || dir==1){
                if(dir==0){
                    for(int i=startY-1;i>=0;i--){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]+=1;
                        }
                    }
                }
                else{
                    for(int i=startY+1;i<N;i++){
                        if(map[i][startX]==6){
                            break;
                        }
                        else if(map[i][startX]<=0){
                            map[i][startX]+=1;
                        }
                    }
                }
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]+=1;
                    }
                }
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]+=1;
                    }
                }
            }
            else if(dir==2 || dir==3){
                if(dir==2){
                    for(int i=startX-1;i>=0;i--){
                        if(map[startY][i]==6){
                            break;
                        }
                        else if(map[startY][i]<=0){
                            map[startY][i]+=1;
                        }
                    }
                }
                else{
                    for(int i=startX+1;i<M;i++){
                        if(map[startY][i]==6){
                            break;
                        }
                        else if(map[startY][i]<=0){
                            map[startY][i]+=1;
                        }
                    }
                }
                for(int i=startY+1;i<N;i++){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]+=1;
                    }
                }
                for(int i=startY-1;i>=0;i--){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]+=1;
                    }
                }
            }
        }
        else{
            if(dir==0){
                for(int i=startY+1;i<N;i++){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]+=1;
                    }
                }
                for(int i=startY-1;i>=0;i--){
                    if(map[i][startX]==6){
                        break;
                    }
                    else if(map[i][startX]<=0){
                        map[i][startX]+=1;
                    }
                }
                for(int i=startX+1;i<M;i++){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]+=1;
                    }
                }
                for(int i=startX-1;i>=0;i--){
                    if(map[startY][i]==6){
                        break;
                    }
                    else if(map[startY][i]<=0){
                        map[startY][i]+=1;
                    }
                }
            }
        }
    }
}