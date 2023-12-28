import java.util.*;
import java.io.*;

public class Main {
    static int n,m; //n: 세로, m: 가로
    static char[][] map;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new char[n*2][2*m];
        for(int i=0;i<n;i++){
            String str=bf.readLine();
            for(int j=0;j<str.length();j++){
                char now=str.charAt(j);
                map[2*i][2*j]=now;
                map[2*i][(2*j)+1]=now;
                map[(2*i)+1][2*j]=now;
                map[(2*i)+1][(2*j)+1]=now;
            }
        }
        for(int i=1;i<=(2*n)-1;i++){
            for(int j=1;j<=(2*m)-1;j++){
                if(map[i][j]!='X'){
                    continue;
                }
                for(int k=0;k<4;k++) {//아래(0), 위(1), 오른쪽(2), 왼쪽(3) 순
                    int flag = 0; //0이면 붙어 있는 벽이 4개다.
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if (nextY < 1 || nextY >= (2 * n) - 1 || nextX < 1 || nextX >= (2 * m) - 1) { //범위 계산
                        continue;
                    }
                    if (map[nextY][nextX] != 'X') {
                        if (k == 0 || k==1) {//아래
                            for (int w = 0; w < 4; w++) {
                                if ((j+4)>=2*m || map[i][j + w] != 'X') {//붙어있는 벽 4개 중 하나라도 벽이 아니면 걍 pass
                                    flag = 1;
                                    break;
                                }
                            }
                            if (flag == 0) { //벽이 4개니까
                                //위 쪽 공간 살핌
                                if (map[i - 1][j] == '.' || map[i - 1][j] == '2') {
                                    for (int w = 0; w < 4; w++) {
                                        if ((j+4)>=2*m || map[i - 1][j + w] != '.' && map[i - 1][j + w] != '2') {//붙어있는 공간 4개 중 하나라도 공간이 아니면 걍 pass
                                            flag = 1;
                                            break;
                                        }
                                    }
                                    if (flag == 0) {
                                        for (int w = 0; w < 4; w++) {
                                            map[i - 1][j + w] = '1';
                                        }
                                        answer += 1;
                                    }

                                }
                                //아래쪽 공간 살핌
                                flag=0;
                                if (map[i + 1][j] == '.' || map[i + 1][j] == '2') {
                                    for (int w = 0; w < 4; w++) {
                                        if ((j+4)>=2*m || map[i + 1][j + w] != '.' && map[i + 1][j + w] != '2') {//붙어있는 공간 4개 중 하나라도 공간이 아니면 걍 pass

                                            flag = 1;
                                            break;
                                        }
                                    }
                                    if (flag == 0) {
                                        for (int w = 0; w < 4; w++) {
                                            map[i + 1][j + w] = '1';
                                        }
                                        answer += 1;
                                    }
                                }

                            }
                        } else if (k == 2 || k==3) {//오른
                            for (int w = 0; w < 4; w++) {
                                if ((i+4)>=2*n || map[i+w][j] != 'X') {//붙어있는 벽 4개 중 하나라도 벽이 아니면 걍 pass
                                    flag = 1;
                                    break;
                                }
                            }
                            if(flag==0){
                                //오른쪽 공간 살핌
                                if(map[i][j+1]=='.' || map[i][j+1]=='1'){
                                    for (int w = 0; w < 4; w++) {
                                        if ((i+4)>=2*n ||map[i + w][j + 1] != '.' && map[i + w][j + 1] != '1') {//붙어있는 공간 4개 중 하나라도 공간이 아니면 걍 pass
                                            flag = 1;
                                            break;
                                        }
                                    }
                                    if (flag == 0) {
                                        for (int w = 0; w < 4; w++) {
                                            map[i + w][j + 1] = '2';
                                        }
                                        answer += 1;
                                    }
                                }
                                flag=0;
                                //왼쪽 공간 살핌
                                if(map[i][j-1]=='.' || map[i][j-1]=='1'){
                                    for (int w = 0; w < 4; w++) {
                                        if ((i+4)>=2*n || (map[i + w][j - 1] != '.' && map[i + w][j - 1] != '1')) {//붙어있는 공간 4개 중 하나라도 공간이 아니면 걍 pass
                                            flag = 1;
                                            break;
                                        }
                                    }
                                    if (flag == 0) {
                                        for (int w = 0; w < 4; w++) {
                                            map[i + w][j - 1] = '2';
                                        }
                                        answer += 1;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}