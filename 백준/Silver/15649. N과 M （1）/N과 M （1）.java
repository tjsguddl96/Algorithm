import java.util.Scanner;

public class Main {
	static int N,R,totalCnt;
	static int[] result,numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		R=sc.nextInt();
		
		result=new int[R];
		numbers=new int[N];
		isSelected=new boolean[N];
		
		for(int i=0;i<N;i++) {
			numbers[i]=i+1;
		}
		perm(0);
		
	}
	public static void perm(int cnt) {
		if (cnt==R) {
			totalCnt+=1;
			
			for(int i=0;i<result.length;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
			if (isSelected[i]) {
				continue;
			}
			isSelected[i]=true;
			result[cnt]=numbers[i];
			perm(cnt+1);
			isSelected[i]=false;
			
		}
	}

}