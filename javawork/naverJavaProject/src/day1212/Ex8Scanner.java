package day1212;

import java.util.Scanner;

public class Ex8Scanner {

	public static void main(String[] args) {
		// 입력 응용 해보기
		Scanner sc = new Scanner(System.in);
		String goods;
		int price;
		
		
		System.out.println("상품 가격 입력");
		price=sc.nextInt(); // 숫자만 읽고 엔터는 버퍼로 들어간다.
		System.out.println("상품명 입력");
		goods=sc.nextLine(); // 버퍼의 엔터를 읽어온다.(없으면 키보드로부터 읽어온다.)
		
		System.out.println(goods+"상뭄의 가격 : "+price+"원");
	}

}
