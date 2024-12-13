package day1212;

import java.util.Scanner;

public class Book94 {

	public static void main(String[] args) {
		// 입력값이 무엇인지 판단하는 코드
		Scanner sc = new Scanner(System.in);
		
		int charCode;
		String code;
		
		while(true) {
			System.out.println("1글자를 입력하시오");
			code = sc.nextLine();
			
			if(code.length() > 1 || code.length() == 0) 
				System.out.println("다시 입력해라.");
			else
				break;
		}
		
		charCode = (int)code.charAt(0);
		
		if(65<=charCode && 90>=charCode)
			System.out.println("대문자를 입력");
		
		if(97<=charCode && 122>=charCode)
			System.out.println("소문자를 입력");
		
		if(48<=charCode && 57>=charCode) {
			System.out.println("0~9 숫자를 입력");
			
			int num = Integer.parseInt(code);
			boolean result = (num%2 == 0); 
			 			
			if(result) 
				System.out.println("짝수 입력");
			else
				System.out.println("홀수 입력");
			
		}
				
	}

}
