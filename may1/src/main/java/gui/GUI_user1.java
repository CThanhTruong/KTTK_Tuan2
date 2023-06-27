package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Redis.RedisPub;
import Redis.RedisSub;

public class GUI_user1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextArea textarea;
	private JButton btnSend, btnClose;
	private JTextField txtContent;
	public void init() {
		this.setTitle("User1");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		textarea = new JTextArea();
		this.add(textarea);
		textarea.setBounds(10, 10, 560, 300);
		btnSend = new JButton("Send");
		this.add(btnSend);
		btnSend.setBounds(200, 500, 100, 30);
		txtContent = new JTextField();
		this.add(txtContent);
		txtContent.setBounds(50, 350, 500, 60);
		btnClose = new JButton("Close");
		this.add(btnClose);
		btnClose.setBounds(310, 500, 100, 30);
		btnSend.addActionListener(this);
		btnClose.addActionListener(this);
		this.setVisible(true);
		
	}
	
	
	public static void setTextArea(String text) {
		textarea.append(text + "\n");
	}
	
	
	public static void main(String[] args) throws Exception {
		
		new GUI_user1().init();
		RedisSub.subscriber();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnSend)) {
			try {
				RedisPub.publisher("User1: " + txtContent.getText() + "\n");
				//textarea.append("User1: " + txtContent.getText() + "\n");
				txtContent.setText("");
				txtContent.requestFocus();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(obj.equals(btnClose)) {
		
			System.exit(0);
			
		}
		
	}

}
