import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
	
	public static String findCh(String[] ch, String tmp) {
		
		String ans="";
		for(int i=0;i<ch.length;i++) {
			if (ch[i].equals(tmp)) {
				switch(i) {
					case 0:
						ans+="A";
						break;
					case 1:
						ans+="B";
						break;
					case 2:
						ans+="C";
						break;
					case 3:
						ans+="D";
						break;
					case 4:
						ans+="E";
						break;
					case 5:
						ans+="F";
						break;
					case 6:
						ans+="G";
						break;
					case 7:
						ans+="H";
						break;
					default:
						break;
				}
			}
			
		}
		
		return ans;
		
	}
	
	public static String Ch(String[] ch, String tmp,int idx) {  //Ch(ch,tmp,i)
		int[] cnt= {0,0,0,0,0,0,0,0};	 
		String ans="";
		int C=0;
		for (int i=0;i<ch.length;i++) {
			for(int j=0;j<6;j++) {
				if (ch[i].charAt(j)!=tmp.charAt(j)) {
					cnt[i]+=1;
				}
			}
		}
		for(int i=0;i<ch.length;i++) {
			if (cnt[i]==1) {
				C+=1;
				switch(i) {
					case 0:
						ans+="A";
						break;
					case 1:
						ans+="B";
						break;
					case 2:
						ans+="C";
						break;
					case 3:
						ans+="D";
						break;
					case 4:
						ans+="E";
						break;
					case 5:
						ans+="F";
						break;
					case 6:
						ans+="G";
						break;
					case 7:
						ans+="H";
						break;
					default:
						break;
				}
			}
				
		}
		if (C!=1) {
			System.out.println(idx+1);
			return "";
		}
		return ans;
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		String[] ch= {"000000","001111","010011","011100","100110","101001","110101","111010"};
		Scanner in = new Scanner(System.in);
		int len=in.nextInt();
		int flag=0;
		String ans="";
		String msg=in.next();
		
		for (int i=0;i<len;i++) {
			String tmp="";
			for(int j=6*i;j<6*i+6;j++) {
				tmp+=msg.charAt(j);
			}
			if (findCh(ch,tmp).length()==0) {
				if (Ch(ch,tmp,i).length()!=0) {
					ans+=Ch(ch,tmp,i);
				}
				else {
					
					return ;
				}

			}
			else {
				ans+=findCh(ch,tmp);
			}
			
		}
		System.out.println(ans);
		
	}
	
}