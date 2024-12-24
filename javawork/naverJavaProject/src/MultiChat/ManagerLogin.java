package MultiChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManagerLogin extends JFrame implements ActionListener, KeyListener {
	// 로그인 창
	ServerChatGUI serverChat = null;
	JPanel portLog = new JPanel();
	JLabel portLable = new JLabel("입력을 허용할 포트 번호를 입력하세요.");
	JLabel portWarning = new JLabel("(포트 번호: 0 ~ 65535)");
	JTextField portText = new JTextField(20);
	JButton portEnter = new JButton("접속!");

	public ManagerLogin() {
		setTitle("서버 매니저 창");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 메모리 제거 설정
		setSize(300, 120);
		setVisible(true);
		setResizable(false);
		portEnter.addActionListener(this);
		portText.addKeyListener(this);

		portLog.add(portLable);
		portLog.add(portWarning);
		portLog.add(portText);
		portLog.add(portEnter);
		add(portLog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 클릭 시 작동
		try {
			int port = Integer.parseInt(portText.getText().trim());
			if (e.getSource() == portEnter) {
				serverChat = new ServerChatGUI(port);
				setVisible(false);
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "올바르지 않은 입력!");
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TextField에 값 입력 후 Enter 키 누르면 작동
		try {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				int port = Integer.parseInt(portText.getText().trim());
				serverChat = new ServerChatGUI(port);
				setVisible(false);
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "올바르지 않은 입력!");
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
