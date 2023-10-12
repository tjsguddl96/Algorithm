import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int dy[]={-1,-1,-1,0,0,1,1,1};
    static int dx[]={-1,0,1,-1,1,-1,0,1};
    static PriorityQueue<Tree> spring=new PriorityQueue<>();
    static PriorityQueue<Tree> summer=new PriorityQueue<>();
    static PriorityQueue<Tree> fall=new PriorityQueue<>();
    static int n,m,k; //n:땅 크기, m:처음 심는 나무 갯수, k:년
    static int[][] a; //겨울에 해당 지역에 양분이 더해지는 수
    static int[][] map;
    static class Tree implements Comparable<Tree>{
        int y;
        int x;
        int age;
        public Tree(int y,int x,int age){
            this.y=y;
            this.x=x;
            this.age=age;
        }
        @Override
        public int compareTo(Tree o){
            return this.age-o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        a=new int[n][n];
        map=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                a[i][j]=Integer.parseInt(st.nextToken());
                map[i][j]=5;
            }
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int y=Integer.parseInt(st.nextToken())-1;
            int x=Integer.parseInt(st.nextToken())-1;
            int age=Integer.parseInt(st.nextToken());
            spring.add(new Tree(y,x,age));
        }
        for(int i=0;i<k;i++){
            for(int j=0;j<4;j++){
                if(j==0){ //봄
                    while(!spring.isEmpty()) {
                        Tree tree = spring.poll();
                        int y = tree.y;
                        int x = tree.x;
                        int age = tree.age;
                        if (map[y][x] >= age) {
                            map[y][x] -= age;
                            age += 1;
                            fall.add(new Tree(y, x, age));
                        } else {
                            summer.add(new Tree(y, x, age));
                        }
                    }
                }else if(j==1){ //여름
                    while(!summer.isEmpty()){
                        Tree tree=summer.poll();
                        int y=tree.y;
                        int x=tree.x;
                        int age=tree.age;
                        map[y][x]+=(age/2);
                    }
                }else if(j==2){ //가을
                    while(!fall.isEmpty()){
                        Tree tree=fall.poll();
                        int y=tree.y;
                        int x=tree.x;
                        int age=tree.age;
                        if(age%5==0){
                            for(int k=0;k<8;k++){
                                int nextY=y+dy[k];
                                int nextX=x+dx[k];
                                if(nextY>=0 && nextY<n && nextX>=0 && nextX<n){
                                    spring.add(new Tree(nextY,nextX,1));
                                }
                            }
                        }
                        spring.add(tree);
                    }
                }else{ //겨울
                    for(int y=0;y<n;y++){
                        for(int x=0;x<n;x++){
                            map[y][x]+=a[y][x];
                        }
                    }
                }
            }
        }

        System.out.println(spring.size());
    }
}