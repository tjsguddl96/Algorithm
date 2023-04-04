import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String text=bf.readLine();
		String pattern=bf.readLine();
		
		int textL=text.length();
		int patternL=pattern.length();
		int[] pi=new int[patternL];
		
		int j=0;
		for(int i=1;i<patternL;i++) {
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j=pi[j-1];
			}
			if(pattern.charAt(i)==pattern.charAt(j)) {
				j++;
				pi[i]=j;
			}
			else {
				pi[i]=0;
			}
		}
		
		int answer=0;
		ArrayList<Integer> list=new ArrayList<>();
		
		j=0;
		for(int i=0;i<textL;i++) {
			
			while(j>0 && text.charAt(i)!=pattern.charAt(j)) {
				j=pi[j-1];
			}
			if(text.charAt(i)==pattern.charAt(j)) {
				if(j==patternL-1) {
					answer++;
					list.add(i-j+1);
					j=pi[j];
				}
				else {
					j++;
				}
			}
			
		}

		System.out.println(answer);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}

}