package day1213;

public class Ex6While {

	public static void main(String[] args) {
		int a = 65;
		while (a <= 90) {
			System.out.print((char) a++);
		}
		System.out.println();

		//do-while문으로 a~z까지 출력
		char b='a';
		do {
			System.out.print(b++);
		}while(b <='z');
		System.out.println();
		
		int n=0;
		while(n<=10) {
			n++;
			if(n%2==0)
				continue; // 조건식 이동
			System.out.printf("%3d", n);			
		}
		
	}

}
