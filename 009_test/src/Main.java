import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int i=sc.nextInt();//테스트 횟수

		String star="";
		for(int b=i; b>0;b--) {			
			star+=" ";
			System.out.println(star+"*");
		}
	}
	
}
