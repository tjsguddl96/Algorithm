
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  //faster than Scanner(throws 필요)
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out)); //faster than sysout
		
		int T=Integer.parseInt(br.readLine()); //정수형은 형변환 필수. bufferedreader는 string 타입으로 읽기때문.
		
		for(int i=0;i<T;i++) {
			String[] tmp=br.readLine().split(" "); // 문자열 한줄을 받고, " "으로 잘라서 tmp 에 저장
			
			int a=Integer.parseInt(tmp[0]); //String to int
			
			int b=Integer.parseInt(tmp[1]);
			
			String ans=Integer.toString(a+b); //int to String
			bw.write(ans+"\n"); //bufferedwrite엔 정수형이 들어갈 수 없음. -> a+b를 string 으로 변환해서 write해야함.
		
			//bw.newLine(); //줄바꿈
			
		}
		bw.close(); //버퍼를 항상 닫아줘야함.(다쓴 후에는 버퍼를 비워줘야함)-> 정상적으로 write가 안될 가능성이 높음.
		//BufferReader는 garbage collector가 알아서 자원을 회수 한다.->close() 안해줘도 됨.

	}

}