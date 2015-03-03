package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import model.User;
import Controller.DBWrapper;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static LogIn frame = new LogIn();
	private JPasswordField passwordField;
	User user;
	

	/**
	 * Launch the application.
	 */
	public void CloseJframe(){
        super.dispose();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
					DBWrapper.connect();
					DBWrapper.createTables();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(6, 18, 89, 16);
		contentPane.add(lblUserName);
		
		final JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(6, 46, 77, 16);
		contentPane.add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setBounds(6, 72, 61, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(110, 12, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogOn = new JButton("Log on");
		btnLogOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=textField.getText();
				String password= passwordField.getText();
			
//				user= new User("lina", "sara2004");
//				if(user.getName()== "lina" && user.getPassword()=="sara2004")
//				{
//					
//					ClientGUI cGui= new ClientGUI("localhost", 1500);
//					cGui.setVisible(true);
//					cGui.tf.setText(name);
//					CloseJframe();
//				}
				if(DBWrapper.authenticate(name, password))
				{
					ServerGUI gui= new ServerGUI(1500);
					ClientGUI cGui= new ClientGUI("localhost", 1500);
					cGui.setVisible(true);
					cGui.tf.setText(name);
					CloseJframe();
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong username or password! ");
				}
				
			
				
				
						
			}
		});
		btnLogOn.setBounds(6, 74, 134, 29);
		contentPane.add(btnLogOn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 40, 134, 28);
		contentPane.add(passwordField);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBounds(154, 79, 36, 16);
		contentPane.add(lblOr);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register reg= new Register();
				reg.setVisible(true);
				CloseJframe();
			}
		});
		btnRegister.setBounds(183, 74, 134, 29);
		contentPane.add(btnRegister);
	}
}
