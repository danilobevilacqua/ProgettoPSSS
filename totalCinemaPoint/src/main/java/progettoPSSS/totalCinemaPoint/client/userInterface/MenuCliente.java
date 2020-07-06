package progettoPSSS.totalCinemaPoint.client.userInterface;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		sceltaButton.setBounds(647, 86, 352, 108);
		contentPane.add(sceltaButton);

		JButton gestioneButton = new JButton("Gestisci Profilo");
		gestioneButton.setEnabled(false);
		gestioneButton.setBounds(647, 234, 352, 115);
		contentPane.add(gestioneButton);

		JButton visualizzaButton = new JButton("Visualizza Prenotazioni");
		visualizzaButton.setEnabled(false);
		visualizzaButton.setBounds(647, 396, 352, 115);
		contentPane.add(visualizzaButton);
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.setBounds(50, 620, 141, 49);
		contentPane.add(indietroButton);

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