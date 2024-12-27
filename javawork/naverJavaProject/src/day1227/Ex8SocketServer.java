package day1227;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex8SocketServer extends Thread {

	ServerSocket serverSocket;

	@Override
	public void run() {
		System.out.println("** 서버 소켓 생성 **");

		try {
			serverSocket = new ServerSocket(8000);
			System.out.println("생성 성공!");

			while (true) {
				// 접속한 클라이언트 허용 후 소켓 획득
				Socket socket = serverSocket.accept();
				System.out.println("접속한 Client IP: " + socket.getInetAddress().getHostAddress());

			}
		} catch (IOException e) {
			System.out.println("서버 소켓 생성 실패!" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Ex8SocketServer server = new Ex8SocketServer();
		server.start(); // run 메소드 호출
	}

}
