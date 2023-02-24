import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Character> arr;
	static ArrayList<String> ans;
	static int L,C;
	static Set<Character> set=new HashSet<>();
	static int[] ch;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1=new StringTokenizer(bf.readLine());
		L=Integer.parseInt(st1.nextToken());
		C=Integer.parseInt(st1.nextToken());
		
		arr=new ArrayList<>();
		ans=new ArrayList<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		ch=new int[C];
		
		StringTokenizer st2=new StringTokenizer(bf.readLine());
		
		for(int i=0;i<C;i++) {
			arr.add(st2.nextToken().charAt(0));
		}
		Collections.sort(arr); // a c i s t w
		for(int i=0;i<C;i++) {
			dfs(arr.get(i),""+arr.get(i),i);
		}
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
	public static void dfs(char now, String str,int idx) {
		if(str.length()==L) {
			int cntM=0; //모음 갯수
			for(int i=0;i<str.length();i++) {
				if(check(str.charAt(i))) { //모음이 맞다면 cntM ++;
					cntM++;
				}
			}
			if(cntM>=1 && (str.length()-cntM)>=2) {
				ans.add(str);
			}
			return ;
		}
		
		ch[idx]=1;
		for(int i=0;i<C;i++) {
			char nextC=arr.get(i);
			if(ch[i]==0 && (int)now<(int)nextC) {
				ch[i]=1;
				dfs(nextC,str+nextC,i);
				ch[i]=0;
			}
		}
		
		
	}
	public static boolean check(char c) { //모음을 포함하고 있다면 true -> 모음 갯수 +1 해주면 됨.
		if(set.contains(c)) {
			return true;
		}
		return false;
	}

}