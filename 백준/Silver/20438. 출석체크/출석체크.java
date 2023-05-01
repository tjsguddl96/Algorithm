import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n,k,q,m;
	static int[] student;
	static ArrayList<Integer> send;
	static int[][] range;
	static int[] ans;
	static int[] flag;
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken()); //학생수
		k=Integer.parseInt(st.nextToken()); //졸고있는 학생수
		q=Integer.parseInt(st.nextToken()); //진환이가 출석코드를 보낼 학생수
		m=Integer.parseInt(st.nextToken()); // 구간 수
		
		student =new int[n+3];
		flag =new int[n+3];
		send=new ArrayList<>();
		range=new int[m][2];
		ans=new int[m];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<k;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			student[tmp]=-1; //student[자고 있는 애]= -1;
			flag[tmp]=1; //flag==1이면 안한애
		}

		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<q;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			if(student[tmp]==-1) continue;
			send.add(tmp);
		}
		Collections.sort(send);
		
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(bf.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			range[i][0]=n1;
			range[i][1]=n2;
		}
		//student[i] : i번까지 출석체크를 한 사람 수
		for(int i=3;i<n+3;i++) {
			for(int j=0;j<send.size();j++) {
				if(student[i]==-1) {
					flag[i]=1;
					student[i]=student[i-1];
					break;
				}
				if(i%send.get(j)==0) {
					student[i]=student[i-1]+1;
					flag[i]=0;
					break;
				}
				student[i]=student[i-1];
				flag[i]=1;
			}
		}
		if(send.size()==0) {
			for(int i=3;i<n+3;i++) {
				student[i]=0;
			}
		}
//		for(int i=1;i<n+3;i++) {
//			System.out.println(i+ " "+student[i]);
//		}
		
		for(int i=0;i<m;i++) {
			int n1=range[i][0];
			int n2=range[i][1];
			
			ans[i]=((n2-2)-student[n2])-((n1-3)-student[n1-1]);
			
		}
		
		for(int i=0;i<m;i++) {
			System.out.println(ans[i]);			
		}
		
	}
	
}
//3 5 6 9 10 12
//4 7 8 11 
//i번째까지 안한 사람 : (i-2)-student[i]
//10번째 까지 안한 사람 : 8-stduent[10]=8-5 =3
//4번째까지 안한 사람 : 2-student[4]=1 
//n1~n2번째까지 안한 사람 : (n2-2)-student[n2]-  ((n1-2)-student[n1])?
//n1이 안한애면 -> +1 ->flag[n1]=1;이면
//8~10 : 3-3=0
//6~12 : 10-6 - (4-3)=3
//5~ 11 : 9-5 - (3-2)=3
//7~11 : 4-2= 2

/*
5 1 1 1
3
3
3 7
->5




i번째 까지 안한 사람 : (i-2)-student[i]



10 1 3 1
7
3 5 7
3 12
----
3 1
4 1
5 2
6 3
7 3
8 3
9 4
10 5
11 5
12 6
4
*/
//3 5 6 9 10 12
//4 7 8 11 

//12-2-6=4
//3-3-1=-1
//4-3-1=0