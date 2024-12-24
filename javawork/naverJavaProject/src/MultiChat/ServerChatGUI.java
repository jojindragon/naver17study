package MultiChat;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class ServerChatGUI extends JFrame implements ActionListener, KeyListener {
	// 서버용 채팅창
	JPanel serverGUIPanel = new JPanel();
	JLabel serverLabel = new JLabel("Main Server");
	JLabel userLabel = new JLabel("유저 목록");
	JTextField chat = new JTextField(45);
	JButton enter = new JButton("전송");
	TextArea serverChatList = new TextArea(30, 50);
	TextArea userList = new TextArea(30, 15);

	ServerBack sb = new ServerBack();

	public ServerChatGUI(int port) {
		setTitle("메인 서버");
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(750, 520);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 메로리 제거 설정

		serverChatList.setEditable(false);
		userList.setEditable(false);
		chat.addKeyListener(this);
		enter.addActionListener(this);

		serverGUIPanel.add(serverLabel);
		serverGUIPanel.add(serverChatList);
		serverGUIPanel.add(userLabel);
		serverGUIPanel.add(userList);
		serverGUIPanel.add(chat);
		serverGUIPanel.add(enter);
		add(serverGUIPanel);

		// 실행과 동시에 Admin을 유저 목록에 추가
		userList.append("Admin\n");
		sb.setGUI(this);
		sb.StartServer(port);
		sb.start(); // 서버 채팅창과 서버소켓 동시 On
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Enter 키를 누르고, 입력값 1 이상만 전송
		String message = chat.getText().trim();
		if(e.getSource() == enter && message.length() >0) {
			AppendMessage("서버: " + message + "\n");
			sb.TransmitAll("서버: " + message + "\n");
			chat.setText(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 전송버튼을 누르고, 입력값 1 이상만 전송
		String message = chat.getText().trim();
		if (e.getSource() == enter && message.length() > 0) {
			AppendMessage("서버: " + message + "\n");
			sb.TransmitAll("서버: " + message + "\n");
			// 채팅창 입력값 초기화
			chat.setText(null);
		}

	}

	public void AppendMessage(String message) {
		serverChatList.append(message);
	}

	public void AppendUserList(ArrayList nickName) {
		String name;
		for (int i = 0; i < nickName.size(); i++) {
			name = (String) nickName.get(i);
			userList.append(name + "\n");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
