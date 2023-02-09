import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
public class Main {
	static int[] count; //idx가 0이면 A,.... 3이면 T
	static int S;
	static int P;
	static String str;
	static int[] must;
	static boolean[] ch;
	static int ans;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		S=sc.nextInt();
		P=sc.nextInt();
		
		str=sc.next();
		
		must=new int[4];

		
		for (int i=0;i<4;i++) {
			must[i]=sc.nextInt();
		}
		String tmp=str.substring(0,P);
		count=new int[4];
		int flag=0;
		for(int i=0;i<tmp.length();i++) {
			
			switch (tmp.charAt(i)) {
				case 'A':
					count[0]+=1;
					break;
				case 'C':
					count[1]+=1;
					break;
				case 'G':
					count[2]+=1;
					break;

				default:
					count[3]+=1;
					break;
				}
			}

		for(int k=0;k<4;k++) {
			if(count[k]<must[k]) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
			ans+=1;
		}
		
		for(int i=1;i<=S-P;i++) {
			flag=0;
			char removeC=str.charAt(i-1);
			char addC=str.charAt(i+P-1);
			
			switch (removeC) {
				case 'A':
					count[0]-=1;
					break;
				case 'C':
					count[1]-=1;
					break;
				case 'G':
					count[2]-=1;
					break;
	
				default:
					count[3]-=1;
					break;
			}
			switch (addC) {
				case 'A':
					count[0]+=1;
					break;
				case 'C':
					count[1]+=1;
					break;
				case 'G':
					count[2]+=1;
					break;
	
				default:
					count[3]+=1;
					break;
			}
			for(int k=0;k<4;k++) {
				if(count[k]<must[k]) {
					flag=1;
					break;
				}
			}
			if (flag==0) {
				ans+=1;
			}
			
		}
		System.out.println(ans);
		
	}
	
}

/*
4 3
GATA
1 0 0 1
--> 2
 */