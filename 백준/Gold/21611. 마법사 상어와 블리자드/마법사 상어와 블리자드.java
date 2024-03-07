import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] dx={0,0,0,-1,1};
    static int[] dy={0,-1,1,0,0}; //위1 아래2 왼3 오4 순
    static int[][] map;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static Position[] magic;
    static int[] answer=new int[4];
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N+1][N+1];
        magic=new Position[M];
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<N+1;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int d=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            magic[i]=new Position(d,s);
        }
        for(int i=0;i<M;i++){
            snow(magic[i].y,magic[i].x);
            move();
            boolean flag=true;
            while(flag){
                flag=explode();
                move();
            }
            transform();
        }
        answer[0]=answer[1]+(2*answer[2])+(3*answer[3]);
        System.out.println(answer[0]);
    }
    public static void snow(int d,int s){ //1. 구슬 파괴
        int nowY=(N+1)/2;
        int nowX=(N+1)/2;
        for(int i=0;i<s;i++){
            nowY+=dy[d];
            nowX+=dx[d];
            map[nowY][nowX]=0;
        }
    }
    public static boolean explode() { //2. 구슬 폭발 (when 같은 구슬 번호 4개 이상 연속)
        int nowY=(N+1)/2;
        int nowX=(N+1)/2;
        int prev=0;
        boolean flag=false;
        ArrayDeque<Position> q=new ArrayDeque<>();
        for(int i=1;i<N;i++){
            if(i==(N-1)){ //3번 오 위 왼 순
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(prev==map[nowY][nowX]){
                        q.add(new Position(nowY,nowX));
                    }
                    else{
                        if(q.size()>=4){
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                map[now.y][now.x]=0;
                                answer[prev]+=1;
                            }
                            flag=true;
                        }
                        prev=map[nowY][nowX];
                        q=new ArrayDeque<>();
                        q.add(new Position(nowY,nowX));
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(prev==map[nowY][nowX]){
                        q.add(new Position(nowY,nowX));
                    }
                    else{
                        if(q.size()>=4){
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                map[now.y][now.x]=0;
                                answer[prev]+=1;
                            }
                            flag=true;
                        }
                        prev=map[nowY][nowX];
                        q=new ArrayDeque<>();
                        q.add(new Position(nowY,nowX));
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(prev==map[nowY][nowX]){
                        q.add(new Position(nowY,nowX));
                    }
                    else{
                        if(q.size()>=4){
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                map[now.y][now.x]=0;
                                answer[prev]+=1;
                            }
                            flag=true;
                        }
                        prev=map[nowY][nowX];
                        q=new ArrayDeque<>();
                        q.add(new Position(nowY,nowX));
                    }
                }
            }
            else if(i%2==0){ //i가 짝수번째면 오 위
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(prev==map[nowY][nowX]){
                        q.add(new Position(nowY,nowX));
                    }
                    else{
                        if(q.size()>=4){
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                map[now.y][now.x]=0;
                                answer[prev]+=1;
                            }
                            flag=true;
                        }
                        prev=map[nowY][nowX];
                        q=new ArrayDeque<>();
                        q.add(new Position(nowY,nowX));
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(prev==map[nowY][nowX]){
                        q.add(new Position(nowY,nowX));
                    }
                    else{
                        if(q.size()>=4){
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                map[now.y][now.x]=0;
                                answer[prev]+=1;
                            }
                            flag=true;
                        }
                        prev=map[nowY][nowX];
                        q=new ArrayDeque<>();
                        q.add(new Position(nowY,nowX));
                    }
                }
            }
            else{ //i가 홀수라면 왼 아래
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(prev==map[nowY][nowX]){
                        q.add(new Position(nowY,nowX));
                    }
                    else{
                        if(q.size()>=4){
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                map[now.y][now.x]=0;
                                answer[prev]+=1;
                            }
                            flag=true;
                        }
                        prev=map[nowY][nowX];
                        q=new ArrayDeque<>();
                        q.add(new Position(nowY,nowX));
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[2];
                    nowX+=dx[2];
                    if(prev==map[nowY][nowX]){
                        q.add(new Position(nowY,nowX));
                    }
                    else{
                        if(q.size()>=4){
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                map[now.y][now.x]=0;
                                answer[prev]+=1;
                            }
                            flag=true;
                        }
                        prev=map[nowY][nowX];
                        q=new ArrayDeque<>();
                        q.add(new Position(nowY,nowX));
                    }
                }
            }

        }
        return flag;
    }
    public static void move(){ //구슬 빈칸 이동
        int nowY=(N+1)/2;
        int nowX=(N+1)/2;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=1;i<N;i++){
            if(i==(N-1)){ //3번 오 위 왼 순
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(map[nowY][nowX]!=0){
                        q.add(map[nowY][nowX]);
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(map[nowY][nowX]!=0){
                        q.add(map[nowY][nowX]);
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(map[nowY][nowX]!=0){
                        q.add(map[nowY][nowX]);
                    }
                }
            }
            else if(i%2==0){ //i가 짝수번째면 오 위
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(map[nowY][nowX]!=0){
                        q.add(map[nowY][nowX]);
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(map[nowY][nowX]!=0){
                        q.add(map[nowY][nowX]);
                    }
                }
            }
            else{ //i가 홀수라면 왼 아래
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(map[nowY][nowX]!=0){
                        q.add(map[nowY][nowX]);
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[2];
                    nowX+=dx[2];
                    if(map[nowY][nowX]!=0){
                        q.add(map[nowY][nowX]);
                    }
                }
            }
        }

        nowY=(N+1)/2;
        nowX=(N+1)/2;

        for(int i=1;i<N;i++){
            if(i==(N-1)){ //3번 오 위 왼 순
                for(int j=0;j<i;j++){
                    nowY += dy[4];
                    nowX += dx[4];
                    if(!q.isEmpty()) {
                        int marble = q.poll();
                        map[nowY][nowX] = marble;
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(!q.isEmpty()) {
                        int marble = q.poll();
                        map[nowY][nowX] = marble;
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(!q.isEmpty()) {
                        int marble = q.poll();
                        map[nowY][nowX] = marble;
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
            }
            else if(i%2==0){ //i가 짝수번째면 오 위
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(!q.isEmpty()) {
                        int marble = q.poll();
                        map[nowY][nowX] = marble;
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(!q.isEmpty()) {
                        int marble = q.poll();
                        map[nowY][nowX] = marble;
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
            }
            else{ //i가 홀수라면 왼 아래
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(!q.isEmpty()) {
                        int marble = q.poll();
                        map[nowY][nowX] = marble;
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[2];
                    nowX+=dx[2];
                    if(!q.isEmpty()) {
                        int marble = q.poll();
                        map[nowY][nowX] = marble;
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
            }
        }
    }
    public static void transform(){ //3. 구슬 변화 (연속하는 같은 번호의 구슬, 그 구슬의 번호)
        int nowY=(N+1)/2;
        int nowX=(N+1)/2;
        int prev=0;
        int cnt=0;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=1;i<N;i++){
            if(i==(N-1)){ //3번 오 위 왼 순
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(prev==map[nowY][nowX]){
                        cnt++;
                    }
                    else{
                        int marbleCnt=cnt;
                        int marbleNum=prev;
                        q.add(marbleCnt);
                        q.add(marbleNum);
                        prev=map[nowY][nowX];
                        cnt=1;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(prev==map[nowY][nowX]){
                        cnt++;
                    }
                    else{
                        int marbleCnt=cnt;
                        int marbleNum=prev;
                        q.add(marbleCnt);
                        q.add(marbleNum);
                        prev=map[nowY][nowX];
                        cnt=1;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(prev==map[nowY][nowX]){
                        cnt++;
                    }
                    else{
                        int marbleCnt=cnt;
                        int marbleNum=prev;
                        q.add(marbleCnt);
                        q.add(marbleNum);
                        prev=map[nowY][nowX];
                        cnt=1;
                    }
                }
            }
            else if(i%2==0){ //i가 짝수번째면 오 위
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(prev==map[nowY][nowX]){
                        cnt++;
                    }
                    else{
                        int marbleCnt=cnt;
                        int marbleNum=prev;
                        q.add(marbleCnt);
                        q.add(marbleNum);
                        prev=map[nowY][nowX];
                        cnt=1;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(prev==map[nowY][nowX]){
                        cnt++;
                    }
                    else{
                        int marbleCnt=cnt;
                        int marbleNum=prev;
                        q.add(marbleCnt);
                        q.add(marbleNum);
                        prev=map[nowY][nowX];
                        cnt=1;
                    }
                }
            }
            else{ //i가 홀수라면 왼 아래
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    //prev==0일 때, 고려해봐야됨
                    if(prev==map[nowY][nowX]){
                        cnt++;
                    }
                    else{
                        int marbleCnt=cnt;
                        int marbleNum=prev;
                        if(prev!=0){
                            q.add(marbleCnt);
                            q.add(marbleNum);
                        }
                        prev=map[nowY][nowX];
                        cnt=1;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[2];
                    nowX+=dx[2];
                    if(prev==map[nowY][nowX]){
                        cnt++;
                    }
                    else{
                        int marbleCnt=cnt;
                        int marbleNum=prev;
                        q.add(marbleCnt);
                        q.add(marbleNum);
                        prev=map[nowY][nowX];
                        cnt=1;
                    }
                }
            }
        }
        nowY=(N+1)/2;
        nowX=(N+1)/2;

        for(int i=1;i<N;i++){
            if(i==(N-1)){ //3번 오 위 왼 순
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(!q.isEmpty()){
                        map[nowY][nowX]=q.poll();
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(!q.isEmpty()){
                        map[nowY][nowX]=q.poll();
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(!q.isEmpty()){
                        map[nowY][nowX]=q.poll();
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
            }
            else if(i%2==0){ //i가 짝수번째면 오 위
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    if(!q.isEmpty()){
                        map[nowY][nowX]=q.poll();
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    if(!q.isEmpty()){
                        map[nowY][nowX]=q.poll();
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
            }
            else{ //i가 홀수라면 왼 아래
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    if(!q.isEmpty()){
                        map[nowY][nowX]=q.poll();
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[2];
                    nowX+=dx[2];
                    if(!q.isEmpty()){
                        map[nowY][nowX]=q.poll();
                    }
                    else{
                        map[nowY][nowX]=0;
                    }
                }
            }

        }
    }
    public static void snail(){
        int nowY=(N+1)/2;
        int nowX=(N+1)/2;
        int cnt=1;
        for(int i=1;i<N;i++){
            if(i==(N-1)){ //3번 오 위 왼 순
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    map[nowY][nowX]=cnt;
                    cnt++;
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    map[nowY][nowX]=cnt;
                    cnt++;
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    map[nowY][nowX]=cnt;
                    cnt++;
                }
            }
            else if(i%2==0){ //i가 짝수번째면 오 위
                for(int j=0;j<i;j++){
                    nowY+=dy[4];
                    nowX+=dx[4];
                    map[nowY][nowX]=cnt;
                    cnt++;
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[1];
                    nowX+=dx[1];
                    map[nowY][nowX]=cnt;
                    cnt++;
                }
            }
            else{ //i가 홀수라면 왼 아래
                for(int j=0;j<i;j++){
                    nowY+=dy[3];
                    nowX+=dx[3];
                    map[nowY][nowX]=cnt;
                    cnt++;
                }
                for(int j=0;j<i;j++){
                    nowY+=dy[2];
                    nowX+=dx[2];
                    map[nowY][nowX]=cnt;
                    cnt++;
                }
            }

        }
    }
    public static void print(){
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}