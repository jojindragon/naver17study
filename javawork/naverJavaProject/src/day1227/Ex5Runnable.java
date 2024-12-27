package day1227;

/*
 * Java - 다중상속 불가 
 * => 이미 다른 클래스를 상속받고 있을 시 더 이상 Thread 상속 불가
 * => 인터페이스 Runnable 구현해 Thread 구현
 */

public class Ex5Runnable implements Runnable {
	String msg;
	int cnt;

	public Ex5Runnable(String msg, int cnt) {
		this.msg = msg;
		this.cnt = cnt;
	}

	@Override
	public void run() {
		for (int i = 1; i <= cnt; i++)
			System.out.println(msg + ": " + cnt);
	}

	public static void main(String[] args) {
		Ex5Runnable ex1 = new Ex5Runnable("1번 Thread", 30);
		Ex5Runnable ex2 = new Ex5Runnable("2번 Thread", 30);
		Ex5Runnable ex3 = new Ex5Runnable("3번 Thread", 30);

		Thread th1 = new Thread(ex1);
		Thread th2 = new Thread(ex2);
		Thread th3 = new Thread(ex3);

		// run 메서드 호출
		th1.start();
		th2.start();
		th3.start();

	}

}
