package day1223;

abstract class AbstEx {
	abstract public void show();
}

interface MyDB {
	public void list();

	public void insert();
}

class SubMyDB implements MyDB {
	@Override
	public void list() {
		System.out.println("db 목록 출력2");

	}

	@Override
	public void insert() {
		System.out.println("db 데이터 추가2");

	}
}

public class Ex3InnerClass {

	// 익명 내부 클래스 형태로 구현
	AbstEx abst1 = new AbstEx() {

		@Override
		public void show() {
			System.out.println("show 호출");

		}
	};

	MyDB myDB = new MyDB() {

		@Override
		public void list() {
			System.out.println("db 목록 출력");

		}

		@Override
		public void insert() {
			System.out.println("db 데이터 추가");

		}
	};

	MyDB myDB2 = new SubMyDB();

	public static void main(String[] args) {
		Ex3InnerClass ex3 = new Ex3InnerClass();
		ex3.abst1.show();
		System.out.println();

		ex3.myDB.list();
		ex3.myDB.insert();
		System.out.println();

		ex3.myDB2.list();
		ex3.myDB2.insert();

	}

}
