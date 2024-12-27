package day1227;

/* 멀티 스레드: 하나의 프로세스에서 여러 개의 스레드가 병행 처리되는 것 */

public class Ex4Thread extends Thread {
	String msg;
	int cnt;

	public Ex4Thread(String msg, int cnt) {
		this.msg = msg;
		this.cnt = cnt;
	}

	@Override
	public void run() {
		for (int i = 1; i <= cnt; i++)
			System.out.println(msg + ": " + cnt);

	}

	public static void main(String[] args) {
		Ex4Thread ex1 = new Ex4Thread("1번 Thread", 300);
		Ex4Thread ex2 = new Ex4Thread("2번 Thread", 300);
		Ex4Thread ex3 = new Ex4Thread("3번 Thread", 300);

		// run 메소드 호출 - start
		ex1.start();
		ex2.start();
		ex3.start();

	}

}
