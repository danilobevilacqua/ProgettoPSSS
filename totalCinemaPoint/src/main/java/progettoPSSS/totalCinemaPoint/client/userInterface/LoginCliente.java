package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerClientSingleton;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
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
		
		JLabel lblNewLabel = new JLabel("o");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(880, 625, 25, 33);
		contentPane.add(lblNewLabel);
		
		JLabel registratiLabel = new JLabel("<HTML><U>Registrati</U></HTML>");
		registratiLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		registratiLabel.setForeground(new Color(255, 255, 255));
		registratiLabel.setBounds(703, 625, 165, 37);
		contentPane.add(registratiLabel);
		registratiLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registratiLabel.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e)  
		    {}  
		}); 
		
		
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		userField.setBounds(720, 320, 347, 49);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(720, 450, 347, 49);
		contentPane.add(passwordField);
		
		JButton accessButton = new JButton("Accedi");
		accessButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		accessButton.setBounds(926, 620, 141, 49);
		contentPane.add(accessButton);
		accessButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		final JLabel erroreLabel = new JLabel("Credenziali non valide!");
		erroreLabel.setForeground(Color.RED);
		erroreLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		erroreLabel.setBounds(720, 518, 360, 62);
		contentPane.add(erroreLabel);
		erroreLabel.setVisible(false);
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		indietroButton.setBounds(50, 620, 141, 49);
		contentPane.add(indietroButton);
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel sfondoLabel = new JLabel("New label");
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/logincliente.jpg"));		
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(sfondoLabel);
		
		
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
