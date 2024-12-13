package day1213;

import java.util.Scanner;

public class Ex7While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score, tot = 0, cnt = 0;
		double avg;

		while (true) {
			System.out.print("점수 입력(종료 시 -1): ");
			score = sc.nextInt();
								
			if(score == -1)
				break;		
			
			if(score < -1 || score > 100) {
				System.out.println("다시 입력해라.");
				continue;
			}			
			
			cnt++;
			tot+=score;
		}
		avg = (double)tot/3;
		
		System.out.println("총 점수 개수: "+cnt+"개");
		System.out.println("총 점수: "+tot+"점");
		System.out.println("평균: "+avg+"점");

	}

}
