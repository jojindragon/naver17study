package day1212;

public class Ex5Operator {

	public static void main(String[] args) {
		// 삼항 연산자 == 조건연산자 ==> 조건식1 ? true 문장 : false 문장
		// 복수 조건 ==> 조건식1 ? true 문장 : 조건식2 ? true 문장 : 조건식3 ? true 문장 : false 문장
		int x, y, max, z;
		x = 5;
		y = 13;
		max = x > y ? x : y;
		System.out.println("max=" + max);

		z = 20;
		max = x > y && x > z ? x : y > z && y > z ? y : z;
		System.out.println("max=" + max);

		// 90 이상 'A', 80 이상 'B',70이상 'C,60이상 'D', 나머지 'F' => 수식 구현
		int score = 89;
		char grade;
		grade = score >= 90 ? 'A' : score >= 80 ? 'B' : score >= 70 ? 'C' : score >= 60 ? 'D' : 'F';
		System.out.println("grade=" + grade);
		System.out.println("점수: " + score + (score >= 90 ? " Good" : " ReTry"));

	}

}
