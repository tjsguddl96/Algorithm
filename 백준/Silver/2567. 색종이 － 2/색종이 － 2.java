import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int[][] map=new int[103][103];
        int[] dy= {1,-1,0,0};
        int[] dx= {0,0,1,-1};
        int n=Integer.parseInt(bf.readLine());
        
        for(int i=0;i<n;i++) {
        	StringTokenizer st=new StringTokenizer(bf.readLine());
        	int n1=Integer.parseInt(st.nextToken());
        	int n2=Integer.parseInt(st.nextToken());
        	
        	for(int y=n1;y<n1+10;y++) {
        		for(int x=n2;x<n2+10;x++) {
        			map[y+1][x+1]=1;
        		}
        	}
        	
        }
        
        int ans=0;
        
        for(int i=0;i<103;i++) {
        	for(int j=0;j<103;j++) {
        		if(map[i][j]==1) {
        			for(int k=0;k<4;k++) {
        				int nextY=i+dy[k];
        				int nextX=j+dx[k];
        				if(nextY>=0 && nextY<103 && nextX>=0 && nextX<103 && map[nextY][nextX]==0) {
        					ans++;
        				}
        			}
        		}
        	}

        }
        System.out.println(ans);
        
    }
    
}
/*

3
10 10
15 15
25 25
-> 100

4
10 10
20 20
10 30
30 30
-> 160

2
10 10
10 20
->60

2
10 20
40 50
->80

4
3 7
5 2
15 7
13 14
-> 96

9
3 7
5 2
15 7
13 14
50 60
60 70
90 90
90 90
0 90
->256
*/