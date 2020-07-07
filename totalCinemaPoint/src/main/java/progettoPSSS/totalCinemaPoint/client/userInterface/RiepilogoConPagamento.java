package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerClientSingleton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class RiepilogoConPagamento extends JFrame {

	private JPanel contentPane;
	private static Map<String,String> mappaPosti;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RiepilogoConPagamento frame = new RiepilogoConPagamento(mappaPosti);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RiepilogoConPagamento(final Map<String,String> mappaPosti) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel sfondoLabel = new JLabel("");
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/riepilogoConPagamento.jpg"));		

		final JButton indietroButton = new JButton("Indietro");
		indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		indietroButton.setBounds(50, 620, 141, 49);
		contentPane.add(indietroButton);
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel importoLabel = new JLabel("New label");
		importoLabel.setForeground(Color.WHITE);
		importoLabel.setBounds(926, 436, 71, 43);
		contentPane.add(importoLabel);

		final JButton confermaButton = new JButton("Conferma");
		confermaButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confermaButton.setBounds(926, 620, 141, 49);
		contentPane.add(confermaButton);
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(sfondoLabel);

		final Double prezzo = ControllerClientSingleton.calcolaImporto(mappaPosti);
		importoLabel.setText(prezzo.toString());

		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int codice = ControllerClientSingleton.prenota(mappaPosti, prezzo);			
					confermaButton.setEnabled(false);
					indietroButton.setEnabled(false);
					
					JOptionPane.showMessageDialog(null, "Prenotazione effettuata con successo! \n Il codice della prenotazione è: "+codice, "Avviso", JOptionPane.INFORMATION_MESSAGE);
					
					MenuCliente mc = new MenuCliente();
					mc.setVisible(true);
					dispose();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					confermaButton.setEnabled(false);
					indietroButton.setEnabled(false);
					tornaSceltaPosto(false);
				} 
			}
		});

		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tornaSceltaPosto(true);
			}
		});		

	}
	
	private void tornaSceltaPosto(boolean indietroFlag) {
		
		String [] filmInfo = ControllerClientSingleton.getDatiFilm().split("\n");
		System.out.println(filmInfo[0]);
		ControllerClientSingleton.getSpettacoliDate(filmInfo[0]);
		Map<String, String> mappa;
		try {
			
			mappa = ControllerClientSingleton.getPosti(ControllerClientSingleton.getDataSpettacoloSelezionato(), ControllerClientSingleton.getOraSpettacoloSelezionato());
			if(!indietroFlag) {
				JOptionPane.showMessageDialog(null, "Uno o più dei posti scelti risulta essere stato occupato!", "Avviso", JOptionPane.ERROR_MESSAGE);
			}
			PrenotaSpettacolo ps = new PrenotaSpettacolo(mappa);
			ps.setVisible(true);
			dispose();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Gli ultimi posti sono stati occupati \n prima della tua prenotazione!", "Avviso", JOptionPane.ERROR_MESSAGE);
			SceltaSpettacolo sc = new SceltaSpettacolo();
			sc.setVisible(true);
			dispose();
		}
		
	}

}
