package progettoPSSS.totalCinemaPoint.client.userInterface;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("all")
public class MenuCliente extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente frame = new MenuCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton sceltaButton = new JButton("Scegli Spettacolo");
		sceltaButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		sceltaButton.setBounds(647, 177, 352, 108);
		contentPane.add(sceltaButton);
		sceltaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton gestioneButton = new JButton("Gestisci Profilo");
		gestioneButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		gestioneButton.setEnabled(false);
		gestioneButton.setBounds(647, 316, 352, 115);
		contentPane.add(gestioneButton);

		JButton visualizzaButton = new JButton("Visualizza Prenotazioni");
		visualizzaButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		visualizzaButton.setEnabled(false);
		visualizzaButton.setBounds(647, 457, 352, 115);
		contentPane.add(visualizzaButton);
				
		JButton indietroButton = new JButton("Indietro");
		indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		indietroButton.setBounds(50, 620, 141, 49);
		contentPane.add(indietroButton);
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		JLabel sfondoLabel = new JLabel("New label");
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/menucliente.jpg"));		
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(sfondoLabel);

		sceltaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SceltaSpettacolo s = new SceltaSpettacolo();
				s.setVisible(true);
				dispose();
			}
		});
		
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginCliente l = new LoginCliente();
				l.setVisible(true);
				dispose();
			}
		});


	}
}
