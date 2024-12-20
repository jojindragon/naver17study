package day1219;
/*
 * 멤버 변수 - 사원명 sawonName, 직급 positino, 가족수 famSu
 * 
 * 디폴트 생성자
 * 사원명, 직급, 가족수를 인자로 받는 생성자 => 총 생성자 2개 
 * 
 * setter & getter method
 * 
 * 직급에 따라 기본급을 구하기 - getGibonPay()
 * 부장 > 450, 과장 > 300, 대리 > 250, 사원 > 150
 * 
 * 직급에 따라 수당 구하기 - getSudang()
 * 부장, 과장 > 70, 대리, 사원 > 50
 * 
 * 기본급 함수를 반환받아서 세금 5%를 구해서 반환 - getTax()
 * 
 * 가족수가 5인 이상이면 > 30, 5인 미만 2인 이상 > 10, 나머지 0 
 * getFamSudang()
 * 
 * 실수령액을 구해 반환 - 기본급+수당-세금+가족수당
 * getNetPay()
 */

public class Sawon {
	private String sawonName;
	private String position;
	private int famSu;

	public Sawon() {
		super();
//		sawonName = "아무개";
//		position = "사원";
	}

	public Sawon(String sawonName, String position, int famSu) {
		this.sawonName = sawonName;
		this.position = position;
		this.famSu = famSu;
	}

	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getFamSu() {
		return famSu;
	}

	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}

	public int getGibonPay() {
		return switch (position) {
		case "부장" -> 4500000;
		case "과장" -> 3000000;
		case "대리" -> 2500000;
		case "사원" -> 1500000;
		default -> 0;
		};
	}

	public int getSudang() {
		return switch (position) {
		case "부장", "과장" -> 700000;
		case "대리", "사원" -> 500000;

		default -> 0;
		};

	}

	public int getTax() {
		return (int) (getGibonPay() * 0.05);
	}

	public int getFamSudang() {
		if (famSu >= 5)
			return 300000;
		else if (famSu >= 2)
			return 100000;
		else
			return 0;
	}

	public int getNetPay() {
		return getGibonPay() + getSudang() - getTax() + getFamSudang();
	}

}
