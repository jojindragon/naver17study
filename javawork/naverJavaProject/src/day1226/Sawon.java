package day1226;

// 데이터 클래스
public class Sawon {
	private String sawonName;
	private String hp;
	private String addr;
	private int age;

	public Sawon() {

	}

	public Sawon(String sawonName, int age, String hp, String addr) {
		super();
		this.sawonName = sawonName;
		this.age = age;
		this.hp = hp;
		this.addr = addr;
	}

	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
