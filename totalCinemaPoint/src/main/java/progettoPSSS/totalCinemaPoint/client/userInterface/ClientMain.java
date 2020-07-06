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
		
		
		JButton clienteButton = new JButton("CLIENTI");
		clienteButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		clienteButton.setBounds(155, 438, 248, 84);
		contentPane.add(clienteButton);
		
		JButton gestoreCinemaButton = new JButton("GESTORI");
		gestoreCinemaButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		gestoreCinemaButton.setBounds(749, 435, 255, 91);
		contentPane.add(gestoreCinemaButton);
		gestoreCinemaButton.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/clientmain2.jpg"));		
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(lblNewLabel);
		
		
		clienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginCliente l = new LoginCliente();
				l.setVisible(true);
				dispose();
			}
		});
	}
}
