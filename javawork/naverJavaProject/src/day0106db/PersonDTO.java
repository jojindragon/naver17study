package day0106db;

public class PersonDTO {
	private int num;
	private String name;
	private int age;
	private String blood;
	private String hp;

	public PersonDTO() {
	}

	public PersonDTO(String name, int age, String blood, String hp) {
		super();
		this.name = name;
		this.age = age;
		this.blood = blood;
		this.hp = hp;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

}
