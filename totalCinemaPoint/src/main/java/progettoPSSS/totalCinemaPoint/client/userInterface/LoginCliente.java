package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerClientSingleton;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("all")
public class LoginCliente extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente frame = new LoginCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//LOGIN
	public LoginCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(418, 215, 305, 49);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(418, 300, 305, 49);
		contentPane.add(passwordField);
		
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(131, 231, 127, 31);
		contentPane.add(userLabel);
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setBounds(131, 316, 56, 16);
		contentPane.add(passwordLabel);
		
		JButton accessButton = new JButton("Accedi");
		accessButton.setBounds(418, 477, 227, 84);
		contentPane.add(accessButton);
		
		final JLabel erroreLabel = new JLabel("Credenziali non valide, nabbo");
		erroreLabel.setForeground(Color.RED);
		erroreLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		erroreLabel.setBounds(260, 597, 633, 62);
		contentPane.add(erroreLabel);
		erroreLabel.setVisible(false);
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.setBounds(50, 620, 141, 49);
		contentPane.add(indietroButton);
		
		
		//LOGICA
		accessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					erroreLabel.setVisible(false);
					ControllerClientSingleton.logIn(userField.getText(), passwordField.getText());
					MenuCliente menu = new MenuCliente();
					menu.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
					erroreLabel.setVisible(true);
				}
			}
		});
		
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientMain cm = new ClientMain();
				cm.setVisible(true);
				dispose();
			}
		});
	}
}
