package day1223;

abstract class AbstSawon {
	abstract public void addSawon();

	abstract public void removeSawon();
}

interface InterSales {
	public void insertSangpum();

	public void selectSangpum();
}

// 위의 클래스와 인터페이스를 익명 내부 클래스 형태로 구현 후 메인에서 호출
public class Ex4InnerClass {

	AbstSawon sawon = new AbstSawon() {

		@Override
		public void removeSawon() {
			System.out.println("사원 삭제");

		}

		@Override
		public void addSawon() {
			System.out.println("사원 추가");

		}
	};

	InterSales sales = new InterSales() {

		@Override
		public void selectSangpum() {
			System.out.println("상품 선택");

		}

		@Override
		public void insertSangpum() {
			System.out.println("상품 추가");

		}
	};

	public static void main(String[] args) {
		Ex4InnerClass ex4 = new Ex4InnerClass();
		ex4.sawon.addSawon();
		ex4.sawon.removeSawon();
		ex4.sales.insertSangpum();
		ex4.sales.selectSangpum();

	}

}
