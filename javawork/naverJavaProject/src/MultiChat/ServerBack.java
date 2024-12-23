package MultiChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class ServerBack extends Thread {
	// 클라이언트 쓰레드 저장
	Vector<ReceiveInfo> clientList = new Vector<ReceiveInfo>();
	// 클라이언트 닉네임 저장
	ArrayList<String> nickNameList = new ArrayList<String>();

	ServerSocket serverSocket;
	Socket socket;
	private ServerChatGUI serverChatGUI;

	public void setGUI(ServerChatGUI serverChatGUI) {
		this.serverChatGUI = serverChatGUI;
	}

	public void StartServer(int port) {
		try {
			// 교통정리 - clientList를 네트워크 처리
			Collections.synchronizedList(clientList);

			// 서버에 입력된 특정 port만 접속 허가
			serverSocket = new ServerSocket(port);
			System.out.println("현재 IP & Port Number: [" + InetAddress.getLocalHost() + "&" + port + "]");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void run() {
		try {
			nickNameList.add("Admin"); // 유저 목록 첫번째 서버(Admin) 추가

			while (true) {
				System.out.println("신규 접속 대기...");
				socket = serverSocket.accept(); // 포트 번호와 일치한 Client 소켓 받기
				System.out.println("[" + socket.getInetAddress() + "] 접속");

				ReceiveInfo receive = new ReceiveInfo(socket);
				clientList.add(receive);
				receive.start();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void TransmitAll(String message) {
		// 모든 클라이언트에 메시지 전송
		for (int i = 0; i < clientList.size(); i++) {
			try {
				ReceiveInfo receive = clientList.elementAt(i);
				receive.Transmit(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void removeClient(ReceiveInfo client, String nickName) {
		// 유저 퇴장 시 목록에서 삭제
		clientList.removeElement(client);
		nickNameList.remove(nickName);
		System.out.println(nickName + " 삭제 완료");

		serverChatGUI.userList.setText(null);
		serverChatGUI.AppendUserList(nickNameList);
	}

	class ReceiveInfo extends Thread {
		// 각 네트워크(Client)에게 소켓을 받아 다시 반출하는 역할
		private DataInputStream in;
		private DataOutputStream out;

		String nickName;
		String message;

		public ReceiveInfo(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());

				nickName = in.readUTF();
				nickNameList.add(nickName);

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		public void run() {
			try {
				// 신규 유저 발생 -> 유저목록 초기화 -> 새롭게 유저 목록 입력
				// 신규 유저 입장 소식 모든 유저에게 전송
				serverChatGUI.userList.setText(null);
				serverChatGUI.AppendUserList(nickNameList);

				TransmitAll(nickName + "님 입장\n");
				for (int i = 0; i < nickNameList.size(); i++) {
					// ***닉네임 시작*** - 닉네임을 알게 해주는 식별자, 더욱 암호화된 값으로 혼동 발생 방지
					TransmitAll("***닉네임 시작***" + nickNameList.get(i));
				}

				serverChatGUI.AppendMessage(nickName + "님 입장\n");
				while (true) {
					message = in.readUTF();
					serverChatGUI.AppendMessage(message);
					TransmitAll(message);
				}

			} catch (Exception e) {
				// 유저가 접속을 종료 시 오류 발생 -> 발생 값을 다시 모든 Client에 전송
				System.out.println(nickName + "님 퇴장");
				removeClient(this, nickName);
				TransmitAll(nickName + "님 퇴장\n");
				for (int i = 0; i < nickNameList.size(); i++)
					TransmitAll("***닉네임 시작***" + nickNameList.get(i));
				serverChatGUI.AppendMessage(nickName + "님 퇴장\n");

			}
		}

		public void Transmit(String message) {
			// 전달받은 값(message)를 각 클라이언트 쓰레드에 맞춰 전송
			try {
				out.writeUTF(message);
				out.flush();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

	}

}
