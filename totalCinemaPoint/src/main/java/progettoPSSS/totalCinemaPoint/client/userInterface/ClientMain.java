package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

@SuppressWarnings("all")
public class ClientMain extends JFrame {

	private JPanel contentPane;
	private BufferedImage img;

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
		
		
		JButton clienteButton = new JButton("Clienti");
		clienteButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		clienteButton.setBounds(663, 257, 374, 121);
		contentPane.add(clienteButton);
		clienteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton gestoreCinemaButton = new JButton("Gestori");
		gestoreCinemaButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		gestoreCinemaButton.setBounds(663, 436, 374, 121);
		contentPane.add(gestoreCinemaButton);
		gestoreCinemaButton.setEnabled(false);
		gestoreCinemaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel sfondoLabel = new JLabel("");
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/clientMainofficial.jpg"));		
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(sfondoLabel);
		
		
		clienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginCliente l = new LoginCliente();
				l.setVisible(true);
				dispose();
			}
		});
	}
}
