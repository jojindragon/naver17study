package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		BufferedReader in = null;
		PrintWriter out = null;

		ServerSocket serverSocket = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);

		try {
			serverSocket = new ServerSocket(8000); // 포트번호

			System.out.println("[Server] Client 대기중...");
			socket = serverSocket.accept();

			System.out.println("Client 연결.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());

			while (true) {
				String inputMessage = in.readLine(); // 1줄씩 읽기
				if (inputMessage.equalsIgnoreCase("quit"))
					break;

				System.out.println("Client: " + inputMessage);
				System.out.print("전송 >> ");

				String outputMessage = sc.nextLine();
				out.println(outputMessage);
				out.flush();

				if (outputMessage.equalsIgnoreCase("quit"))
					break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				socket.close(); // 소켓 닫기
				serverSocket.close(); // 서버 소켓 닫기
				
				System.out.println("연결 종료");
			} catch (IOException e2) {
				System.out.println("소켓 통신 에러");
			}
		}

	}
}
