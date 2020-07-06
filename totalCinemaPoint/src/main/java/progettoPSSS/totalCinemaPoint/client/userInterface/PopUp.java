package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerClientSingleton;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class PopUp extends JFrame {

	private JPanel contentPane;
	private static int mex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUp frame = new PopUp(mex);
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
	public PopUp(final int mex) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel riepilogoLabel = new JLabel("");
		riepilogoLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		riepilogoLabel.setBounds(96, 33, 205, 121);
		contentPane.add(riepilogoLabel);
		
		JButton tornaButton = new JButton("");
		tornaButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tornaButton.setBounds(81, 167, 230, 57);
		contentPane.add(tornaButton);
		
		if(mex == 0) {
			riepilogoLabel.setText("\"<html>UNO O PIU' DEI POSTI SCELTI <br/>  RISULTA ESSERE OCCUPATO! </html>\"");
			tornaButton.setText("Torna alla scelta dei posti");
		}else {
			riepilogoLabel.setText("\"<html>PAGAMENTO AVVENUTO <br/>  &nbsp &nbsp &nbsp CON SUCCESSO! </html>\"");
			tornaButton.setText("Torna al Menù Principale");
		}
		
		tornaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mex == 0) {
					String [] filmInfo = ControllerClientSingleton.getDatiFilm().split("\n");
			    	System.out.println(filmInfo[0]);
			    	ControllerClientSingleton.getSpettacoliDate(filmInfo[0]);
			    	Map<String,String> mappa = ControllerClientSingleton.getPosti(ControllerClientSingleton.getDataSpettacoloSelezionato(), ControllerClientSingleton.getOraSpettacoloSelezionato());
					PrenotaSpettacolo ps = new PrenotaSpettacolo(mappa);
					ps.setVisible(true);
					dispose();
				}
				else {
					MenuCliente mc = new MenuCliente();
					mc.setVisible(true);
					dispose();
				}
			}
		});
		
	}
}
