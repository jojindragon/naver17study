package day1212;

import java.util.Scanner;

public class Ex7Scanner {

	public static void main(String[] args) {
		// 사용자 입력 - 키보드 입력 읽어오기
		Scanner sc=new Scanner(System.in);	
		System.out.println("문장을 입력해봐라.");
//		String word=sc.next();
		String word=sc.nextLine();
		System.out.println("입력한 단어: \""+word+"\"");
		
		int age;
		System.out.println("나이도 입력해봐라.");
		age = sc.nextInt();
		System.out.println("나이: "+age+"세");
		
	}

}
