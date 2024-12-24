package MultiChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientBack extends Thread {
	private String nickName, IPAddress;
	private int port;
	private Socket socket;
	private String message;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientChatGUI chatGUI;
	ArrayList<String> nickNameList = new ArrayList<String>(); // 유저 목록

	public void getUserInfo(String nickName, String IPAddress, int port) {
		// ClientGUI에서 닉네임, IP, Port 값 받기
		this.nickName = nickName;
		this.IPAddress = IPAddress;
		this.port = port;
	}

	public void setGUI(ClientChatGUI chatGUI) {
		// 실행했던 ClientChatGUI 자체 정보 가져오기
		this.chatGUI = chatGUI;
	}

	public void run() {
		// 서버 접속 실행
		try {
			socket = new Socket(IPAddress, port);
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			out.writeUTF(nickName);

			while (in != null) {
				// 임의의 식별자를 받아 닉네임, 일반 메시지 등을 구분
				message = in.readUTF();
				if (message.contains("***닉네임 시작***")) {
					chatGUI.userList.setText(null);
					nickNameList.add(message.substring(12));
					chatGUI.AppendUserList(nickNameList);

				} else if (message.contains("님 입장")) {
					// 입장 식별자를 받았으므로 기존 리스트 초기화 후 갱신
					nickNameList.clear();
					chatGUI.userList.setText(null);
					chatGUI.AppendMessage(message);

				} else if (message.contains("님 퇴장")) {
					// 입장과 퇴장 마찬가지
					nickNameList.clear();
					chatGUI.userList.setText(null);
					chatGUI.AppendMessage(message);

				} else {
					// 위 값이 모두 아니면 일반 메시지로 간주
					chatGUI.AppendMessage(message);
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Transmit(String message) {
		// 입력받은 값을 서버로 전송(out)
		try {
			out.writeUTF(message);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
