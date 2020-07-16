package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerCliente;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;

@SuppressWarnings("all")
public class LoginCliente extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private static String titolo = "TOTAL CINEMA POINT - Log-in";
	private static Point p = new Point();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente frame = new LoginCliente(p);
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//LOGIN
	public LoginCliente(final Point p) {
		super(titolo);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		if(p != null) {
			setLocation(p);
		}else {
			setLocationRelativeTo(null);
		}	

		ImageIcon imgIco = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/LOGO.png"));	
		setIconImage(imgIco.getImage());

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
					ControllerCliente.logIn(userField.getText(), passwordField.getText());
					MenuCliente menu = new MenuCliente(getLocation());
					menu.setVisible(true);
					dispose();
				} catch (RemoteException | NotBoundException e1) {
					String[] messaggi = e1.getMessage().split(":");
					if (messaggi.length != 3) {
						JOptionPane.showMessageDialog(null, "Si sono verificati problemi di linea, \ncontrolla la tua connessione!", "Avviso", JOptionPane.ERROR_MESSAGE);
					}
					else if(e1.getMessage().split(":")[2].equals(" Log-in fallito!")) {
						JOptionPane.showMessageDialog(null, "Log-in fallito!\nCredenziali non valide", "Avviso", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Si sono verificati problemi di linea, \ncontrolla la tua connessione!", "Avviso", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientMain cm = new ClientMain(getLocation());
				cm.setVisible(true);
				dispose();
			}
		});
	}
}
