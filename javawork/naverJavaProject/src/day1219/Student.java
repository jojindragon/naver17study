package day1219;

import java.util.Calendar;

public class Student {
	private String name;
	private String address;
	private String blood;
	private int birthYear;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// 3가지 1번에 변경
	public void changeStudent(String name, String address, String blood) {
		this.setName(name);
		this.setAddress(address);
		this.setBlood(blood);
	}

	// score에 대한 절대평가 반환 메서드
	public char getScoreGrade() {
		char grade = switch (score / 10) {
		case 10, 9 -> 'A';
		case 8 -> 'B';
		case 7 -> 'C';
		case 6 -> 'D';
		default -> 'F';
		};

		return grade;
	}

	// 나이 반환
	public int getAge() {
		// 현재 년도
		Calendar c = Calendar.getInstance();
		int curYear = c.get(Calendar.YEAR);

		return curYear - birthYear;
	}

}
