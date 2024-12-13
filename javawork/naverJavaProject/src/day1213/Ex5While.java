package day1213;

public class Ex5While {

	public static void main(String[] args) {
		int a=11;
		while(a<10) {// 조건이 맞지 않으면 실행 X
			System.out.println("while loop");
		}
		
		do {// 1번 실행 후 조건 비교 -> 조건이 맞지 않아도 실행 
			System.out.println("do-while loop");
		}while(a<10);
		
		a=0;
		while(a<10) {
			System.out.printf("%3d", ++a);
		}
		int b=0;
		do {
			System.out.printf("%3d", b++);
		}while(b<10);
	}

}
