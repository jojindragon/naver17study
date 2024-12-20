package day1220;

/* 패키지가 다른 경우의 접근 */
import day1220_2.DbServerSystem;

class DataProcess extends DbServerSystem {
	private String sql;

	public DataProcess() {
		// protected - 상속관계인 경우 직접 접근 가능
		sql = "select";
//		this.dbServerName = "Mysql";
//		this.serverPort = 9000; - default 멤버 변수: 상속관계여도 접근 불가
	}

	public DataProcess(String dbServerName, int serverPort, String sql) {
		super(dbServerName, serverPort);
		this.sql = sql;
	}

	public void process() {
		// 오버라이드 한 것이 아니기 때문에 this로 호출해도 상속 받은 메소드가 호출
		// 오버라이드 메소드 존재 시 부모 메소드는 반드시 super로 호출
		this.serverStart();
		System.out.println("SQL문: " + sql + " 처리 완료");
		this.serverClose();
	}

}

public class Ex3Inheri {

	public static void main(String[] args) {
		DataProcess dp1 = new DataProcess();
		dp1.process();
		System.out.println();

		DataProcess dp2 = new DataProcess("MariaDB", 3000, "delete");
		dp2.process();
	}

}
