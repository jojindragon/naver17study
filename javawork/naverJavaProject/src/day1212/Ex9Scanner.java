package day1212;

import java.util.Scanner;

public class Ex9Scanner {

	public static void main(String[] args) {
		// 이름, 키, 몸무게 읽기
		Scanner sc=new Scanner(System.in);
		
		String name;
		double height, weight;
		
		System.out.println("이름 입력");
		name = sc.nextLine();
		System.out.println("키와 몸무게 입력");
		height = sc.nextDouble();
		weight = sc.nextDouble();
		System.out.println("** "+name+" 님의 키와 몸무게 **");
		System.out.println("키: "+height+"Cm\t몸무게: "+weight+"Kg");
		

	}

}
