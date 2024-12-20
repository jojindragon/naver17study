package day1220_2;

public class DbServerSystem {
	// default 접근 지정자 -> protected 수정
	protected String dbServerName;
	int serverPort;

	public DbServerSystem() {
		dbServerName = "Oracle";
		serverPort = 8080;
	}

	public DbServerSystem(String dbServerName) {
		this.dbServerName = dbServerName;
		this.serverPort = 8080;
	}

	public DbServerSystem(String dbServerName, int serverPort) {
		this.dbServerName = dbServerName;
		this.serverPort = serverPort;
	}

	public void serverStart() {
		System.out.println(serverPort + " Port 로 " + dbServerName + " DB 세팅 완료");
	}

	public void serverClose() {
		System.out.println(dbServerName + " DB Close");
	}

}
