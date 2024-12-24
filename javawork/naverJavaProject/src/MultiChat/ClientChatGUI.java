package MultiChat;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientChatGUI extends JFrame implements ActionListener, KeyListener {
	// Client 채팅창
	String nickName;
	ClientBack cb = new ClientBack();
	JPanel clientGUIPanel = new JPanel();
	JLabel userLabel = new JLabel("유저 목록");
	JLabel user = new JLabel(nickName);
	JTextField chat = new JTextField(45);
	JButton enter = new JButton("전송");
	TextArea chatList = new TextArea(30, 50);
	TextArea userList = new TextArea(30, 15);

	public ClientChatGUI(String nickName, String ipAddress, int port) {
		// 생성자
		this.nickName = nickName;

		setTitle("고객 창");
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(750, 530);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		chatList.setEditable(false);
		userList.setEditable(false);
		chat.addKeyListener(this);
		enter.addActionListener(this);

		clientGUIPanel.add(user);
		clientGUIPanel.add(chatList);
		clientGUIPanel.add(userLabel);
		clientGUIPanel.add(userList);
		clientGUIPanel.add(chat);
		clientGUIPanel.add(enter);
		add(clientGUIPanel);

		cb.setGUI(this);
		cb.getUserInfo(nickName, ipAddress, port);
		cb.start(); // 채팅창 켜지면 동시에 접속 실행
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 전송 버튼, 입력 값 1 이상
		String message = chat.getText().trim();
		if (e.getSource() == enter && message.length() > 0) {
			cb.Transmit(nickName + " : " + message + "\n");
			chat.setText(null);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 엔터키, 입력 값 1 이상
		String message = chat.getText().trim();
		if (e.getKeyCode() == KeyEvent.VK_ENTER && message.length() > 0) {
			cb.Transmit(nickName + " : " + message + "\n");
			chat.setText(null);
		}
	}

	public void AppendMessage(String message) {
		chatList.append(message);
	}

	public void AppendUserList(ArrayList nickName) {
		// 유저목록 띄우기
		String name;
		userList.setText(null);
		for (int i = 0; i < nickName.size(); i++) {
			name = (String) nickName.get(i);
			userList.append(name + "\n");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
