package day1211;

/*
  * 이상욱
  * 삼성전자
  * 홍보부
  * 89
  * 100
  * 72
 
 * 이름(name), 회사명(emp), 부서(dep), 3과목의 입사시험점수(score1, score2, score3)
 * 위를 읽어서 위의 데이터와 입사시험 총합(total)과 평균(avg)를 출력해라.
 * 단, 소숫점 첫째자리까지만 출력(printf)
 * */


public class Ex9Argument {

	public static void main(String[] args) {
		// 메인 Argument 값 읽기 문제	
		String name = args[0];
		String emp = args[1];
		String dep = args[2];
		int score1 = Integer.parseInt(args[3]);
		int score2 = Integer.parseInt(args[4]);
		int score3 = Integer.parseInt(args[5]);
		int total = score1+score2+score3;
		double avg = total / 3.0;
		
		System.out.printf("* 이름\t:  %s\n", name);
		System.out.printf("* 회사명\t:  %s\n", emp);
		System.out.printf("* 부서\t:  %s\n", dep);
		System.out.printf("* 시험 점수\t:  %d %d %d\n", score1, score2, score3);
		System.out.printf("* 총점\t:  %d\n", total);
		System.out.printf("* 평균\t:  %4.1f\n", avg);

	}

}
