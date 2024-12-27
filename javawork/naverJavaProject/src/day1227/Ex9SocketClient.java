package day1227;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex9SocketClient {

	public static void main(String[] args) {
		// 강사 PC IP
//		String ip = "192.168.0.26";
		String ip = "127.0.0.1";
		Socket socket = null;

		try {
			socket = new Socket(ip, 8000);
			System.out.println("서버 접속 성공!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("서버 접속 실패: " + e.getMessage());
		}

	}

}
