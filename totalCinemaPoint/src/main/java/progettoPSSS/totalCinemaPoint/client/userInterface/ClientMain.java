package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("all")
public class ClientMain extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMain frame = new ClientMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientMain() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ClienteButton = new JButton("Accesso per i clienti");
		ClienteButton.setBounds(353, 175, 404, 146);
		contentPane.add(ClienteButton);
		
		JButton GestoreCinemaButton = new JButton("Accesso per i gestori");
		GestoreCinemaButton.setBounds(353, 368, 404, 137);
		contentPane.add(GestoreCinemaButton);
		
		ClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginCliente l = new LoginCliente();
				l.setVisible(true);
				dispose();
			}
		});
	}
}
