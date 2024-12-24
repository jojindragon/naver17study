package MultiChat;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginGUI extends JFrame implements ActionListener {
	// 유저 로그인 창
	private JPanel loginGUIPanel = new JPanel();
	private JTextField nickNameText = new JTextField(20);
	private JTextField portText = new JTextField("####", 20);
	private JTextField ipAddressText = new JTextField("###.###.###.###", 20);
	private JLabel nickNameLabel = new JLabel("유저 입력");
	private JLabel portLabel = new JLabel("포트 입력");
	private JLabel ipAddressLabel = new JLabel("주소 입력");
	private JButton loginGUIButton = new JButton("접속!");

	public LoginGUI() {
		// 생성자
		setTitle("로그인 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300, 170);
		setResizable(false);
		setVisible(true);

		loginGUIButton.setPreferredSize(new Dimension(260, 40));
		loginGUIButton.addActionListener(this);

		loginGUIPanel.add(nickNameLabel);
		loginGUIPanel.add(nickNameText);
		loginGUIPanel.add(portLabel);
		loginGUIPanel.add(portText);
		loginGUIPanel.add(ipAddressLabel);
		loginGUIPanel.add(ipAddressText);
		loginGUIPanel.add(loginGUIButton);
		add(loginGUIPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 닉네임, IP, Port 값을 버튼으로 입력
		try {
			if (e.getSource() == loginGUIButton) {
				String nickName = nickNameText.getText().trim();
				String ipAddress = ipAddressText.getText().trim();
				int port = Integer.parseInt(portText.getText().trim());

				new ClientChatGUI(nickName, ipAddress, port);
				setVisible(false);

			}

		} catch (Exception e2) {
			// 올바르지 않은 값 -> 팝업창 띄우기
			JOptionPane.showMessageDialog(null, "올바르지 않은 입력!");
		}

	}

}
