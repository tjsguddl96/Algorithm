/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int N,T;
	static int[][] arr;
	static int[] dp;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int ansM;
	static int ansR;
	static int[][] ch;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N=sc.nextInt();
			arr=new int[N][N];
			dp=new int[N*N+1];
			ansM=0;
			ansR=99999999;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
		
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dp[arr[i][j]]=BFS(i,j);
				}
			}
			int max=0;
			int ans=0;
			
			for(int i=1;i<N*N+1;i++) {
				if(i>N*N-max) {
					break;
				}
				if (max<dp[i]) {
					max=dp[i];
					ans=i;
				}
			}
			System.out.println("#"+tc+" "+ans+" "+max);
		}
		
	}
	public static int BFS(int yIdx,int xIdx) {
		Queue<Integer> xq= new ArrayDeque<>();
		Queue<Integer> yq=new ArrayDeque<>();
		Queue<Integer> dist=new ArrayDeque<>();

		
		yq.offer(yIdx);
		xq.offer(xIdx);
		dist.offer(1);
		
		int nowY=yIdx;
		int nowX=xIdx;
		int nowD=1;
		ch=new int[N][N];
		
		while(!xq.isEmpty() && !yq.isEmpty() && !dist.isEmpty()) {
			nowY=yq.poll();
			nowX=xq.poll();
			nowD=dist.poll();
			
			ch[nowY][nowX]=1;
			
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if((nextY>=0 && nextY<N) && (nextX>=0 && nextX<N) && ch[nextY][nextX]==0 && (arr[nextY][nextX]==arr[nowY][nowX]+1)) {
					yq.offer(nextY);
					xq.offer(nextX);
					dist.offer(nowD+1);
					ch[nextY][nextX]=1;
				}
			}
			
			
		}
		
		return nowD;
	}
}