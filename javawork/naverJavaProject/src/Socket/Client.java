package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		BufferedReader in = null;
		PrintWriter out = null;

		Socket socket = null;
		Scanner sc = new Scanner(System.in);

		try {
			socket = new Socket("127.0.0.1", 8000);

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());

			while (true) {
				System.out.print("전송 >> ");
				String outputMessage = sc.nextLine();
				out.println(outputMessage);
				out.flush();

				if (outputMessage.equalsIgnoreCase("quit"))
					break;

				String inputMessage = in.readLine();
				System.out.println("Server: " + inputMessage);

				if (inputMessage.equalsIgnoreCase("quit"))
					break;
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				sc.close();
				if (socket != null)
					socket.close();
				System.out.println("서버 연결 종료");
			} catch (IOException e2) {
				System.out.println("소켓 통신 에러");
			}
		}

	}

}
